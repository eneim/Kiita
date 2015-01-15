package im.ene.lab.kiita.widgets;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.Image;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by eneim on 1/15/15.
 */
public class NaviHeaderImageView extends ImageView {
    public NaviHeaderImageView(Context context) {
        super(context);
    }

    public NaviHeaderImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NaviHeaderImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NaviHeaderImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = width * 9 / 16;
        setMeasuredDimension(width, height);
    }

    @Override
    public void requestLayout() {
        forceLayout();
    }
}
