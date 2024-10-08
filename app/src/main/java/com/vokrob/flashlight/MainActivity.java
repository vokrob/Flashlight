package com.vokrob.flashlight;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private FlashClass flashClass;
    private MaterialButton flashButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void init() {
        flashButton = findViewById(R.id.b1);
        flashClass = new FlashClass(this);
    }

    public void onClickFlash(View view) {
        if (flashClass.isFlash_status()) {
            flashClass.flashOff();
            flashButton.setText("On");
            flashButton.setStrokeColor(ColorStateList.valueOf(Color.parseColor("#57E007")));
        } else {
            flashClass.flashOn();
            flashButton.setText("Off");
            flashButton.setStrokeColor(ColorStateList.valueOf(Color.RED));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (flashClass.isFlash_status()) {
            flashClass.flashOff();
        }
    }
}



























