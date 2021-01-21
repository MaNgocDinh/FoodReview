package com.example.reviewfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class infor extends AppCompatActivity {
    ImageView mimgChitiet;
    TextView mtvTenMonAn,mtvGia;

    private int mImgFood;
    private String mTvName;
    private int mImgAvt;
    private String mTvNameShop;
    private String mTvFolow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);
        mimgChitiet=findViewById(R.id.imgChitiet);
        mtvTenMonAn=findViewById(R.id.tvTenMonAn);
        mtvGia=findViewById(R.id.tvGiaMon);
        Intent intent=getIntent();
        JV_ItemXuHuong itemfood= (JV_ItemXuHuong) intent.getSerializableExtra("itemfood");
        mimgChitiet.setImageResource(itemfood.mImgFood);
        mtvTenMonAn.setText(itemfood.mTvName);
        mtvGia.setText(itemfood.mTvNameShop);
    }
}