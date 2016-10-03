package com.leeves.h.mytestnewdemo;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Function：
 * Created by h on 2016/9/30.
 *
 * @author Leeves
 */

public class DownBarView extends View implements Runnable,View.OnClickListener{
    //SRC_ATOP :在源图像和目标图像相交的地方绘制源图像，在不相交的地方绘制目标图像：取下层绘制非交集部分。
    private PorterDuffXfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
    private float MAX_PROGRESS = 100f;
    private Paint mBgPaint;
    private Paint mTextPaint;
    private Rect mTextBouds;
    private Canvas mPgCanvas;
    private int mTextSize;
    /**
     * 下载中颜色
     */
    private int mLoadingColor;
    /**
     * 停止颜色
     */
    private int mStopColor;

    private int mProgressColor;

    private Bitmap mFlikerBitmap;
    private Bitmap mPgBitmap;

    private float mFlikerLeft;

    private Thread mThread;


    /**
     * 当前进度条
     */
    private float progress;

    private boolean isStop;

    private boolean isFinish;
    private String mProgressText;

    public DownBarView(Context context) {
        this(context, null, 0);
    }

    public DownBarView(Context context, AttributeSet attrs) {
        this(context, null, 0);
    }

    public DownBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
    }

    /**
     * 设置arrs.xml的值
     *
     * @param attrs
     */
    private void initAttrs(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.DownBarView);
            mTextSize = (int) ta.getDimension(R.styleable.DownBarView_textSize, 12);
            mLoadingColor = ta.getColor(R.styleable.DownBarView_loadingColor, Color.parseColor("#40c4ff"));
            mStopColor = ta.getColor(R.styleable.DownBarView_stopColor, Color.parseColor("#ff9800"));
            ta.recycle();//回收TypedArray
        }
    }

    /**
     * 初始化
     */
    private void inti() {
        //用于绘制时抗锯齿
        mBgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //设置字体大小
        mTextPaint.setTextSize(mTextSize);
        mTextBouds = new Rect();
        mProgressColor = mLoadingColor;
        //获得发光图片及宽度
        mFlikerBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.flicker);
        mFlikerLeft = -mFlikerBitmap.getWidth();
        //对View上的内容进行测量后得到的View内容占据的宽度
        mPgBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        mPgCanvas = new Canvas(mPgBitmap);
        mThread = new Thread(this);
        mThread.start();
        Log.d("mFlikerLeft========================", "inti: " + mFlikerLeft);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 父容器传过来的宽度方向上的模式
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        // 父容器传过来的高度的值
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        // 父容器传过来的宽度的值
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int height = 0;
        switch (heightSpecMode) {
            //最大模式：就是父组件，能够给出的最大的空间，当前组件的长或宽最大只能为这么大，当然也可以比这个小。
            case MeasureSpec.AT_MOST:
                height = 35;
                break;
            //精确模式：在这种模式下，尺寸的值是多少，那么这个组件的长或宽就是多少。
            case MeasureSpec.EXACTLY:

                //未指定：当前组件，可以随便用空间，不受限制
            case MeasureSpec.UNSPECIFIED:
                height = heightSpecSize;
                break;
        }
        setMeasuredDimension(widthSpecSize, height);
        inti();
    }

    /**
     * 绘制进度条的边框
     *
     * @param canvas
     */
    private void drawBorder(Canvas canvas) {
        //设置画出的图形是空心的
        mBgPaint.setStyle(Paint.Style.STROKE);
        mBgPaint.setColor(mLoadingColor);
        mBgPaint.setStrokeWidth(dp2px(1));
        //左上右下，left和top是矩形的左上角的坐标，right和bottom是矩形的右下角的坐标，而paint则是画笔对象。而不是矩形的上下左右宽度等错误理解。
        canvas.drawRect(0, 0, getWidth(), getHeight(), mBgPaint);

    }

    /**
     * 绘制进度条
     */
    private void drawProgress() {
        //设置画出的图形是实心
        mBgPaint.setStyle(Paint.Style.FILL);
        mBgPaint.setStrokeWidth(0);
        mBgPaint.setColor(mProgressColor);
        //标志位没有保存相关的位移信息，restore的时候不能恢复
        mPgCanvas.save(Canvas.CLIP_SAVE_FLAG);
        //获得进度条在矩形的位置
        float right = (progress / MAX_PROGRESS) * getMeasuredWidth();
        //在当前矩形画出剪切图像
        mPgCanvas.clipRect(0, 0, right, getMeasuredHeight());
        mPgCanvas.drawColor(mProgressColor);
        //回到save();之前的状态，意思是不断刷新进度条
        mPgCanvas.restore();

        if (isStop) {
            mBgPaint.setXfermode(xfermode);
            mPgCanvas.drawBitmap(mFlikerBitmap, mFlikerLeft, 0, mBgPaint);
            //清除混合模式
            mBgPaint.setXfermode(null);
        }
    }

    /**
     * 进度条文本
     *
     * @param canvas
     */
    private void drawProgressText(Canvas canvas) {
        mTextPaint.setColor(mProgressColor);
        //获得不同状态的文字
        mProgressText = getProgressText();
        //调用了getTextBounds()方法来获取到整个文字框的宽度和高度
        mTextPaint.getTextBounds(mProgressText, 0, mProgressText.length(), mTextBouds);
        int tWidth = mTextBouds.width();
        int tHeight = mTextBouds.height();
        //设置文字框在整个进度条的中间，x,y坐标
        float xCoordinate = (getMeasuredWidth() - tWidth) / 2;
        float yCoordinate = (getMeasuredHeight() + tHeight) / 2;
        canvas.drawText(mProgressText, xCoordinate, yCoordinate, mTextPaint);
    }

    /**
     * 文字的变色处理
     *
     * @param canvas
     */
    private void drawColorProgressText(Canvas canvas) {
        mTextPaint.setColor(Color.WHITE);
        int tWidth = mTextBouds.width();
        int tHeight = mTextBouds.height();
        float xCoordinate = (getMeasuredWidth() - tWidth) / 2;
        float yCoordinate = (getMeasuredHeight() + tHeight) / 2;
        float progressWidth = (progress / MAX_PROGRESS) * getMeasuredWidth();

        //判断进度条是否大于文字
        if (progressWidth > xCoordinate) {
            canvas.save(Canvas.CLIP_SAVE_FLAG);
            float right = Math.min(progressWidth, xCoordinate + tWidth * 1.1f);
            canvas.clipRect(xCoordinate, 0, right, getMeasuredHeight());
            canvas.drawText(mProgressText, xCoordinate, yCoordinate, mTextPaint);
            canvas.restore();
        }
    }

    public void setProgress(float progress) {
        if (!isStop) {
            this.progress = progress;
            //请求重新onDraw() Canvas，但只会绘制调用者本身
            invalidate();
        }
    }

    /**
     * @param stop
     */
    public void setStop(boolean stop) {
        isStop = stop;
        if (isStop) {
            mProgressColor = mStopColor;
        } else {
            mProgressColor = mLoadingColor;
            mThread = new Thread(this);
            mThread.start();
        }
        invalidate();
    }

    /**
     * 切换状态 暂停/下载
     */
    public void toggle() {
        if (!isFinish) {
            if (isStop) {
                setStop(false);
            } else {
                setStop(true);
            }
        }
    }

    public void finishLoad() {
        isFinish = true;
        setStop(true);
    }

    //判断是否完成
    public boolean isFinish() {
        return isFinish;
    }

    @Override
    public void run() {
        int width = mFlikerBitmap.getWidth();
        while (!isStop) {
            mFlikerLeft += dp2px(5);
            float progressWidth = (progress / MAX_PROGRESS) * getMeasuredWidth();
            if (mFlikerLeft >= progressWidth) {
                mFlikerLeft = -width;
            }
            postInvalidate();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //进度条边框
        drawBorder(canvas);

        //进度条
        drawProgress();

        //背景图片
        canvas.drawBitmap(mPgBitmap, 0, 0, null);

        //进度条中的文字
        drawProgressText(canvas);

        //进度条文字变色处理
        drawColorProgressText(canvas);
    }



    private String getProgressText() {
        String text = "";
        if (!isFinish) {
            if (!isStop) {
                text = "下载中" + progress + "%";
            } else {
                text = "继续下载";
            }
        } else {
            text = "下载完成";
        }
        return text;
    }


    //Paint中都是是px，所有要把dp转成px
    private float dp2px(int dp) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return dp * density;
    }

    @Override
    public void onClick(View v) {
        if(!isFinish()){
            toggle();
        }
    }
}
