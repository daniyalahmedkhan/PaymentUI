package com.daniyal.payment.ui.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.daniyal.payment.R;
import com.daniyal.payment.ui.BaseActivity;
import com.daniyal.payment.ui.views.Toolbar;
import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;

public abstract class BaseFragment extends Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        setTitleBar(getBaseActivity().getToolbar());
    }

    /* Toolbar */
    abstract protected void setTitleBar(Toolbar toolbar);

    /* Get BaseActivity */
    protected BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

    /*
     * RecyclerView manager method */
    protected void bindLinearLayoutManagers(RecyclerView myRecyclerView, boolean isVerticalOrientation) {
        myRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseActivity(), isVerticalOrientation == true ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL, false);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    /*
     * To show shimmer effect on loading
     * */
    protected void shimmerEffect(ShimmerFrameLayout shimmer, boolean isVisible) {
        if (isVisible) {
            shimmer.setVisibility(View.VISIBLE);
            shimmer.startShimmer();
        } else {
            shimmer.setVisibility(View.GONE);
            shimmer.stopShimmer();
        }

    }


}
