package com.bawie.myphotoview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    private SimpleDraweeView mImageView;
    private String IMG_URL = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1509755683&di=83da275a8a0fd0cf9dcba3ba6224dfdc&src=http://img5q.duitang.com/uploads/item/201501/06/20150106221451_QXAAv.jpeg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initEvent();

    }

    private void initView() {

        mImageView = findViewById(R.id.sd_view);
    }

    private void initData() {
        //绑定
     mImageView.setImageURI(IMG_URL);
    }

    private void initEvent() {

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SuccessActivity.class);
                intent.putExtra("img_url",IMG_URL);
                startActivity(intent);
            }
        });


    }






}
