package im.ene.lab.library.qiita4j;

import android.content.Context;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BaseJsonHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

/**
 * Created by eneim on 1/11/15.
 */
public interface QiitaExecutor {

    /**
     * scope name: read_qiita
     */
    public final String READ_QIITA = "read_qiita";

    /**
     * scope name: read_qiita_team
     */
    public final String READ_QIITA_TEAM = "read_qiita_team";

    /**
     * scope name: write_qiita
     */
    public final String WRITE_QIITA = "write_qiita";

    /**
     * scope name: write_qiita_team
     */
    public final String WRITE_QIITA_TEAM = "write_qiita_team";

    /**
     * param key: client_id
     *
     * Pattern: /^[0-9a-f]{40}$/
     */
    public final String CLIENT_ID = "client_id";

    /**
     * param key: client_secret
     */
    public final String CLIENT_SECRET = "client_secret";

    /**
     * param key: code
     */
    public final String CODE = "code";

    /**
     * param key: scope (string)
     *
     * Example: \"read_qiita write_qiita_team\"
     */
    public final String SCOPE = "scope";

    /**
     * param key: scopes (array)
     */
    public final String SCOPES = "scopes";

    /**
     * param key: state
     */
    public final String STATE = "state";

    /**
     * param key: token
     *
     * Pattern: /^[0-9a-f]{40}$/
     */
    public final String TOKEN = "token";

    /**
     * default start page = 1
     */
    public int default_page = 1;

    /**
     * default per_page = 20;
     */
    public int default_per_page = 20;

    /**
     * max per_page = 100
     */
    public int max_per_page = 100;

    /**
     * methods
     */
    public void getItems(BaseJsonHttpResponseHandler handler);

    public void getItems(int per_page, BaseJsonHttpResponseHandler handler);

    public void getItems(int page, int per_page, BaseJsonHttpResponseHandler handler);

    /**
     * get user info
     */
    public void getUser(BaseJsonHttpResponseHandler handler);

    public void authorize(Context context, AsyncHttpResponseHandler handler);

    public void requestToken(Context context, String code, BaseJsonHttpResponseHandler handler);
}
