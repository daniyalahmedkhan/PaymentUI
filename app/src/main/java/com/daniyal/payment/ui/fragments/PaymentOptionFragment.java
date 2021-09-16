package com.daniyal.payment.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.daniyal.payment.R;
import com.daniyal.payment.adapters.PaymentOptionListAdapter;
import com.daniyal.payment.databinding.PaymentOptionFragmentBinding;
import com.daniyal.payment.models.ApplicableNetwork;
import com.daniyal.payment.models.ListResult;
import com.daniyal.payment.network.WebService;
import com.daniyal.payment.network.WebServiceFactory;
import com.daniyal.payment.repo.ApiResponse;
import com.daniyal.payment.ui.views.Toolbar;
import com.daniyal.payment.utilities.CommonHelper;
import com.daniyal.payment.vm.PaymentViewModel;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PaymentOptionFragment extends BaseFragment {

    PaymentViewModel paymentViewModel;
    ListResult listResult;
    PaymentOptionFragmentBinding binding;
    PaymentOptionListAdapter paymentOptionListAdapter;

    public static PaymentOptionFragment newInstance() {
        return new PaymentOptionFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.payment_option_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //paymentViewModel = ViewModelProviders.of(requireActivity()).get(PaymentViewModel.class);
        bindLinearLayoutManagers(binding.rvPaymentoption, true);
        // binding.rvPaymentoption.setEmptyView(emptyView);

        paymentViewModel = new PaymentViewModel(getActivity());

        paymentViewModel.getData().observe(requireActivity(), new Observer<ApiResponse>() {
            @Override
            public void onChanged(ApiResponse apiResponse) {

                if (apiResponse.getResponse() != null) {
                    listResult = (ListResult) apiResponse.getResponse().body();
                    paymentOptionListAdapter = new PaymentOptionListAdapter(getActivity(), listResult.getNetworks().getApplicable());
                    binding.rvPaymentoption.setAdapter(paymentOptionListAdapter);
                } else if (apiResponse.getT() != null) {
                    Log.d("TEST", apiResponse.getT().toString());
                } else {
                    Log.d("TEST", apiResponse.getErrorMessage());
                }

            }
        });


    }

    @Override
    protected void setTitleBar(Toolbar toolbar) {
        toolbar.setSubHeading(CommonHelper.changeCharColor("Payment Methods", "P", "#FF4800"));

    }
}
