package com.example.reviewfood;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class JV_XuHuongAdapter extends RecyclerView.Adapter<JV_XuHuongAdapter.RecyclerMainViewHolder> {

    private List<JV_ItemXuHuong> listItem;

    public JV_XuHuongAdapter(List<JV_ItemXuHuong> listItem) {
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public RecyclerMainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_xu_huong, parent, false);
        return new RecyclerMainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerMainViewHolder holder, int position) {
        holder.imageFood.setImageResource(listItem.get(position).getImgFood());
        holder.textviewName.setText(listItem.get(position).getTvNameShop());
        holder.imageAvatar.setImageResource(listItem.get(position).getImgAvt());
        holder.textviewNameShop.setText(listItem.get(position).getTvNameShop());
        holder.textviewFollow.setText(listItem.get(position).getTvFolow());
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class RecyclerMainViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageFood,imageAvatar;
        private TextView textviewName,textviewNameShop,textviewFollow;


        public RecyclerMainViewHolder(@NonNull View itemView) {
            super(itemView);

            imageFood = itemView.findViewById(R.id.imgFood);
            imageAvatar=itemView.findViewById(R.id.imgAvt);
            textviewName=itemView.findViewById(R.id.tvName);
            textviewNameShop=itemView.findViewById(R.id.tvNameShop);
            textviewFollow=itemView.findViewById(R.id.tvFollow);
        }
    }

}
