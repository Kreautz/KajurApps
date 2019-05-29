package com.riel.kajurapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.riel.kajurapps.ui.scanner.ScannerFragment;

public class ScannerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scanner_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ScannerFragment.newInstance())
                    .commitNow();
        }
    }
}
