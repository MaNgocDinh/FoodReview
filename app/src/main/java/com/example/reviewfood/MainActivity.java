package com.example.reviewfood;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RatingBar mRatingBar;
    float myRating=0;
    //navigation bar
    Toolbar mToolbar;
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    ListView mListView;

    //chuyen slide
    ImageView mimgSlide;
    private int[] ChangeSlide = {
            R.drawable.slide1,
            R.drawable.slide2,
            R.drawable.slide3,
            R.drawable.slide4,
            R.drawable.slide5,
    };
    int dem = 0;
    //recyclerview Xu Huong
    private RecyclerView mRcvXuHuong;
    private ArrayList<JV_ItemXuHuong> mPageItemXuHuong;
    private JV_XuHuongAdapter mRcvMainAdapter;
    //recyclerview Danh Muc
    private RecyclerView mRcvTatCa;
    private Button mBtnTrending, mBtnGanBan, mBtnAnVat, mBtnAnTrua,mBtnGiupDo;
    private GridLayoutManager gridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        ChuyenSlide();

        gridLayoutManager=new GridLayoutManager(this,2);
        mRcvTatCa.setLayoutManager(gridLayoutManager);
        FoodAdapter adapter1=new FoodAdapter(getListFood());
        mRcvTatCa.setAdapter(adapter1);
        mBtnTrending.setOnClickListener(this);
        mBtnGanBan.setOnClickListener(this);
        mBtnAnVat.setOnClickListener(this);
        mBtnAnTrua.setOnClickListener(this);
        mBtnGiupDo.setOnClickListener(this);

        //chuyen trang
        mBtnTrending.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                chuyentrang();
            }
        });
        //navigation
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,//DrawerLayout lien ket den ActionBar
                mToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close//tro giup mo ta
        );
        //mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //RatingBar
//        mRatingBar.setOnRatingBarChangeListener((new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
//                int rating = (int) v;
//                String message = null;
//
//                myRating=(int)ratingBar.getRating();
//
//                switch (rating) {
//                    case 1:
//                        message = "Sorry to hear that! :(";
//                        break;
//                    case 2:
//                        message = "you can alway suggestion! ";
//                        break;
//                    case 3:
//                        message = "good enough! ";
//                        break;
//                    case 4:
//                        message = "Great! Thank you! ";
//                        break;
//                    case 5:
//                        message = "Awesome! You are the better! ";
//                        break;
//
//                }
//            }
//        }));
//
//        mBtnGanBan.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,String.valueOf(myRating), Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    private List<food> getListFood() {
        List<food> list=new ArrayList<>();
        list.add(new food(R.drawable.pho_store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_TRENDING));
        list.add(new food(R.drawable.pho_store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_TRENDING));
        list.add(new food(R.drawable.pho_store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_TRENDING));
        list.add(new food(R.drawable.pho_store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_TRENDING));
        list.add(new food(R.drawable.pho_store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_TRENDING));
        list.add(new food(R.drawable.pho_store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_TRENDING));

        list.add(new food(R.drawable.pizzahut_store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_GAN_BAN));
        list.add(new food(R.drawable.pizzahut_store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_GAN_BAN));
        list.add(new food(R.drawable.pizzahut_store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_GAN_BAN));

        list.add(new food(R.drawable.pizzahut_store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_AN_VAT));
        list.add(new food(R.drawable.pizzahut_store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_AN_VAT));
        list.add(new food(R.drawable.pizzahut_store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_AN_VAT));
        list.add(new food(R.drawable.pizzahut_store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_AN_VAT));

        list.add(new food(R.drawable.store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_AN_TRUA));
        list.add(new food(R.drawable.store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_AN_TRUA));
        list.add(new food(R.drawable.store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_AN_TRUA));
        list.add(new food(R.drawable.store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_AN_TRUA));
        list.add(new food(R.drawable.store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_AN_TRUA));
        list.add(new food(R.drawable.store,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_AN_TRUA));

        list.add(new food(R.drawable.picstore2,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_GIUP_DO));
        list.add(new food(R.drawable.picstore2,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_GIUP_DO));
        list.add(new food(R.drawable.picstore2,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_GIUP_DO));
        list.add(new food(R.drawable.picstore2,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_GIUP_DO));
        list.add(new food(R.drawable.picstore2,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_GIUP_DO));
        list.add(new food(R.drawable.picstore2,"Am long quan com chay 2k dong",R.drawable.logosauque,"Co Long","2T",food.TYPE_GIUP_DO));


        return list;
    }

    //thanh menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void ChuyenSlide() {
        //chuyen slide
        final CountDownTimer countDownTimer = new CountDownTimer(13000, 2000) {
            @Override
            public void onTick(long l) {
                if (dem == 2)
                    dem = 0;
                mimgSlide.setImageResource(ChangeSlide[dem++]);
            }

            @Override
            public void onFinish() {
                this.start();
            }
        };
        countDownTimer.start();
    }
    private void AnhXa() {
        mToolbar = findViewById(R.id.toolbar);
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mNavigationView = findViewById(R.id.navigation);
        mimgSlide = findViewById(R.id.img_slide);
        //Them du lieu cho recyclerview Xu Huong
        mRcvXuHuong = findViewById(R.id.rcv_xu_huong);
        mPageItemXuHuong = new ArrayList<>();
        mPageItemXuHuong.add(new JV_ItemXuHuong(R.drawable.pho_store, "Pho 24h", R.drawable.pho_store, "Pho24h", "2M"));
        mPageItemXuHuong.add(new JV_ItemXuHuong(R.drawable.ice_cream_store, "Kem-Quan 1", R.drawable.ice_cream_store, "Ice Cream", "175"));
        mPageItemXuHuong.add(new JV_ItemXuHuong(R.drawable.itemhamburger1, "Hamburger-81 Landmark", R.drawable.itemhamburger1, "Hamburger", "121M"));
        mPageItemXuHuong.add(new JV_ItemXuHuong(R.drawable.logosauque, "Com Sau Que-Quan 3", R.drawable.logosauque, "Sau Que", "57"));
        mPageItemXuHuong.add(new JV_ItemXuHuong(R.drawable.pizzahut_store, "PizzaHut-Nguyen Trai", R.drawable.pizzahut_store, "PizzaHut", "8000"));
        //adapter cua recyclerview Xu Huong chua danh sach tat ca du lieu vua them vao
        mRcvMainAdapter = new JV_XuHuongAdapter(mPageItemXuHuong);
        //sua adapter cua recyclerview trong xml chua trang adapter
        mRcvXuHuong.setAdapter(mRcvMainAdapter);
        //Anh xa cho cac nut
        mBtnTrending = findViewById(R.id.btn_trending);
        mBtnGanBan = findViewById(R.id.btn_gan_ban);
        mBtnAnVat = findViewById(R.id.btn_an_vat);
        mBtnAnTrua = findViewById(R.id.btn_an_trua);
        mBtnGiupDo = findViewById(R.id.btn_giup_do);
        mRcvTatCa = findViewById(R.id.rcv_tat_ca);
        mRatingBar = findViewById(R.id.ratingbar);

    }
    public void chuyentrang() {
        Intent intent = new Intent(this, ChiTiet.class);
        startActivity(intent);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        switch (id)
        {
            case R.id.mnuInfo:
                Intent intent=new Intent(MainActivity.this,ChiTiet.class);
                startActivity(intent);
                break;
        }

        return true;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_trending:
                scrollToItem(0);
                break;
            case R.id.btn_gan_ban:
                scrollToItem(6);
                break;
            case R.id.btn_an_vat:
                scrollToItem(9);
                break;
            case R.id.btn_an_trua:
                scrollToItem(13);
                break;
            case R.id.btn_giup_do:
                scrollToItem(19);
                break;
        }

    }

    private void scrollToItem(int i) {
        if(gridLayoutManager ==null){
            return;
        }
        gridLayoutManager.scrollToPositionWithOffset(i,0);
    }
}


