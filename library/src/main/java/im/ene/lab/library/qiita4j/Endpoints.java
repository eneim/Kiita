package im.ene.lab.library.qiita4j;

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
    public static final String AUTHORIZE = API + "/oauth/authorize";

    /**
     * endpoint: access_token
     *
     * request: POST /api/v2/access_tokens
     *
     * delete token: DELETE /api/v2/access_tokens/:token
     */
    public static final String ACCESS_TOKEN = API + "/access_tokens";

    /**
     * endpoint: comments
     *
     * get comment: GET /api/v2/comments/:id
     *
     * delete comment: DELETE /api/v2/comments/:id
     *
     * patch comment: PATCH /api/v2/comments/:id
     */
    public static final String COMMENTS = API + "/comments";

    /**
     *  login helper
     *
     *  login by github endpoint: GITHUB + authorizeRequest()
     */
    public final String GITHUB = "https://qiita.com/auth/github?do=&redirect_to=";

    public final String TWITTER ="https://qiita.com/auth/twitter?do=&redirect_to=";
}
