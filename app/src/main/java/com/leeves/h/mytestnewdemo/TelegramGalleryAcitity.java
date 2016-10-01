package com.leeves.h.mytestnewdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.tangxiaolv.telegramgallery.GalleryActivity;

import java.util.List;

/**
 * Function：
 * Created by h on 2016/9/23.
 *
 * @author Leeves
 */
public class TelegramGalleryAcitity extends Activity {

    private List<String> phones;
    private BaseAdapter mBaseAdapter;
    private LayoutInflater mLayoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_gallery);
        mLayoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Button bn1 = (Button) findViewById(R.id.btn1);
        GridView gv = (GridView) findViewById(R.id.gv);
        gv.setAdapter(mBaseAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return phones == null ? 0 : phones.size();
            }

            @Override
            public Object getItem(int position) {
                return phones == null ? null : phones.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
//                ImageView view = new ImageView(TelegramGalleryAcitity.this);
//                view.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                view.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 256));
//                String path = (String) getItem(position);
//                BitmapFactory.Options opts = new BitmapFactory.Options();
//                opts.inPreferredConfig = Bitmap.Config.ARGB_4444;
//                opts.inSampleSize = 4;
//                Bitmap bitmap = BitmapFactory.decodeFile(path, opts);
//                view.setImageBitmap(bitmap);
//                return view;

                ViewHolder viewHolder;
                if (convertView == null) {
                    convertView = mLayoutInflater.inflate(R.layout.item_image, null);
                    viewHolder = new ViewHolder();
                    viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.iv);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                String photoPath = (String) getItem(position);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_4444;
                options.inSampleSize = 4;
                viewHolder.mImageView.setImageBitmap(BitmapFactory.decodeFile(photoPath, options));
                return convertView;
            }
        });

        bn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GalleryActivity.openActivity(TelegramGalleryAcitity.this, false, 9, 10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (10 == requestCode && resultCode == Activity.RESULT_OK) {
            phones = (List<String>) data.getSerializableExtra(GalleryActivity.PHOTOS); //获取图片资源路径集合返回值(返回List<String>
            mBaseAdapter.notifyDataSetChanged();
        }
    }

    class ViewHolder {
        ImageView mImageView;
    }
}
