package com.manikandansethuraj.sharedpreferencesapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_FILES = "com.manikandansethuraj.sharedpreferencesapp.preferences";
    private static final String KEY_VALUE = "KEY_VALUE";
    private EditText mEditText;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.editView);
        mSharedPreferences = getSharedPreferences(PREF_FILES, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        String mString = mSharedPreferences.getString(KEY_VALUE, "");
        mEditText.setText(mString);
    }


    @Override
    protected void onPause() {
        super.onPause();
        mEditor.putString(KEY_VALUE,mEditText.getText().toString());
        mEditor.apply();

    }
}
