package com.bawie.myphotoview;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;

import me.relex.photodraweeview.OnPhotoTapListener;
import me.relex.photodraweeview.PhotoDraweeView;

public class SuccessActivity extends AppCompatActivity {

    private PhotoDraweeView photoView;
    private String img_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        initView();
        initData();
        initEvent();

    }

    private void initView() {
        photoView = findViewById(R.id.photoView);
    }

    private void initData() {

        img_url = getIntent().getStringExtra("img_url");

        if(!TextUtils.isEmpty(img_url)){
            PipelineDraweeControllerBuilder controller = Fresco.newDraweeControllerBuilder();
            controller.setUri(img_url);//设置图片URL
            controller.setOldController(photoView.getController());
            controller.setControllerListener(new BaseControllerListener<ImageInfo>(){

                @Override
                public void onFinalImageSet(String id, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
                    super.onFinalImageSet(id, imageInfo, animatable);
                    if(imageInfo == null || photoView == null){
                        return;
                    }
                    photoView.update(imageInfo.getWidth(),imageInfo.getHeight());
                }
            });
            photoView.setController(controller.build());
        }else{
            Toast.makeText(this, "图片获取失败", Toast.LENGTH_SHORT).show();
        }

    }

    private void initEvent() {
        //点击事件
        photoView.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float x, float y) {
                finish();
            }
        });



    }


}
