package com.leeves.h.mytestnewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.funtory.slideshowimageview.SlideshowImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Function：
 * Created by h on 2016/9/26.
 *
 * @author Leeves
 */
public class SlideshowToolbarActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private SlideshowImageView mSlideshowImageView;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slideshow_toolbar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_slide_show);
        mSlideshowImageView = (SlideshowImageView) findViewById(R.id.iv_expand);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mToolbar.setTitle("Slideshow Toolbar Demo");
        setSupportActionBar(mToolbar);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRecyclerView.setAdapter(new DummyAdapter());
        mSlideshowImageView.setImages(R.drawable.test4,R.drawable.test5,R.drawable.test6,R.drawable.test7,R.drawable.test8);
    }

    class DummyAdapter extends RecyclerView.Adapter {
        List<String> dummy = new ArrayList<>();

        public DummyAdapter() {
            for (int i = 0; i < 50; i++) {
                dummy.add("Item" + i);
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new RecyclerView.ViewHolder(LayoutInflater.from(SlideshowToolbarActivity.this).inflate(android.R.layout.simple_list_item_1, null)) {
            };
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TextView textView = (TextView) holder.itemView;
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setText(dummy.get(position));
//            ((TextView) holder.itemView).setText(dummy.get(position));
        }

        @Override
        public int getItemCount() {
            return dummy.size();
        }
    }
}