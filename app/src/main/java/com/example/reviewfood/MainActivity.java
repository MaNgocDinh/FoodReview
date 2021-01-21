package com.example.reviewfood;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    //search
    private List<Suggestion> mSuggestions = new ArrayList<>();

    //navigation bar
    Toolbar mToolbar;
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;

    //chuyen slide
    ImageView mimgSlide;
    int[] ChangeSlide = {
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

    //recyclerview Food
    private RecyclerView mRcvFood;
    private Button mBtnCafe, mBtnTraSua, mBtnSuaChua;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


        //Anh xa recyclerview cac nut
        mBtnCafe = findViewById(R.id.btn_cafe);
        mBtnSuaChua = findViewById(R.id.btn_sua_chua);
        mBtnTraSua = findViewById(R.id.btn_tra_sua);
        mRcvFood = findViewById(R.id.rcv_food);

        //adapter cua recyclerview tim kiem chua danh sach ta ca du lieu vua them vao
        FoodAdapter adapter = new FoodAdapter(getListFood());
        //recyclerview tim kiem cai lai adapter chua adapter o tren
        mRcvFood.setAdapter(adapter);


        mBtnCafe.setOnClickListener(this);
        mBtnTraSua.setOnClickListener(this);
        mBtnSuaChua.setOnClickListener(this);


        initData();

        final FloatingSearchView searchView = (FloatingSearchView) findViewById(R.id.floating_search_view);
        searchView.bringToFront();

        searchView.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, String newQuery) {
                if (!oldQuery.equals("") && newQuery.equals("")) {
                    searchView.clearSuggestions();
                } else {
                    searchView.showProgress();
                    searchView.swapSuggestions(getSuggestion(newQuery));
                    searchView.hideProgress();
                }
            }
        });
        searchView.setOnFocusChangeListener(new FloatingSearchView.OnFocusChangeListener() {
            @Override
            public void onFocus() {
                searchView.showProgress();
                searchView.swapSuggestions(getSuggestion(searchView.getQuery()));
                searchView.hideProgress();
            }

            @Override
            public void onFocusCleared() {

            }
        });
        searchView.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
            @Override
            public void onSuggestionClicked(SearchSuggestion searchSuggestion) {
                Suggestion suggestion = (Suggestion) searchSuggestion;
                Toast.makeText(getApplicationContext(), "Ban vua chon " + suggestion.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSearchAction(String currentQuery) {

            }
        });

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

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,//DrawerLayout lien ket den ActionBar
                mToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close//tro giup mo ta
        );
//        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        switch (id)
        {
            case R.id.mnuInfo:
                Intent intent=new Intent(MainActivity.this,infor.class);
                startActivity(intent);
                break;
                // em vua chat gi the? anh ko de y
            //anh cho em xiu de em mo anh coi cho de hieu y emok
        }

        return true;
    }











    //ham danh sach them du lieu cho recyclerview tim kiem
    private List<food> getListFood() {
        List<food> list = new ArrayList<food>();
        list.add(new food(R.drawable.delete, "Cafe", food.TYPE_CAFE));
        list.add(new food(R.drawable.delete, "Cafe", food.TYPE_CAFE));
        list.add(new food(R.drawable.delete, "Cafe", food.TYPE_CAFE));
        list.add(new food(R.drawable.delete, "Cafe", food.TYPE_CAFE));

        list.add(new food(R.drawable.delete, "Tra sua", food.TYPE_TRA_SUA));
        list.add(new food(R.drawable.delete, "Tra sua", food.TYPE_TRA_SUA));
        list.add(new food(R.drawable.delete, "Tra sua", food.TYPE_TRA_SUA));
        list.add(new food(R.drawable.delete, "Tra sua", food.TYPE_TRA_SUA));

        list.add(new food(R.drawable.delete, "Sua chua", food.TYPE_SUA_CHUA));
        list.add(new food(R.drawable.delete, "Sua chua", food.TYPE_SUA_CHUA));
        list.add(new food(R.drawable.delete, "Sua chua", food.TYPE_SUA_CHUA));
        list.add(new food(R.drawable.delete, "Sua chua", food.TYPE_SUA_CHUA));

        return list;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_cafe:
                scrollToItem(0);
                break;
            case R.id.btn_tra_sua:
                scrollToItem(4);
                break;
            case R.id.btn_sua_chua:
                scrollToItem(8);
                break;
        }
    }

    private void scrollToItem(int index) {
        if(gridLayoutManager==null){
            return;
        }
        gridLayoutManager.scrollToPositionWithOffset(index,0);
    }



    private void initData(){
        mSuggestions.add(new Suggestion("Ha Noi"));
        mSuggestions.add(new Suggestion("Ha nam"));
        mSuggestions.add(new Suggestion("Da nang"));
        mSuggestions.add(new Suggestion("Dong nai"));
        mSuggestions.add(new Suggestion("Phú Tho"));
        mSuggestions.add(new Suggestion("Quang ngai"));
        mSuggestions.add(new Suggestion("Thanh hoa"));
        mSuggestions.add(new Suggestion("Hue"));
    }

    private List<Suggestion> getSuggestion(String query){
        List<Suggestion> suggestions=new ArrayList<>();
        for(Suggestion suggestion:mSuggestions){
            if(suggestion.getName().toLowerCase().contains(query.toLowerCase())){
                suggestions.add(suggestion);
            }
        }
        return suggestions;
    }
}


