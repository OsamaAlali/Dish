package com.example.dish;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DishAdabter extends RecyclerView.Adapter<DishAdabter.DishViewHolder> {

    // create list to bind with data(Veiwholder)
    List<Dish> items =new ArrayList<Dish>();

    public DishAdabter(List<Dish> items) {
        this.items = items;
    }

// Create the viewholder Class must be static in call it without object;

    public static class DishViewHolder extends RecyclerView.ViewHolder{

        // create object from model
        public Dish dish;

        // create View object which wrap all data
        View itemView;

        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;

        }
    } // End DishViewHolder

    @NonNull

    @Override
    public DishViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        // this will excute when run recycle view
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dish_item,parent,false);
      DishViewHolder dishViewHolder=new DishViewHolder(view);
        return dishViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  DishAdabter.DishViewHolder holder, int position) {

        holder.dish=items.get(position);
        TextView name=holder.itemView.findViewById(R.id.nameFragmentID);
        TextView price=holder.itemView.findViewById(R.id.priceFragmentID);

        name.setText(holder.dish.name);
        price.setText(Integer.toString(holder.dish.price));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
