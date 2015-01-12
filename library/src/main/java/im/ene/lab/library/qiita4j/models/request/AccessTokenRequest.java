package im.ene.lab.library.qiita4j.models.request;

import com.google.gson.annotations.SerializedName;

import im.ene.lab.library.utils.JsonUtils;

/**
 * Created by eneim on 1/12/15.
 */
public class AccessTokenRequest {

    @SerializedName("client_id")
    public String client_id;

    @SerializedName("client_secret")
    public String client_secret;

    @SerializedName("code")
    public String code;

    public AccessTokenRequest(String client_id, String client_secret, String code) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.code = code;
    }

    @Override
    public String toString() {
        return JsonUtils.GSON.toJson(this);
    }
}
