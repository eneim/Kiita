package im.ene.lab.library.qiita4j;

import android.content.Context;

import com.loopj.android.http.BaseJsonHttpResponseHandler;

/**
 * Created by eneim on 1/11/15.
 */
public class QiitaClient {

    public static final int LOGIN_NORMAL = 0;

    public static final int LOGIN_GITHUB = 1;

    public static final int LOGIN_TWITTER = 2;

    private final Context mContext;

    public QiitaClient(Context context) {
        this.mContext = context;
    }

    public void getItems(BaseJsonHttpResponseHandler handler) {

    }

    public void login(Context context, int type, BaseJsonHttpResponseHandler handler) {
        switch (type) {
            case LOGIN_NORMAL:
                loginNormal(context, handler);
                break;
            case LOGIN_GITHUB:
                loginGithub(context, handler);
                break;
            case LOGIN_TWITTER:
                loginTwitter(context, handler);
                break;
            default:
                break;
        }
    }

    private void loginGithub(Context context, BaseJsonHttpResponseHandler handler) {


    }

    private void loginTwitter(Context context, BaseJsonHttpResponseHandler handler) {

    }

    private void loginNormal(Context context, BaseJsonHttpResponseHandler handler) {

    }
}
