package com.leapfrog.inventorymanagementsystem.widgets;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.data.HawkUtils;
import com.leapfrog.inventorymanagementsystem.events.OnItemSelectListener;
import com.leapfrog.inventorymanagementsystem.models.Item;
import com.leapfrog.inventorymanagementsystem.utils.GeneralUtils;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * items for dashboard
 */
public class CustomItemViewGroup extends RelativeLayout implements View.OnTouchListener {

    private final long ANIMATION_DURATION = 700;

    @Bind(R.id.tv_item_name)
    TextView tvItemName;

    @Bind(R.id.iv_item_pic)
    ImageView ivItemPic;

    @Bind(R.id.iv_fav_indicator)
    ImageView ivFavIndicator;

    @Bind(R.id.iv_favorite)
    ImageView ivFav;

    @Bind(R.id.tv_dealer_name)
    TextView tvDealerName;

    @Bind(R.id.tv_price)
    TextView tvPrice;

    private GestureDetector gestureDetector;
    private OnItemSelectListener onItemSelectListener;
    private Item item;

    public CustomItemViewGroup(Context context, OnItemSelectListener onItemSelectListener) {
        this(context, null, 0);
        this.onItemSelectListener = onItemSelectListener;
    }

    public CustomItemViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomItemViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.list_items, this, false);
        this.addView(view);

        ButterKnife.bind(this, view);

        gestureDetector = new GestureDetector(context, new GestureListener());
        view.setOnTouchListener(CustomItemViewGroup.this);
    }

    /**
     * set data to views
     *
     * @param item
     */
    public void setData(Item item) {
        this.item = item;
        tvItemName.setText(item.getItemName());
        tvDealerName.setText(item.getDealerName());
        tvPrice.setText("¥" + item.getPrice());
        Glide.with(getContext()).load(item.getPicDrawableId()).fitCenter().into(ivItemPic);

        if (HawkUtils.getFavoriteItems() != null)
            if (HawkUtils.getFavoriteItems().contains(item.getItemCode())) {
                ivFavIndicator.setVisibility(VISIBLE);
            } else {
                ivFavIndicator.setVisibility(GONE);
            }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return gestureDetector.onTouchEvent(motionEvent);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            onItemSelectListener.onItemSelected(item, ivItemPic);
            return super.onSingleTapConfirmed(e);
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            ArrayList<String> arrayList = new ArrayList<>();

            if (HawkUtils.getFavoriteItems() != null)
                arrayList = HawkUtils.getFavoriteItems();

            if (!arrayList.contains(item.getItemCode())) {
                arrayList.add(item.getItemCode());
                HawkUtils.setFavoriteItems(arrayList);
                animateFav(0, GeneralUtils.convertDpToPixel(20, getContext()));
            } else {
                arrayList.remove(item.getItemCode());
                HawkUtils.setFavoriteItems(arrayList);
                animateFav(GeneralUtils.convertDpToPixel(20, getContext()), 0);
            }

            return true;
        }
    }

    /**
     * animate favorite icon
     *
     * @param startValue start value
     * @param endValue   end value
     */
    private void animateFav(final float startValue, final float endValue) {

        ValueAnimator animator = new ValueAnimator().ofFloat(startValue, endValue);
        animator.setDuration(ANIMATION_DURATION);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ivFav.setScaleX((int) ((Float) (valueAnimator.getAnimatedValue())).floatValue());
                ivFav.setScaleY((int) ((Float) (valueAnimator.getAnimatedValue())).floatValue());
            }

        });

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                ivFav.setVisibility(VISIBLE);

                if (startValue > endValue) {
                    ivFavIndicator.setVisibility(GONE);
                } else {
                    ivFavIndicator.setVisibility(VISIBLE);
                }
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                ivFav.setVisibility(GONE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        animator.start();
    }

}

