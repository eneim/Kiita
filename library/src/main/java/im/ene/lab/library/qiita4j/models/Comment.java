package im.ene.lab.library.qiita4j.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by eneim on 1/11/15.
 */
public class Comment {

    /**
     *  body
     *
     *  入力されたコメントの内容を表す文字列です
     *  Example: "# Example"
     *  Type: string
     */
    @SerializedName("body")
    public String body;

    /**
     *  created_at
     *
     *  リソースが作成された日時を表します。
     *  Example: "2014-09-04T09:54:49+00:00"
     *  Type: string
     *  Format: date-time
     */
    @SerializedName("created_at")
    public String createdAt;

    /**
     *  id
     *
     *  リソースを特定するためのIDです。URL等に利用されます。
     *  Example: "3391f50c35f953abfc4f"
     *  Type: string
     *  Pattern: /^[0-9a-f]{20}$/
     */
    @SerializedName("id")
    public String id;

    /**
     *  rendered_body
     *
     *  HTMLに変換された投稿の本文です。
     *  Example: "<h1>Example</h1>"
     *  Type: string
     */
    @SerializedName("rendered_body")
    public String renderedBody;

    /**
     *  updated_at
     *
     *  リソースが作成された日時を表します。
     *  Example: "2014-09-04T09:54:49+00:00"
     *  Type: string
     *  Format: date-time
     */
    @SerializedName("updated_at")
    public String updatedAt;

    /**
     *  user
     *
     *  ユーザを表します。
     */
    @SerializedName("user")
    public User user;
}
