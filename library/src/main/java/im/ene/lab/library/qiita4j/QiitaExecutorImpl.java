package im.ene.lab.library.qiita4j;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BaseJsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

import java.io.UnsupportedEncodingException;

import im.ene.lab.library.R;
import im.ene.lab.library.qiita4j.models.request.AccessTokenRequest;
import im.ene.lab.library.utils.QiitaUtils;

/**
 * Created by eneim on 1/11/15.
 */
public class QiitaExecutorImpl implements QiitaExecutor {

    private final AsyncHttpClient client = new AsyncHttpClient();

    @Override
    public void getItems(Context context, BaseJsonHttpResponseHandler handler) {
        getItems(context, default_per_page, handler);
    }

    @Override
    public void getItems(Context context, int per_page, BaseJsonHttpResponseHandler handler) {
        getItems(contextm default_page, per_page, handler);
    }

    @Override
    public void getItems(Context context, int page, int per_page, BaseJsonHttpResponseHandler handler) {
        if (per_page > max_per_page) per_page = max_per_page;
        // TODO
    }

    @Override
    public void getUser(BaseJsonHttpResponseHandler handler) {

    }

    @Override
    public void authorize(Context context, AsyncHttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.put(QiitaExecutor.CLIENT_ID, context.getString(R.string.kiita_client_id));
        params.put(QiitaExecutor.SCOPE, "read_qiita write_qiita");
        params.put(QiitaExecutor.STATE, context.getString(R.string.kiita_state));

        this.client.get(context, Endpoints.authorizeEndpoint(), params, handler);

    }

    public void requestToken(Context context, String code, BaseJsonHttpResponseHandler handler) {
        AccessTokenRequest request = new AccessTokenRequest(context.getString(R.string.kiita_client_id), context.getString(R.string.kiita_client_secret), code);

        StringEntity se;
        try {
            se = new StringEntity(request.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return;
        }
        if (se != null)
            se.setContentType("application/json");

        this.client.post(context, Endpoints.requestTokenEndpoint(), se, null, handler);
    }

    @Override
    public void getAuthenticatedUser(Context context, BaseJsonHttpResponseHandler handler) {
        Header[] headers = new Header[1];
        headers[0] = new BasicHeader("Authorization", "Bearer " + QiitaUtils.getToken(context));
        this.client.get(context, Endpoints.authUserEndpoint(), headers, null, handler);
    }
}
