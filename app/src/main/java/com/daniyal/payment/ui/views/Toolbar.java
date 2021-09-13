package com.daniyal.payment.ui.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

import com.daniyal.payment.R;
import com.daniyal.payment.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Toolbar extends RelativeLayout {

    @BindView(R.id.imgLeftButton)
    ImageButton imgLeftButton;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.contTitlebar)
    RelativeLayout contTitlebar;
    private Context context;


    public Toolbar(Context context) {
        super(context);
        this.context = context;
        initLayout(context);
    }

    public Toolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
        if (attrs != null)
            initAttrs(context, attrs);
    }

    public Toolbar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initLayout(context);
        if (attrs != null)
            initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
    }

    public ImageButton getImgLeftButton() {
        return imgLeftButton;
    }

    public TextView getTxtTitle() {
        return txtTitle;
    }

    public RelativeLayout getContTitlebar() {
        return contTitlebar;
    }

    private void initLayout(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.toolbar, this);
        ButterKnife.bind(this, view);
    }


    public void showSideMenuIcon() {
        imgLeftButton.setVisibility(View.VISIBLE);
    }

    public void hideSideMenuIcon() {
        imgLeftButton.setVisibility(View.GONE);
    }

    public void setSubHeading(String subHeading) {
        getTxtTitle().setVisibility(VISIBLE);
        getTxtTitle().setText(subHeading + "");

    }

    public void resetTitleBar() {

        getImgLeftButton().setVisibility(INVISIBLE);
        getImgLeftButton().setImageDrawable(null);
        getTxtTitle().setVisibility(INVISIBLE);


    }

    public void setTitleBarColor(int bgColor) {
        getContTitlebar().setBackgroundColor(getResources().getColor(bgColor));
    }

    public void showBackButton(final BaseActivity baseActivity) {
        getImgLeftButton().setVisibility(VISIBLE);
        getImgLeftButton().setImageResource(R.mipmap.ic_launcher);
        getImgLeftButton().setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (baseActivity != null) {

                    baseActivity.onBackPressed();
                }

            }
        });
    }

    public void showLeftButton(int mDrawable, OnClickListener listener) {
        getImgLeftButton().setVisibility(VISIBLE);

        getImgLeftButton().setImageResource(mDrawable);
        getImgLeftButton().setOnClickListener(listener);
    }

    public void showLeftButton(Activity context, int mDrawable, OnClickListener listener) {
        getImgLeftButton().setVisibility(VISIBLE);
        Drawable icon;
        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            icon = VectorDrawableCompat.create(context.getResources(), mDrawable, context.getTheme());
        } else {
            icon = context.getResources().getDrawable(mDrawable);

        }

        getImgLeftButton().setImageDrawable(icon);
//        getImgLeftButton().setImageResource(mDrawable);
        getImgLeftButton().setOnClickListener(listener);
    }


}
