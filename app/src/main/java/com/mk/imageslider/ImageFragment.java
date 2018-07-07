package com.mk.imageslider;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageFragment extends Fragment {

    private final static String ID_LABEL = "resourceId";
    public static ImageFragment getInstance(int resourceId) {
        Bundle args = new Bundle();
        args.putInt(ID_LABEL, resourceId);
        ImageFragment imageFragment = new ImageFragment();
        imageFragment.setArguments(args);
        return imageFragment;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image, container, false);
        Bundle args = getArguments();
        int resId;
        if(args != null) {
            resId = args.getInt(ID_LABEL);
        }
        else
            return view;
        ImageView imageView = view.findViewById(R.id.imageView);
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        imageView.setImageBitmap(ImageResize.resize(getActivity().getResources(), resId, height, width));
        return view;
    }

}
