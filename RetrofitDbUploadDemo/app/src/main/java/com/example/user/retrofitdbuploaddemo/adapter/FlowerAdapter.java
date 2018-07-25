package com.example.user.retrofitdbuploaddemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.retrofitdbuploaddemo.R;
import com.example.user.retrofitdbuploaddemo.model.Flower;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.FlowerHolder> {

    private final FlowerClicklistener mListenr;
    private List<Flower>mFlower = new ArrayList<>();
    public FlowerAdapter(FlowerClicklistener listener){

        mFlower = new ArrayList<>();

        mListenr = listener;
    }

    @NonNull
    @Override
    public FlowerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new FlowerHolder(row);
    }

    @Override
    public void onBindViewHolder(@NonNull FlowerHolder holder, int position) {
        Flower curflower = mFlower.get(position);

        holder.mName.setText(curflower.getName());
        holder.mPrice.setText(Double.toString(curflower.getPrice()));

        Picasso.with(holder.itemView
                .getContext())
                .load("http://services.hanselandpetal.com/photos/"+curflower.getPhoto())
                .into(holder.mImage);

    }

    @Override
    public int getItemCount() {
        return mFlower.size();
    }

    public void addFlower(Flower flower) {
        mFlower.add(flower);
        notifyDataSetChanged();
    }

    public Flower getselectedFlower(int position) {
        return mFlower.get(position);
    }


    public class FlowerHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mImage;
        private TextView mName ,mPrice;

        public FlowerHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.flower_img);
            mName = itemView.findViewById(R.id.flower_name);
            mPrice = itemView.findViewById(R.id.flower_price);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            mListenr.onClick(getLayoutPosition());

        }
    }

    public interface FlowerClicklistener{
        void onClick(int position);
    }
}
