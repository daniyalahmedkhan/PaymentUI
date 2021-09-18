package com.daniyal.payment.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.airbnb.lottie.LottieAnimationView;
import com.daniyal.payment.R;
import com.daniyal.payment.adapters.PaymentOptionListAdapter;
import com.daniyal.payment.callbacks.FilterResultsCallback;
import com.daniyal.payment.databinding.PaymentOptionFragmentBinding;
import com.daniyal.payment.enums.NetworkMethods;
import com.daniyal.payment.models.ApplicableNetwork;
import com.daniyal.payment.models.ListResult;
import com.daniyal.payment.network.WebService;
import com.daniyal.payment.network.WebServiceFactory;
import com.daniyal.payment.repo.ApiResponse;
import com.daniyal.payment.ui.views.Toolbar;
import com.daniyal.payment.utilities.AppConstants;
import com.daniyal.payment.utilities.CommonHelper;
import com.daniyal.payment.utilities.UIHelper;
import com.daniyal.payment.vm.PaymentViewModel;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/* This fragment extend with basefragment to get base methods and responsible to show list of payment methods through VM */
public class PaymentOptionFragment extends BaseFragment {

    private ListResult listResult;
    private PaymentOptionFragmentBinding binding;
    private PaymentOptionListAdapter paymentOptionListAdapter;
    PaymentViewModel paymentViewModel;

    public static PaymentOptionFragment newInstance() {
        return new PaymentOptionFragment();
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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

        init();
        paymentViewModel.getData().observe(requireActivity(), new Observer<ApiResponse>() {
            @Override
            public void onChanged(ApiResponse apiResponse) {
                shimmerEffect(binding.shimmerViewContainer, false);

                if (apiResponse.getResponse() != null) {
                    listResult = (ListResult) apiResponse.getResponse().body();
                    paymentOptionListAdapter = new PaymentOptionListAdapter(getActivity(), listResult.getNetworks().getApplicable(), new FilterResultsCallback() {
                        @Override
                        public void onPublish(int filterResults) {}});

                    binding.rvPaymentoption.setAdapter(paymentOptionListAdapter);


                } else if (apiResponse.getT() != null) {
                    UIHelper.showDialog(getActivity(), getResources().getString(R.string.WentWrong));
                } else {
                    UIHelper.showDialog(getActivity(), getResources().getString(R.string.WentWrong));

                }

            }
        });
    }

    private void init() {
        bindLinearLayoutManagers(binding.rvPaymentoption, true);
        shimmerEffect(binding.shimmerViewContainer, true);
        paymentViewModel = new PaymentViewModel(getActivity());
    }

    @Override
    protected void setTitleBar(Toolbar toolbar) {
        toolbar.setSubHeading(CommonHelper.changeCharColor(getResources().getString(R.string.toolbar_title), AppConstants.PayoneerCharToBeChanged, AppConstants.PayoneerColor));

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.debitCard) {
            paymentOptionListAdapter.getFilter().filter(NetworkMethods.DEBIT_CARD.name());
        } else if (id == R.id.creditCard) {
            paymentOptionListAdapter.getFilter().filter(NetworkMethods.CREDIT_CARD.name());
        } else if (id == R.id.onlineTransfer) {
            paymentOptionListAdapter.getFilter().filter(NetworkMethods.ONLINE_BANK_TRANSFER.name());
        } else if (id == R.id.directDebit) {
            paymentOptionListAdapter.getFilter().filter(NetworkMethods.DIRECT_DEBIT.name());
        } else if (id == R.id.openInvoice) {
            paymentOptionListAdapter.getFilter().filter(NetworkMethods.OPEN_INVOICE.name());
        } else if (id == R.id.wallet) {
            paymentOptionListAdapter.getFilter().filter(NetworkMethods.WALLET.name());
        }
        return super.onOptionsItemSelected(item);
    }


}
