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

    public void login(int type, BaseJsonHttpResponseHandler handler) {
        switch (type) {
            case LOGIN_NORMAL:
                loginNormal(handler);
                break;
            case LOGIN_GITHUB:
                loginGithub(handler);
                break;
            case LOGIN_TWITTER:
                loginTwitter(handler);
                break;
            default:
                break;
        }
    }

    private void loginGithub(BaseJsonHttpResponseHandler handler) {

    }

    private void loginTwitter(BaseJsonHttpResponseHandler handler) {

    }

    private void loginNormal(BaseJsonHttpResponseHandler handler) {

    }
}
