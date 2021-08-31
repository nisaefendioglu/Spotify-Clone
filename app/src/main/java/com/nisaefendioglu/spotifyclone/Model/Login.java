package com.nisaefendioglu.spotifyclone.Model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.nisaefendioglu.spotifyclone.Services.Authentication;
import com.nisaefendioglu.spotifyclone.R;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


    }
    public void onRequestTokenClicked(View view) {
        Intent intent = new Intent(this, Authentication.class);
        startActivity(intent);
    }
}
