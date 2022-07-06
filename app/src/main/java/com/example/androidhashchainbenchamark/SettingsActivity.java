package com.example.androidhashchainbenchamark;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import com.example.androidhashchainbenchamark.Experiment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        final Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

                button.setText("Running...");

                String path;
                File sdCardFile;

//                try {
//                    path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/benchmarkOutputMobile.csv";
//                    sdCardFile = new File(path);
//                    if (!sdCardFile.exists()) sdCardFile.mkdirs();
//                } catch(Exception e) {
//                    path = Environment.getExternalStorageDirectory() + "/benchmarkOutputMobile.csv";
//                    sdCardFile = new File(path);
//                    if (!sdCardFile.exists()) sdCardFile.mkdirs();
//                }
                path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + "/benchmarkOutputMobile.csv";
                sdCardFile = new File(path);

                FileWriter fWriter;
                Log.d("TAG", sdCardFile.getPath()); //<-- check the log to make sure the path is correct.
                try {
                    Experiment experiment = new Experiment(sdCardFile);
                } catch (Exception e) {
                    button.setText("Unable to write file:\n" + e.getMessage());
                    return;
                }
                button.setText("Saved to " + sdCardFile.getPath());
            }
        });

    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }
}