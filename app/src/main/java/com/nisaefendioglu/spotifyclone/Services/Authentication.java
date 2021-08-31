package com.nisaefendioglu.spotifyclone.Services;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nisaefendioglu.spotifyclone.Home;
import com.nisaefendioglu.spotifyclone.MainActivity;
import com.nisaefendioglu.spotifyclone.R;
import com.nisaefendioglu.spotifyclone.Model.User;
import com.spotify.sdk.android.auth.AuthorizationClient;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;

import static com.spotify.sdk.android.auth.AuthorizationResponse.Type.TOKEN;

public class Authentication extends AppCompatActivity {

    private SharedPreferences.Editor editor;
    private SharedPreferences msharedPreferences;

    private RequestQueue queue;

    private static final String CLIENT_ID  = "619314c4960a41559480b34a1ddd7b1c";
    private static final int REQUEST_CODE = 1337;
    public static final String REDIRECT_URI = "https://open.spotify.com/playlist/";

    Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        LoginActivityAuthentication();
        msharedPreferences = this.getSharedPreferences("SPOTIFY", 0);
        queue = Volley.newRequestQueue(this);
    }


    public void LoginActivityAuthentication(){
        AuthorizationRequest.Builder builder = new AuthorizationRequest.Builder(CLIENT_ID, TOKEN, REDIRECT_URI);
        builder.setScopes(new String[]{"streaming user-top-read"});
        AuthorizationRequest request = builder.build();
        AuthorizationClient.openLoginActivity(this, REQUEST_CODE, request);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            AuthorizationResponse response = AuthorizationClient.getResponse(resultCode, data);

            switch (response.getType()) {
                case TOKEN:
                    editor = getSharedPreferences("SPOTIFY", 0).edit();
                    editor.putString("token", response.getAccessToken());
                    Log.d("START", "This is the auth token");
                    editor.apply();
                    waitForUserInfo();
                    break;
                case ERROR:
                    break;
            }
        }
    }

    void waitForUserInfo() {
        UserService userService = new UserService(queue, msharedPreferences);
        userService.get(() -> {
            User user = userService.getUser();
            editor = getSharedPreferences("SPOTIFY", 0).edit();

            editor.putString("userid", user.id);
            editor.putString("name", user.display_name);

            editor.commit();
            startMainActivity();
        });
    }

    private void startMainActivity() {
        Intent intent = new Intent(Authentication.this, MainActivity.class);
        startActivity(intent);
    }
}

