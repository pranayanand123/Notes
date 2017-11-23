package com.example.pranayanand.notes;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class Settings extends AppCompatActivity {

    static Switch switchTheme;
    static SharedPreferences preferences;
    static boolean useDarkTheme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        preferences = getSharedPreferences("Theme", MODE_PRIVATE);
        useDarkTheme = preferences.getBoolean("Dark", false);

        if(useDarkTheme) {
            setTheme(R.style.AppTheme3);

        }



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        switchTheme = (Switch) findViewById(R.id.switchTheme);

        switchTheme.setChecked(useDarkTheme);
        switchTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton view, boolean isChecked) {
                toggleTheme(isChecked);
            }


        });









    }



    private void toggleTheme(boolean darkTheme) {

        SharedPreferences.Editor editor = getSharedPreferences("Theme", MODE_PRIVATE).edit();
        editor.putBoolean("Dark", darkTheme);
        editor.apply();

        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage( getBaseContext().getPackageName() );


        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);




    }




}
