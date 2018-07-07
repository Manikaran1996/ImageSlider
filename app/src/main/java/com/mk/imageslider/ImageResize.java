package com.mk.imageslider;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageResize {

    public static Bitmap resize(Resources res, int resId, int reqHeight, int reqWidth) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        int height = options.outHeight;
        int width = options.outWidth;
        options.inSampleSize = getInSampleSize(reqHeight, reqWidth, height, width);
        options.inJustDecodeBounds = false;
        Bitmap bm = BitmapFactory.decodeResource(res, resId, options);
        return bm;

    }

    private static int getInSampleSize(int reqHeight, int reqWidth, int actualHeight, int actualWidth) {

        int inSample = 1;
        while(actualHeight > reqHeight) {
            actualHeight /= 2;
            actualWidth /= 2;
            inSample *= 2;
        }
        return inSample;

    }
}
