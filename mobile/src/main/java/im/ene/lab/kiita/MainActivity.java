package im.ene.lab.kiita;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.loopj.android.http.BaseJsonHttpResponseHandler;

import org.apache.http.Header;

import im.ene.lab.library.qiita4j.QiitaClient;


public class MainActivity extends ActionBarActivity {

    String test = "https://qiita.com/api/v2/oauth/authorize?client_id=bfd0c62e1d881bf1eff108554cbc3cbb389bad6f&scope=read_qiita&state=bb17785d811bb6913ef54b0a7657de780defaa2d";

    private QiitaClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mClient = new QiitaClient(this);

//        WebView view = new WebView(this);
//        setContentView(view);
//        view.setWebViewClient(new WebViewClient() {
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                Log.d("callback", url + "");
//                if (url.startsWith("http://lab.ene.im/kiita/oauth")) {
//                    Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
//                }
//
//                return super.shouldOverrideUrlLoading(view, url);
//            }
//
//        });
//        view.loadUrl(test);
    }

    @Override
    protected void onStart() {
        super.onStart();

        mClient.getItems(new BaseJsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, Object response) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, Object errorResponse) {

            }

            @Override
            protected Object parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
                return null;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
