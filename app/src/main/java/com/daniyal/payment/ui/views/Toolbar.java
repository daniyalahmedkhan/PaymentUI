package com.daniyal.payment.ui.views;

import android.content.Context;
import android.text.Html;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daniyal.payment.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Toolbar extends RelativeLayout {

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.contTitlebar)
    LinearLayout contTitlebar;
    private Context context;
    @BindView(R.id.toolbar)
    androidx.appcompat.widget.Toolbar toolbar_;


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


    public TextView getTxtTitle() {
        return txtTitle;
    }

    public LinearLayout getContTitlebar() {
        return contTitlebar;
    }

    public androidx.appcompat.widget.Toolbar getToolbar_(){
        return toolbar_;
    }

    private void initLayout(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.toolbar, this);
        ButterKnife.bind(this, view);
    }


    public void setSubHeading(String subHeading) {
        getTxtTitle().setVisibility(VISIBLE);
        //getTxtTitle().setText(subHeading + "");
        getTxtTitle().setText(Html.fromHtml(subHeading));


    }


    public void setTitleBarColor(int bgColor) {
        getContTitlebar().setBackgroundColor(getResources().getColor(bgColor));
    }





}
