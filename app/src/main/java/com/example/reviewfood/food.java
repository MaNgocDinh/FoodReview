package com.example.reviewfood;

import java.io.Serializable;

public class food implements Serializable {
    public static final int TYPE_TRENDING=1;
    public static final int TYPE_GAN_BAN=2;
    public static final int TYPE_AN_VAT=3;
    public static final int TYPE_AN_TRUA=4;
    public static final int TYPE_GIUP_DO=5;

    private int mImgFood;
    private String mTvNameFood;
    private int mImgAvt;
    private String mTvNameUser;
    private String mTvFollow;
    private int type;

    public food(int imgFood, String tvNameFood, int imgAvt, String tvNameUser, String tvFollow, int type) {
        mImgFood = imgFood;
        mTvNameFood = tvNameFood;
        mImgAvt = imgAvt;
        mTvNameUser = tvNameUser;
        mTvFollow = tvFollow;
        this.type = type;
    }

    public int getImgFood() {
        return mImgFood;
    }

    public void setImgFood(int imgFood) {
        mImgFood = imgFood;
    }

    public String getTvNameFood() {
        return mTvNameFood;
    }

    public void setTvNameFood(String tvNameFood) {
        mTvNameFood = tvNameFood;
    }

    public int getImgAvt() {
        return mImgAvt;
    }

    public void setImgAvt(int imgAvt) {
        mImgAvt = imgAvt;
    }

    public String getTvNameUser() {
        return mTvNameUser;
    }

    public void setTvNameUser(String tvNameUser) {
        mTvNameUser = tvNameUser;
    }

    public String getTvFollow() {
        return mTvFollow;
    }

    public void setTvFollow(String tvFollow) {
        mTvFollow = tvFollow;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
