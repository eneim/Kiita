package im.ene.lab.library.qiita4j.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by eneim on 1/11/15.
 */
public class Item {

    public String body;

    public boolean coediting;

    public String created_at;

    public String id;

    @SerializedName("private")
    public boolean isPrivate;

    public String rendered_body;

    public List<Item.Tag> tags;

    public String title;

    public String updated_at;

    public String url;

    public User user;

    public class Tag {

        public String icon_url;

        public String name;

        public List<String> versions;
    }
}
