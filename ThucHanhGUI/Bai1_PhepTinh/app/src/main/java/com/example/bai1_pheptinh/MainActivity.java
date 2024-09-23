package com.example.bai1_pheptinh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText edtA, edtB;
    TextView txtKQ;
    Button btnTong, btnHieu, btnTich, btnThuong, btnUCLN, btnThoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Anh xa id cho các biến giao diện
        initControl();
        //Xu ly su kien click
        xuLyClick();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initControl() {
        edtA=findViewById(R.id.edtA);
        edtB=findViewById(R.id.edtB);
        txtKQ=findViewById(R.id.txtKQ);
        btnTong=findViewById(R.id.btnTong);
        btnHieu=findViewById(R.id.btnHieu);
        btnTich=findViewById(R.id.btnTich);
        btnThuong=findViewById(R.id.btnThuong);
        btnUCLN=findViewById(R.id.btnUCLN);
        btnThoat=findViewById(R.id.btnThoat);
    }

    private void xuLyClick() {

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a= Integer.parseInt(edtA.getText().toString());
                int b= Integer.parseInt(edtB.getText().toString());
                int kq=a+b;
                txtKQ.setText(String.valueOf(kq));
            }
        });
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a= Integer.parseInt(edtA.getText().toString());
                int b= Integer.parseInt(edtB.getText().toString());
                int kq=a-b;
                txtKQ.setText(String.valueOf(kq));
            }
        });
        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a= Integer.parseInt(edtA.getText().toString());
                int b= Integer.parseInt(edtB.getText().toString());
                int kq=a*b;
                txtKQ.setText(String.valueOf(kq));
            }
        });
        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat dcf = new DecimalFormat("0.00");
                double a= Double.parseDouble(edtA.getText().toString());
                double b= Double.parseDouble(edtB.getText().toString());
                double kq=a/b;
                txtKQ.setText(String.valueOf(dcf.format(kq)));
            }
        });
        btnUCLN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a= Integer.parseInt(edtA.getText().toString());
                int b= Integer.parseInt(edtB.getText().toString());
                int ucln=findUCLN(a,b);
                txtKQ.setText(String.valueOf(ucln));
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Gọi hàm finish() để thoát khỏi Activity
                finish();
            }
        });
    }

    private int findUCLN(int a, int b) {
        int min=Math.min(a,b);
        for(int i=min; i>=1;i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;//Nếu không có ước chung nào lớn hơn
    }
}