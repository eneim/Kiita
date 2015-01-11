package im.ene.lab.library.qiita4j;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.BaseJsonHttpResponseHandler;

/**
 * Created by eneim on 1/11/15.
 */
public class QiitaExcutorImpl implements QiitaExcutor {

    private final AsyncHttpClient client = new AsyncHttpClient();

    @Override
    public void getItems(BaseJsonHttpResponseHandler handler) {
        getItems(default_per_page, handler);
    }

    @Override
    public void getItems(int per_page, BaseJsonHttpResponseHandler handler) {
        getItems(default_page, per_page, handler);
    }

    @Override
    public void getItems(int page, int per_page, BaseJsonHttpResponseHandler handler) {
        if (per_page > max_per_page) per_page = max_per_page;
    }

    @Override
    public void getUser(BaseJsonHttpResponseHandler handler) {

    }
}
