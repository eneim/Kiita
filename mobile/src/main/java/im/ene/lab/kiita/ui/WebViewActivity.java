package im.ene.lab.kiita.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import im.ene.lab.kiita.R;

/**
 * Created by eneim on 1/12/15.
 */
public class WebViewActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView mainView = new WebView(this);
        setContentView(mainView);

        String test = "https://qiita.com/auth/github?do=&redirect_to=/api/v2/oauth/authorize?client_id=bfd0c62e1d881bf1eff108554cbc3cbb389bad6f&scope=read_qiita&state=299792458&target=";

        mainView.setWebViewClient(mWebClient);
        mainView.loadUrl(test);
    }

    private WebViewClient mWebClient = new WebViewClient() {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("callback", url + "");
            if (url.startsWith(getString(R.string.api_callback))) {
                Intent result = new Intent();
                result.putExtra("callback", url);
                finishActivity();
                return true;
            } else
                return super.shouldOverrideUrlLoading(view, url);
        }
    };

    private void finishActivity() {
        finish();
    }
}
