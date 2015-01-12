package im.ene.lab.kiita.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.loopj.android.http.BaseJsonHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import im.ene.lab.kiita.R;
import im.ene.lab.library.qiita4j.QiitaClient;
import im.ene.lab.library.qiita4j.models.response.AccessTokenResponse;
import im.ene.lab.library.utils.JsonUtils;

/**
 * Created by eneim on 1/12/15.
 */
public class LoginActivity extends ActionBarActivity {

    public static final String TAG = LoginActivity.class.getSimpleName();

    public static final int LOGIN_REQUEST_CODE = 1024;

    private QiitaClient mClient;

    private String mCode = null, mToken = null;

    private Button mBtnLoginGithub, mBtnLoginTwitter;
    private View.OnClickListener onLoginClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            int loginType = QiitaClient.LOGIN_NORMAL;

            if (v == mBtnLoginGithub) {
                loginType = QiitaClient.LOGIN_GITHUB;
            } else if (v == mBtnLoginTwitter) {
                loginType = QiitaClient.LOGIN_TWITTER;
            }

            Intent intent = new Intent(LoginActivity.this, WebViewActivity.class);
            intent.putExtra("login_type", loginType);
            startActivityForResult(intent, LOGIN_REQUEST_CODE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        mBtnLoginGithub = (Button) findViewById(R.id.button_login_github);
        mBtnLoginTwitter = (Button) findViewById(R.id.button_login_twitter);

        mBtnLoginGithub.setOnClickListener(onLoginClickListener);
        mBtnLoginTwitter.setOnClickListener(onLoginClickListener);

        mClient = new QiitaClient();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_CANCELED) {
            update(false);
            finish();
        }

        if (requestCode != LOGIN_REQUEST_CODE) {
            update(false);
            return;
        }

        if (data != null) {
            Bundle bundle = data.getExtras();
            if (bundle != null && bundle.containsKey("callback")) {
                String callback = bundle.getString("callback");
                Log.d(TAG, "login:callback:" + callback);
                List<NameValuePair> params = null;
                try {
                    params = URLEncodedUtils.parse(new URI(callback), "UTF-8");

                    if (params.size() > 0) {
                        for (NameValuePair pair : params) {
                            if ("code".equals(pair.getName())) {
                                // TODO use this code to get access token
                                mCode = pair.getValue();
                                Log.d(TAG, "request:code:" + mCode);
                                break;
                            }
                        }
                    }
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        }

        if (mCode != null) {
            mClient.requestToken(this, mCode, new BaseJsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, Object response) {
                    Log.d(TAG, "response: " + rawJsonResponse);

                    // handle the response here
                    AccessTokenResponse response = JsonUtils.GSON.fromJson(rawJsonResponse, AccessTokenResponse.class);
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
    }

    private void update(boolean isLoggedIn) {

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Log.d("intent", intent + "");
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
