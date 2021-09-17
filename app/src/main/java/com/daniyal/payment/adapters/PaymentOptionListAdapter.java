package com.daniyal.payment.adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.daniyal.payment.R;
import com.daniyal.payment.adapters.abstracts.GenericRecycleViewAdapter;
import com.daniyal.payment.enums.NetworkMethods;
import com.daniyal.payment.models.ApplicableNetwork;
import com.daniyal.payment.utilities.ImageHelper;

import org.w3c.dom.Text;

import java.net.URL;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PaymentOptionListAdapter extends GenericRecycleViewAdapter<ApplicableNetwork> implements PaymentOptionListHandler {

    private Context context;

    public PaymentOptionListAdapter(Context context, List<ApplicableNetwork> items) {
        super(context, items);
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder setViewHolder(ViewGroup parent) {
        return new ViewHolder(setItemView(R.layout.payment_card_item, parent));
    }


    @Override
    public void onBindData(RecyclerView.ViewHolder holder, ApplicableNetwork val, int position) {
        ViewHolder vHolder = (ViewHolder) holder;

        vHolder.tv_option_name.setText(val.getLabel());
        vHolder.tv_method.setText(returnValidNetworkMethod(val.getMethod()));
        ImageHelper.loadNetworkImage(vHolder.iv_logo, ImageHelper.getLogo(val.getLinks(), context));

        if (val.isClicked()) {
            vHolder.lottie_tick.setVisibility(View.VISIBLE);
            vHolder.lottie_tick.playAnimation();
        } else {
            vHolder.lottie_tick.setVisibility(View.INVISIBLE);
        }

        vHolder.cv_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                falsePreviousSelectedItems();
                val.setClicked(true);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public void falsePreviousSelectedItems() {
        for (ApplicableNetwork a : list) {
            a.setClicked(false);
        }
    }

    @Override
    public String returnValidNetworkMethod(String methodName) {
        try {
            return NetworkMethods.getMethods(NetworkMethods.valueOf(methodName), context);
        } catch (Exception e) {
            return context.getString(R.string.Others);
        }

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_option_name)
        TextView tv_option_name;
        @BindView(R.id.iv_logo)
        ImageView iv_logo;
        @BindView(R.id.tv_method)
        TextView tv_method;
        @BindView(R.id.lottie_tick)
        LottieAnimationView lottie_tick;
        @BindView(R.id.cv_item)
        CardView cv_item;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}
