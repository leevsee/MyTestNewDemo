package com.leeves.h.mytestnewdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Function：
 * Created by h on 2016/9/28.
 *
 * @author Leeves
 */

//省去写setContentView(R.layout.activity_annotations);
@EActivity(R.layout.activity_annotations)
public class AndroidAnnotationsDemo extends Activity {

    //如果变量名字和EditText组件名字相同，不用写R.id.mEditText
    @ViewById
    EditText mEditText;
    //这里不同，所以要写
    @ViewById(R.id.iv)
    ImageView mImageView;
    //button直接写点击事件
    @Click(R.id.bn1)
    void setPictureUrl() {
        getPictureUrl(mEditText.getText().toString());
    }

    //后台线程处理网络请求
    @Background
    void getPictureUrl(String pUrl) {
        try {
            URL url = new URL(pUrl);
            InputStream is = url.openStream();
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            is.close();
            showPicture(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //后台处理完后，在UI线程上显示
    @UiThread
    void showPicture(Bitmap bitmap){
        mImageView.setImageBitmap(bitmap);
    }
}
