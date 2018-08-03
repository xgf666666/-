package com.microple.jademall.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.microple.jademall.R;

/**
 * author: linfeng
 * date: 2018/8/2.
 * describe:首页轮播
 */

public class BannerFragment extends Fragment {
    private String imageUrl;
    private ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_common, null);
        imageView = (ImageView) rootView.findViewById(R.id.iv_banner);
        Glide.with(getActivity()).load(imageUrl).into(imageView);
        return rootView;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
