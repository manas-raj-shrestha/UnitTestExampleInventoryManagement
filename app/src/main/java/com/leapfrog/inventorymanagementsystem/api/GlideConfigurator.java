package com.leapfrog.inventorymanagementsystem.api;

import android.content.Context;
import android.graphics.Bitmap;

import com.bumptech.glide.BitmapRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.GlideModule;
import com.leapfrog.inventorymanagementsystem.R;

/**
 * Created by laaptu on 3/18/16.
 */
public class GlideConfigurator implements GlideModule {
    public int POOL_SIZE_IN_BYTES = 20 * 1024 * 1024;

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888)
                .setBitmapPool(new LruBitmapPool(POOL_SIZE_IN_BYTES))
                .setMemoryCache(new LruResourceCache(POOL_SIZE_IN_BYTES));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }

    public static RequestManager getRequestManager(Context context) {
        return Glide.with(context);
    }

    public static BitmapRequestBuilder<String, Bitmap> load(Context context, String path) {
        return getRequestManager(context).load(path)
                .asBitmap()
                .dontTransform()
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .skipMemoryCache(false);
    }

    public static BitmapRequestBuilder<String, Bitmap> loadImage(Context context, String path, int borderColor) {

        return load(context, path)
                .placeholder(R.drawable.ic_device_now_widgets)
                .error(R.drawable.ic_device_now_widgets);

    }


}
