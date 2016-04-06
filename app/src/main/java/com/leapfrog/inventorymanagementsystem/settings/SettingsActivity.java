package com.leapfrog.inventorymanagementsystem.settings;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.leapfrog.inventorymanagementsystem.R;
import com.leapfrog.inventorymanagementsystem.dashboard.DashBoardActivity;
import com.leapfrog.inventorymanagementsystem.data.HawkUtils;
import com.leapfrog.inventorymanagementsystem.events.EventBus;
import com.leapfrog.inventorymanagementsystem.events.LanguageChangeEvent;
import com.leapfrog.inventorymanagementsystem.languagechose.LocaleHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Settings
 */
public class SettingsActivity extends AppCompatActivity {

    public enum Language {
        ENGLISH, CHINESE, JAPNEESE
    }

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.tv_language)
    TextView tvLanguage;

    private Dialog dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        EventBus.register(this);

        setToolbar();

        dialog = new Dialog(this);

        if (HawkUtils.getLanguage().equals(Language.ENGLISH)) {
            tvLanguage.setText("EN");
        } else if (HawkUtils.getLanguage().equals(Language.CHINESE)) {
            tvLanguage.setText("CN");
        } else {
            tvLanguage.setText("JP");
        }
    }

    /**
     * set up toolbar
     */
    private void setToolbar() {
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getString(R.string.txt_settings));
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
    public void setOnClicks(View view) {

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_language);
        final RadioGroup radioGroup = (RadioGroup) dialog.findViewById(R.id.rg_language);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {


                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                View radioButton = radioGroup.findViewById(radioButtonID);
                int idx = radioGroup.indexOfChild(radioButton);

                Log.i("Settings", "onCheckedChanged: " + idx);

                if (idx == 0) {
                    tvLanguage.setText("CN");
                    HawkUtils.setLanguage(Language.CHINESE);
                    LocaleHelper.setLocale(SettingsActivity.this, "zh");
                    Intent intent = new Intent(SettingsActivity.this, DashBoardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                    Log.i("Settings", "onCheckedChanged: CH");

                } else if (idx == 1) {
                    tvLanguage.setText("EN");
                    HawkUtils.setLanguage(Language.ENGLISH);
                    LocaleHelper.setLocale(SettingsActivity.this, "en");
                    Intent intent = new Intent(SettingsActivity.this, DashBoardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                    Log.i("Settings", "onCheckedChanged: EN" + idx);

                } else {
                    tvLanguage.setText("JP");
                    HawkUtils.setLanguage(Language.JAPNEESE);
                    LocaleHelper.setLocale(SettingsActivity.this, "ja");
                    Intent intent = new Intent(SettingsActivity.this, DashBoardActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                    Log.i("Settings", "onCheckedChanged: JP" + idx);

                }
                EventBus.post(new LanguageChangeEvent());
            }
        });

        dialog.show();
    }

    @Override
    protected void onDestroy() {
        dialog.dismiss();
        super.onDestroy();
    }


}
