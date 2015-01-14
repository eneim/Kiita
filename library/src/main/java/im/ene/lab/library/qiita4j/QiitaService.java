package im.ene.lab.library.qiita4j;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by eneim on 1/15/15.
 */
public interface QiitaService {

    /**
     * authorize
     */
    @GET("/api/v2/oauth/authorize")
    void authorize(@Query("client_id") String client_id,
                   @Query("scope") String scope,
                   @Query("state") String state,
                   Callback<Response> callback);
}
