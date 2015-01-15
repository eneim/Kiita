package im.ene.lab.library.qiita4j;

import android.content.Context;

import com.loopj.android.http.BaseJsonHttpResponseHandler;

/**
 * Created by eneim on 1/11/15.
 */
public class QiitaClient {

    private static final QiitaExecutorImpl mExecutor = new QiitaExecutorImpl();

    private QiitaClient() {

    }

    public static void requestToken(Context context, String code, BaseJsonHttpResponseHandler handler) {
        mExecutor.requestToken(context, code, handler);
    }

    public static void getAuthenticatedUser(Context context, BaseJsonHttpResponseHandler handler) {
        mExecutor.getAuthenticatedUser(context, handler);
    }

    public static void getItems(Context context, BaseJsonHttpResponseHandler handler) {
        mExecutor.getItems(context, handler);
    }
}
