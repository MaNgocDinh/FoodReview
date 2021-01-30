package com.example.reviewfood;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private List<food>mListFood;
    public FoodAdapter(List<food> listFood) {
        mListFood = listFood;
    }
    Context mContext;
    public FoodAdapter(List<food> listFood, Context context) {
        mListFood = listFood;
        mContext = context;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view= inflater.inflate(R.layout.item_food,parent,false);

        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, final int position) {
        final food mfood=mListFood.get(position);
        if(mfood==null){
            return;
        }
        holder.imgFood.setImageResource((mListFood.get(position).getImgFood()));
        holder.tvNameFood.setText((mListFood.get(position).getTvNameFood()));
        holder.imgAvt.setImageResource((mListFood.get(position).getImgAvt()));
        holder.tvNameUser.setText((mListFood.get(position).getTvNameUser()));
        holder.tvFollow.setText((mListFood.get(position).getTvFollow()));
        holder.itemView.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                food item = mListFood.get(position);
                Intent intent = new Intent(mContext,ChiTiet.class);
                intent.putExtra("itemfood", item);
                mContext.startActivity(intent);
            }
        }));
    }

    @Override
    public int getItemCount() {
//        if(mListFood != null){
//            return mListFood.size();
//        }
//        return 0;
        return mListFood.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFood,imgAvt;
        private TextView tvNameFood,tvNameUser,tvFollow;


        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood=itemView.findViewById(R.id.img_food);
            imgAvt=itemView.findViewById(R.id.img_avt);
            tvNameFood=itemView.findViewById(R.id.tv_name_food);
            tvNameUser=itemView.findViewById(R.id.tv_name_user);
            tvFollow=itemView.findViewById(R.id.tv_follow);

        }
    }
}
