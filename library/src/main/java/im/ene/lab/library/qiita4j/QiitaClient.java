package im.ene.lab.library.qiita4j;

import android.content.Context;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BaseJsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

/**
 * Created by eneim on 1/11/15.
 */
public class QiitaClient {

    public static final int LOGIN_NORMAL = 0;

    public static final int LOGIN_GITHUB = 1;

    public static final int LOGIN_TWITTER = 2;

    private static final QiitaExecutorImpl mExecutor = new QiitaExecutorImpl();

    public QiitaClient() {

    }

    public static void requestToken(Context context, String code, BaseJsonHttpResponseHandler handler) {
        mExecutor.requestToken(context, code, handler);
    }

    public static void authorize(Context context, AsyncHttpResponseHandler handler) {
        mExecutor.authorize(context, handler);
    }

    public static void getAuthenticatedUser(Context context, BaseJsonHttpResponseHandler handler) {
        mExecutor.getAuthenticatedUser(context, handler);
    }
}
