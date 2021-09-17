package com.daniyal.payment.utilities;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.daniyal.payment.R;
import com.daniyal.payment.enums.NetworkLinks;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ImageHelper {

    public static void loadNetworkImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }


    public static String getLogo(Map<String, URL> map, Context context) {
        if (map != null && !map.isEmpty()) {
            if (map.get(NetworkLinks.LOGO.getLinkName()) != null && !map.get(NetworkLinks.LOGO.getLinkName()).equals("")) {
                return String.valueOf(map.get(NetworkLinks.LOGO.getLinkName()));
            }
        }
        return context.getResources().getString(R.string.dummyCard);
    }

}