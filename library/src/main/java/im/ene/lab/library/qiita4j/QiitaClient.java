package im.ene.lab.library.qiita4j;

import android.content.Context;

import com.loopj.android.http.BaseJsonHttpResponseHandler;

import im.ene.lab.library.R;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.Response;

/**
 * Created by eneim on 1/11/15.
 */
public class QiitaClient {

    public static final int LOGIN_NORMAL = 0;

    public static final int LOGIN_GITHUB = 1;

    public static final int LOGIN_TWITTER = 2;

    private static final QiitaExecutorImpl mExecutor = new QiitaExecutorImpl();

    private static final QiitaService qiitaService = new RestAdapter.Builder().setEndpoint(Endpoints.QIITA).build()
                                                                .create(QiitaService.class);

    public QiitaClient() {

    }

    public static void requestToken(Context context, String code, BaseJsonHttpResponseHandler handler) {
        mExecutor.requestToken(context, code, handler);
    }

    public static void authorize(Context context, Callback<Response> callback) {
        qiitaService.authorize(context.getString(R.string.kiita_client_id),
                context.getString(R.string.kiita_scope),
                context.getString(R.string.kiita_state), callback);
    }

    public static void getAuthenticatedUser(Context context, BaseJsonHttpResponseHandler handler) {
        mExecutor.getAuthenticatedUser(context, handler);
    }
}
