package com.example.bai3_tinhbmi;

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

    //Khai báo các biến giao diện
    EditText edtTen, edtChieuCao,edtCanNang, edtBMI, edtChanDoan;
    Button btnTinhBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Ánh xạ Id
        initControl();
        //Xử lý sự kiện Click
        xuLyClick();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void initControl() {
        edtTen=findViewById(R.id.edtTen);
        edtChieuCao=findViewById(R.id.edtChieuCao);
        edtCanNang=findViewById(R.id.edtCanNang);
        edtBMI=findViewById(R.id.edtBMI);
        edtChanDoan=findViewById(R.id.edtChanDoan);
        btnTinhBMI=findViewById(R.id.btnTinhBMI);
    }
    private void xuLyClick() {
        btnTinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double h= Double.parseDouble(edtChieuCao.getText().toString());
                double w= Double.parseDouble(edtCanNang.getText().toString());

                double BMI = w/Math.pow(h,2);
                String chanDoan="";
                if(BMI<18.0){
                    chanDoan = "Bạn gầy";
                }else if(BMI<=24.9){
                    chanDoan = "Bạn bình thường";
                }else if(BMI<=29.9){
                    chanDoan = "Bạn béo phì độ I";
                }else if(BMI<=34.9){
                    chanDoan = "Bạn béo phì độ II";
                }else {
                    chanDoan = "Bạn béo phì độ III";
                }

                DecimalFormat dcf=new DecimalFormat("#.0");
                edtBMI.setText(dcf.format(BMI));
                edtChanDoan.setText(chanDoan);
            }
        });
    }
}