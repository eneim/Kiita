package im.ene.lab.kiita.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;

import im.ene.lab.kiita.R;
import im.ene.lab.library.qiita4j.Endpoints;
import im.ene.lab.library.qiita4j.QiitaClient;

/**
 * Created by eneim on 1/12/15.
 */
public class WebViewActivity extends ActionBarActivity {

    public static final String TAG = WebViewActivity.class.getSimpleName();

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mWebView = new WebView(this);
        setContentView(mWebView);

        mWebView.setWebViewClient(mWebClient);
        mWebView.loadUrl(Endpoints.AUTH_ENDPOINT);
    }

    private WebViewClient mWebClient = new WebViewClient() {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d(TAG, "web:callback:" + url);

            // catch the application callback url here and return to LoginActivity
            if (url.startsWith(getString(R.string.api_callback))) {
                // FIXME it is necessary to initialize an Intent with Activity class?
                Intent result = new Intent(WebViewActivity.this, LoginActivity.class);
                // setup return result
                Bundle bundle = new Bundle();
                bundle.putString("callback", url);
                result.putExtras(bundle);

                setResult(RESULT_OK, result);
                finishActivity();
                return true;
            } else {
                return super.shouldOverrideUrlLoading(view, url);
            }
        }
    };

    private void finishActivity() {
        finish();
    }
}
