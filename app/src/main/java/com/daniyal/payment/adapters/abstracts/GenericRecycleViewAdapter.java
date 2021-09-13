package com.daniyal.payment.adapters.abstracts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public abstract class GenericRecycleViewAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

    protected List<T> list;
    private Context context;
    private ArrayList<T> mItems;
    // Allows to remember the last item shown on screen
    private int lastPosition = -1;

    public GenericRecycleViewAdapter(Context context, ArrayList<T> items) {
        this.context = context;
        this.mItems = items;
        this.list = items;

    }

//    public abstract int getLayoutView();

    public abstract RecyclerView.ViewHolder setViewHolder(ViewGroup parent);

    public abstract void onBindData(RecyclerView.ViewHolder holder, T val, int position);

    protected View setItemView(int layout, ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder holder = setViewHolder(parent);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindData(holder, mItems.get(position), holder.getAdapterPosition());
//        setAnimation(holder.itemView, holder.getAdapterPosition());
    }

    /**
     * Here is the key method to apply the animation
     */
    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    public void addItems(ArrayList<T> savedCardItemz) {
        mItems = savedCardItemz;
        this.notifyDataSetChanged();
    }

    public T getItem(int position) {

        return mItems.get(position);
    }


    public void add(T item, int position) {
        if (item == null) {
            return;
        }
        mItems.add(position, item);
        notifyItemInserted(position);
    }

    public void add(List<T> items, int position) {
        if (items == null || items.isEmpty()) {
            return;
        }
        mItems.addAll(position, items);
        notifyItemRangeInserted(position, items.size());
    }

    public void add(T item) {
        int position = mItems.size();
        mItems.add(position, item);
//        notifyItemInserted(position);
    }

    public void addItemTop(T item) {
        int position = mItems.size();
        mItems.add(0, item);
        notifyItemInserted(0);
    }

    public void add(List<T> items) {
        if (items.isEmpty()) {
            return;
        }
        int position = mItems.isEmpty() ? 0 : mItems.size();
        mItems.addAll(position, items);
        notifyItemRangeInserted(position, items.size());
    }


    public List<T> getItems() {
        return mItems;
    }

    public int getItemCount() {
        return mItems.size();
    }

    /**
     * Requires equals() and hashcode() to be implemented in T class.
     */
    public void remove(T item) {
        int position = mItems.indexOf(item);
        if (position == -1) {
            return;
        }
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    public void remove(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mItems.size());
    }

    public void remove(int position, int itemCount) {
        for (int i = position; i < itemCount; i++) {
            mItems.remove(i);
        }
        notifyItemRangeRemoved(position, itemCount);
    }

    public void update(int position, T model) {
        mItems.set(position, model);
        notifyItemChanged(position);
    }

    public void clear() {
        mItems.clear();
        notifyDataSetChanged();
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                list = (List<T>) results.values;
                GenericRecycleViewAdapter.this.notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<T> filteredResults = null;
                if (constraint.length() == 0) {
                    filteredResults = mItems;
                } else {
                    filteredResults = getFilteredResults(constraint.toString().toLowerCase());
                }

                FilterResults results = new FilterResults();
                results.values = filteredResults;

                return results;
            }
        };
    }

    protected List<T> getFilteredResults(String constraint) {
        List<T> results = new ArrayList<>();

        for (T item : mItems) {
            if (item.toString().toLowerCase().contains(constraint.toString().toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }


}