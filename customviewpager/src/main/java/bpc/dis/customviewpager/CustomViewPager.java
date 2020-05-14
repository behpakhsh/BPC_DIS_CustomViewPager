package bpc.dis.customviewpager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class CustomViewPager extends ViewPager {

    private boolean enabled;
    private OnPageChangeListener onPageChangeListener;

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.enabled = true;
    }

    @Override
    @SuppressLint("ClickableViewAccessibility")
    public boolean onTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onTouchEvent(event);
        }
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (this.enabled) {
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }

    @Override
    public void addOnPageChangeListener(@NonNull OnPageChangeListener onPageChangeListener) {
        super.addOnPageChangeListener(onPageChangeListener);
        this.onPageChangeListener = onPageChangeListener;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (onPageChangeListener != null) {
            removeOnPageChangeListener(onPageChangeListener);
        }
    }

    public boolean isPagingEnabled() {
        return enabled;
    }

    public void setPagingEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
