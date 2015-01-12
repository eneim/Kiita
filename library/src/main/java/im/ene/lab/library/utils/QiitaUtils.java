package im.ene.lab.library.utils;

import android.content.Context;
import android.content.SharedPreferences;

import im.ene.lab.library.R;

/**
 * Created by eneim on 1/11/15.
 */
public class QiitaUtils {

    private QiitaUtils() {
    }

    public static String getToken(Context context) {
        SharedPreferences pref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        if (!pref.contains(context.getString(R.string.qiita_token)))
            return null;
        else
            return pref.getString(context.getString(R.string.qiita_token), null);
    }

    public static void saveToken(Context context, String token) {
        SharedPreferences pref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(context.getString(R.string.qiita_token), token);
        editor.commit();
    }

    public static void deleteToken(Context context) {
        SharedPreferences pref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        if (pref.contains(context.getString(R.string.qiita_token))) {
            SharedPreferences.Editor editor = pref.edit();
            editor.remove(context.getString(R.string.qiita_token));
            editor.commit();
        }
    }

}
