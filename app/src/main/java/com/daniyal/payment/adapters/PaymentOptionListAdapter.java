package com.daniyal.payment.adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.daniyal.payment.R;
import com.daniyal.payment.adapters.abstracts.GenericRecycleViewAdapter;
import com.daniyal.payment.callbacks.FilterResultsCallback;
import com.daniyal.payment.enums.NetworkMethods;
import com.daniyal.payment.models.ApplicableNetwork;
import com.daniyal.payment.utilities.ImageHelper;

import org.w3c.dom.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/* This adapter is responsible to bind the data in list */
public class PaymentOptionListAdapter extends GenericRecycleViewAdapter<ApplicableNetwork> implements PaymentOptionListHandler {

    private final Context context;
    private List<ApplicableNetwork> filteritems;
    private final List<ApplicableNetwork> items;
    private FilterResultsCallback filterResultsCallback;

    public PaymentOptionListAdapter(Context context, List<ApplicableNetwork> items, FilterResultsCallback filterResultsCallback) {
        super(context, items);
        this.items = items;
        this.filterResultsCallback = filterResultsCallback;
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

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filteritems = items;
                } else {
                    ArrayList<ApplicableNetwork> filteredList = new ArrayList<>();
                    for (ApplicableNetwork row : items) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.getMethod() != null) {
                            if (row.getMethod().toLowerCase().contains(charString.toLowerCase())

                            ) {
                                filteredList.add(row);
                            }
                        }

                    }

                    filteritems = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteritems;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                filteritems = (ArrayList<ApplicableNetwork>) filterResults.values;
                addItems(filteritems);
                notifyDataSetChanged();

                filterResultsCallback.onPublish(((ArrayList<ApplicableNetwork>) filterResults.values).size());
            }
        };
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
