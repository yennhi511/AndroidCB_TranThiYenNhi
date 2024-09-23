package com.example.bai1_lab2;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class M000ActSplash extends AppCompatActivity {

    LinearLayout layout;
    ImageView animalIcon;
    TextView textWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_m000_act_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        layout = findViewById(R.id.layout);
        animalIcon = findViewById(R.id.animalIcon);
        textWelcome = findViewById(R.id.textWelcome);
        // Mảng màu sắc
        int[] colors = {
                R.color.purple_200,
                R.color.purple_500,
                R.color.purple_700,
                R.color.teal_200,
                R.color.teal_700
        };
        // Mảng icon
        int[] icons = {
                R.drawable.ico_dog,
                R.drawable.ico_hamster,
                R.drawable.ico_turtle,
                R.drawable.ico_penguin
        };

        // Tạo số ngẫu nhiên
        Random random = new Random();
        int randomColor = colors[random.nextInt(colors.length)];
        int randomIcon = icons[random.nextInt(icons.length)];

        // Áp dụng màu nền và icon
        layout.setBackgroundColor(randomColor);
        animalIcon.setImageResource(randomIcon);
    }


}