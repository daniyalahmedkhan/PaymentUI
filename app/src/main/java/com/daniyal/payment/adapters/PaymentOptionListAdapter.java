package com.daniyal.payment.adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.daniyal.payment.adapters.abstracts.GenericRecycleViewAdapter;
import com.daniyal.payment.models.ListResult;

import java.util.ArrayList;

public class PaymentOptionListAdapter extends GenericRecycleViewAdapter<ListResult> {

    public PaymentOptionListAdapter(Context context, ArrayList<ListResult> items) {
        super(context, items);
    }

    @Override
    public RecyclerView.ViewHolder setViewHolder(ViewGroup parent) {
        return null;
    }


    @Override
    public void onBindData(RecyclerView.ViewHolder holder, ListResult val, int position) {

    }


}
