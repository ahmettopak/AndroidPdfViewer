package com.ahmet.androidpdfviewer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.github.barteksc.pdfviewer.PDFView;

public class MainActivity extends AppCompatActivity {
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideSystemUI(); // Navigation barı gizle
        pdfView = findViewById(R.id.pdfView);

        pdfView.fromAsset("acrob.pdf")
                .load();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideSystemUI(); // Navigation barı tekrar gizle
    }

    private void hideSystemUI() {
        // Navigation ve status barı gizler
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode  == 194){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
