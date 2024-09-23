package com.example.bai2_chuyendoinhietdo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edtF, edtC;
    Button btnFC, btnCF, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Ánh xạ id cho các tp giao diện
        edtF=findViewById(R.id.edtF);
        edtC=findViewById(R.id.edtC);
        btnFC=findViewById(R.id.btnFC);
        btnCF=findViewById(R.id.btnCF);
        btnClear=findViewById(R.id.btnClear);
        //Xử lý sự kiện click
        xuLyClick();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void xuLyClick() {
        btnFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat dcf =new DecimalFormat("0.0");
                double f= Double.parseDouble(edtF.getText().toString());
                double c= (f-32) * 5/9;
                edtC.setText(String.valueOf(dcf.format(c)));
            }
        });
        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat dcf =new DecimalFormat("0.0");
                double c= Double.parseDouble(edtC.getText().toString());
                double f= c * 9/5 + 32;
                edtF.setText(String.valueOf(dcf.format(f)));
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtF.setText("");
                edtC.setText("");
            }
        });
    }
}