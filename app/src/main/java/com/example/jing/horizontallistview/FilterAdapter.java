package com.example.jing.horizontallistview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jing on 2017/3/23.
 */

    public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.ViewHolder> {

    private Filter[] filters;


    // Adapter contains two contents, image views and effect names
    public FilterAdapter(Filter[] filters) {
        this.filters = filters;
    }

    // inflate the item view layout to the view holder.
    @Override
    public FilterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false); // inflate the item view to view holder.
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.effect.setText(filters[position].getFilterName());
        holder.image.setImageDrawable(filters[position].getFilterImage());
    }

    @Override
    public int getItemCount() {
        return filters.length;
    }


    // ViewHolder is a reference to item. It holds a item view. Contains the items in element.
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView image;
        private TextView effect;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            image = (ImageView) itemView.findViewById(R.id.image);
            effect = (TextView) itemView.findViewById(R.id.effect_name);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "position: " + getPosition(), Toast.LENGTH_SHORT).show();
        }
    }
}
