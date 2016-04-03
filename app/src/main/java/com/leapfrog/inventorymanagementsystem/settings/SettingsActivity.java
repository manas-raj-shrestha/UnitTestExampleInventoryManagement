package com.leapfrog.inventorymanagementsystem.settings;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.data.HawkUtils;
import com.orhanobut.hawk.Hawk;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Settings
 */
public class SettingsActivity extends AppCompatActivity {

    public enum Language{
        ENGLISH,CHINESE
    }

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        Log.e("asdasd", String.valueOf(HawkUtils.getLanguage()));

        setToolbar();
    }

    /**
     * set up toolbar
     */
    private void setToolbar() {
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Settings");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.rl_language})
    public void setOnClicks(View view){
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_language);
        RadioGroup radioGroup = (RadioGroup) dialog.findViewById(R.id.rg_language);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Log.e("check", String.valueOf(i));

                switch (i){
                    case 1:
                        HawkUtils.setLanguage(Language.CHINESE);
                        break;
                    case 2:
                        HawkUtils.setLanguage(Language.ENGLISH);
                        break;
                }
            }
        });

        dialog.show();
    }
}
