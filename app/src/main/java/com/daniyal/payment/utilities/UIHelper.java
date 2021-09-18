package com.daniyal.payment.utilities;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daniyal.payment.R;

import org.w3c.dom.Text;


/* This class is to helper for UI related methods*/
public class UIHelper {


    public static void showDialog(Context context , String msg) {

        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.layout_dialog);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        LinearLayout tv_done = dialog.findViewById(R.id.layout_done);
        TextView tv_msg = dialog.findViewById(R.id.tv_msg);
        dialog.setCancelable(false);
        tv_msg.setText(msg);


        tv_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        dialog.show();
    }
}
