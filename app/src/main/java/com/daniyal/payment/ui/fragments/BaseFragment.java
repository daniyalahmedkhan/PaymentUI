package com.daniyal.payment.ui.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.daniyal.payment.ui.BaseActivity;
import com.daniyal.payment.ui.views.Toolbar;

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

    abstract protected void setTitleBar(Toolbar toolbar);


    protected BaseActivity getBaseActivity(){
        return (BaseActivity) getActivity();
    }



}
