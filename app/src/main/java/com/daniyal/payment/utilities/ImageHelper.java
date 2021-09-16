package com.daniyal.payment.utilities;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.net.URL;

public class ImageHelper {

    public static void loadNetworkImage(ImageView imageView, URL url) {
        Glide.with(imageView.getContext())
                .load(url.toString())
                .into(imageView);
    }

}