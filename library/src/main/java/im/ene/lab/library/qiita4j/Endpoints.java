package im.ene.lab.library.qiita4j;

import android.util.Log;

/**
 * Created by eneim on 1/11/15.
 */
public final class Endpoints {

    /**
     * ref: https://qiita.com/api/v2/docs
     */

    /**
     * API version code;
     *
     * in case they change their API version, I will change this string only
     * hopfully they don't change the endpoint name themselves
     */
    private static final String API = "/api/v2";

    /**
     * endpoint: authorize
     *
     * request: GET /api/v2/oauth/authorize
     */
    private static final String AUTHORIZE = API + "/oauth/authorize";

    /**
     * authienticated user
     */
    private static final String AUTH_USER = API + "/authenticated_user";

    /**
     * endpoint: access_token
     *
     * request: POST /api/v2/access_tokens
     *
     * delete token: DELETE /api/v2/access_tokens/:token
     */
    private static final String ACCESS_TOKEN = API + "/access_tokens";

    /**
     * endpoint: comments
     *
     * get comment: GET /api/v2/comments/:id
     *
     * delete comment: DELETE /api/v2/comments/:id
     *
     * patch comment: PATCH /api/v2/comments/:id
     */
    private static final String COMMENTS = API + "/comments";

    /**
     *  login helper
     *
     *  login by github endpoint: GITHUB + authorizeRequest()
     */
    public static final String GITHUB = "https://qiita.com/auth/github?do=&redirect_to=";

    public static final String TWITTER ="https://qiita.com/auth/twitter?do=&redirect_to=";

    public static final String QIITA = "https://qiita.com";

    public static final String AUTH_ENDPOINT = "https://qiita.com/api/v2/oauth/authorize" +
            "?client_id=bfd0c62e1d881bf1eff108554cbc3cbb389bad6f" +
            "&scope=read_qiita+write_qiita" +
            "&state=299792459";

    public static String requestTokenEndpoint() {
        String endpoint = QIITA + ACCESS_TOKEN;
        Log.d("endpoint", endpoint + "");
        return endpoint;
    }

    public static String authorizeEndpoint() {
        String endpoint = QIITA + AUTHORIZE;
        Log.d("endpoint", endpoint + "");
        return endpoint;
    }

    public static String authUserEndpoint() {
        String endpoint = QIITA + AUTH_USER;
        Log.d("endpoint", endpoint + "");
        return endpoint;
    }

}
