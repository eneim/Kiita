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

    private final QiitaExecutorImpl mExecutor;

    public QiitaClient() {
        this.mExecutor = new QiitaExecutorImpl();
    }

    public void requestToken(Context context, String code, BaseJsonHttpResponseHandler handler) {
        this.mExecutor.requestToken(context, code, handler);
    }

    public void authorize(Context context, AsyncHttpResponseHandler handler) {
        this.mExecutor.authorize(context, handler);
    }
}
