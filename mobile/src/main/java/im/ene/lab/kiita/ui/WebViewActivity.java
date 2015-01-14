package im.ene.lab.kiita.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

import im.ene.lab.kiita.R;
import im.ene.lab.library.qiita4j.Endpoints;

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

    private String getStringFromInputStream(InputStream stream) throws IOException {
        int n = 0;
        char[] buffer = new char[1024 * 4];
        InputStreamReader reader = new InputStreamReader(stream, "UTF8");
        StringWriter writer = new StringWriter();
        while (-1 != (n = reader.read(buffer))) writer.write(buffer, 0, n);
        return writer.toString();
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
