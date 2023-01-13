package com.example.yourbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edtWeight,edtFeet,edtInches;
        TextView txtResult;
        Button btCalculate;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtFeet = findViewById(R.id.edtFeet);
        edtInches = findViewById(R.id.edtInches);
        txtResult = findViewById(R.id.txtResult);
        btCalculate = findViewById(R.id.btnCalculate);
        llMain = findViewById(R.id.llMain);

        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int wt=Integer.parseInt(edtWeight.getText().toString());
                    int ft=Integer.parseInt(edtFeet.getText().toString());
                    int in=Integer.parseInt(edtInches.getText().toString());

                    int totalInches=ft*12+in;
                    double totalCm=totalInches*2.53;
                    double totalM=totalCm/100;

                    double bmi=wt/(totalM*totalM);

                    if(bmi>25){
                        txtResult.setText("you are OverWeight");
                      //  llMain.setBackgroundColor(getResources().getColor(R.color.clrOwt));
                        Toast.makeText(MainActivity.this, "Tip! Reduce your calories intake", Toast.LENGTH_LONG).show();
                    }
                    else if(bmi<18){
                        txtResult.setText("You are UnderWeight");
                        // llMain.setBackgroundColor(getResources().getColor(R.color.clrUwt));
                        Toast.makeText(MainActivity.this, "Tip! Increase your calories intake", Toast.LENGTH_LONG).show();
                    }
                    else{
                        txtResult.setText("You are healthy");
                      //  llMain.setBackgroundColor(getResources().getColor(R.color.clrHwt));
                        Toast.makeText(MainActivity.this, "Tip! Maintain your calories intake", Toast.LENGTH_LONG).show();
                    }
            }
        });

    }
}