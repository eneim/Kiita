package im.ene.lab.library.qiita4j.models.response;

import com.google.gson.annotations.SerializedName;

import im.ene.lab.library.utils.JsonUtils;

/**
 * Created by eneim on 1/12/15.
 */
public class AccessTokenResponse {

    @SerializedName("client_id")
    public String client_id;

    @SerializedName("scopes")
    public String[] scopes;

    @SerializedName("token")
    public String token;

    @Override
    public String toString() {
        return JsonUtils.GSON.toJson(this);
    }
}
