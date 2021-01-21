package com.example.reviewfood;

public class JV_ItemXuHuong {

    int mImgFood;
    String mTvName;
    int mImgAvt;
    String mTvNameShop;
    String mTvFolow;


    public JV_ItemXuHuong() {
    }

    public JV_ItemXuHuong(int mImgFood,String mTvName,int mImgAvt,String mTvNameShop,String mTvFollow) {
        this.mImgFood = mImgFood;
        this.mTvName= mTvName;
        this.mImgAvt= mImgAvt;
        this.mTvNameShop=mTvNameShop;
        this.mTvFolow=mTvFollow;
    }

    public int getImgFood() {
        return mImgFood;
    }

    public void setImgFood(int imgFood) {
        mImgFood = imgFood;
    }

    public String getTvName() {
        return mTvName;
    }

    public void setTvName(String tvName) {
        mTvName = tvName;
    }

    public int getImgAvt() {
        return mImgAvt;
    }

    public void setImgAvt(int imgAvt) {
        mImgAvt = imgAvt;
    }

    public String getTvNameShop() {
        return mTvNameShop;
    }

    public void setTvNameShop(String tvNameShop) {
        mTvNameShop = tvNameShop;
    }

    public String getTvFolow() {
        return mTvFolow;
    }

    public void setTvFolow(String tvFolow) {
        mTvFolow = tvFolow;
    }
//    public int getImageResource() {
//        return imageResource;
//    }
//
//    public void setImageResource(int imageResource) {
//        this.imageResource = imageResource;
//    }
}
