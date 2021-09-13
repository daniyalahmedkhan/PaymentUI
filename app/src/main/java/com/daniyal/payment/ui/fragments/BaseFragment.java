package com.daniyal.payment.ui.fragments;

import androidx.fragment.app.Fragment;

import com.daniyal.payment.ui.BaseActivity;

public abstract class BaseFragment extends Fragment {

    protected BaseActivity getBaseActivity(){
        return (BaseActivity) getActivity();
    }

}
