package com.daniyal.payment.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;

import com.daniyal.payment.R;
import com.daniyal.payment.ui.fragments.BaseFragment;
import com.daniyal.payment.ui.fragments.PaymentOptionFragment;
import com.daniyal.payment.ui.views.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {

    public static final String KEY_FRAG_FIRST = "firstFrag";
    protected BaseFragment baseFragment;
    @BindView(R.id.layout_fragment)
    FrameLayout layout_fragment;
    @BindView(R.id.view_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
    }

    private void initFragment(){
        addDockableFragment(PaymentOptionFragment.newInstance());
    }

    /**
     * Add Dockable Fragment
     *
     * @param frag
     */
    public void addDockableFragment(BaseFragment frag) {
        AlphaAnimation animation1 = new AlphaAnimation(0.2f, 1.0f);
        animation1.setDuration(1000);
        animation1.setStartOffset(5000);
        animation1.setFillAfter(true);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        baseFragment = frag;
        transaction.replace(R.id.layout_fragment, frag, frag.getClass().getSimpleName());
        transaction.addToBackStack(getSupportFragmentManager().getBackStackEntryCount() == 0 ? KEY_FRAG_FIRST : null).commit();

    }

    public Toolbar getToolbar(){
        return toolbar;
    }

}