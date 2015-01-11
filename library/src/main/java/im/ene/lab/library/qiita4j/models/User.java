package im.ene.lab.library.qiita4j.models;

import android.support.annotation.Nullable;

/**
 * Created by eneim on 1/11/15.
 */
public class User {

    @Nullable
    public String description;

    @Nullable
    public String facebook_id;

    public int followees_count;

    public int followers_count;

    @Nullable
    public String github_login_name;

    public String id;

    public int items_count;

    @Nullable
    public String linkedin_id;

    @Nullable
    public String location;

    @Nullable
    public String name;

    @Nullable
    public String organization;

    public String profile_image_url;

    @Nullable
    public String twitter_screen_name;

    @Nullable
    public String website_url;
}
