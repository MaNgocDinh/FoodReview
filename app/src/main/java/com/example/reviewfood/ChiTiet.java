package com.example.reviewfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChiTiet extends AppCompatActivity {
    ShapeableImageView mImgItem;
    RatingBar mRatingbar;
    TextView mTvFollow,mTvTenItem,mTvReview1,mTvDoor,mTvPhone,mTvFacebook,mTvLocal,mTvNameCustom,mTvDmy,mTvTime,mTvTitle,mTvContent;
    ImageView mImgReview1;
    CircleImageView mImgAvt,mImgAvtCustom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        mImgItem=findViewById(R.id.img_item);
        mRatingbar=findViewById(R.id.ratingbar);
        mTvFollow=findViewById(R.id.tv_follow);
        mTvTenItem=findViewById(R.id.tv_ten_item);
        mTvReview1=findViewById(R.id.tv_review_1);
        mTvDoor=findViewById(R.id.tv_door);
        mTvPhone=findViewById(R.id.tv_phone);
        mTvFacebook=findViewById(R.id.tv_facebook);
        mTvLocal=findViewById(R.id.tv_local);
        mTvNameCustom=findViewById(R.id.tv_name_custom);
        mTvDmy=findViewById(R.id.tv_dmy);
        mTvTime=findViewById(R.id.tv_time);
        mTvTitle=findViewById(R.id.tv_title);
        mTvContent=findViewById(R.id.tv_content);
        mImgReview1=findViewById(R.id.img_review_1);
        mImgAvt=findViewById(R.id.img_avt);
        mImgAvtCustom=findViewById(R.id.img_avt_custom);
        Intent intent=getIntent();
        food itemfood= (food) intent.getSerializableExtra("itemfood");
        JV_ItemXuHuong itemXuHuong= (JV_ItemXuHuong) intent.getSerializableExtra("itemXuHuong");
        mImgItem.setImageResource(itemfood.getImgFood());
        mTvTenItem.setText(itemfood.getTvNameFood());
        mImgAvt.setImageResource(itemfood.getImgAvt());
        mTvFollow.setText(itemfood.getTvFollow());



    }
}