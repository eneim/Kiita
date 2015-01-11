package im.ene.lab.kiita;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    String test = "https://qiita.com/api/v2/oauth/authorize?client_id=bfd0c62e1d881bf1eff108554cbc3cbb389bad6f&scope=read_qiita&state=bb17785d811bb6913ef54b0a7657de780defaa2d";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
