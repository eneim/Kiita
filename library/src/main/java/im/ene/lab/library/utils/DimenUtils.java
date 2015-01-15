package im.ene.lab.library.utils;

import android.content.Context;

/**
 * Created by eneim on 1/11/15.
 */
public class DimenUtils {

    /**
     * learn from Google iosched
     * @param context
     * @return
     */
    public static boolean isTablet(Context context) {
        return context.getResources().getConfiguration().smallestScreenWidthDp >= 600;
    }
}
