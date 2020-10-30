package com.example.alertdialog05102020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mBtnAlertDialog;
    int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPosition = -1;

        mBtnAlertDialog = findViewById(R.id.buttonAlert);


        mBtnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Hãy chọn tên con vật");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setCancelable(false);
                // Single choice , multiple choice

                final String[] arrAnimals = {"Mèo", "Chó", "Voi", "Gà", "Khỉ", "Heo"};
                final boolean[] arrSelected = {false, false, false, false, false, false};


                builder.setMultiChoiceItems(arrAnimals, arrSelected, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String result = "";
                        for (int i = 0; i < arrSelected.length ; i++) {
                            if (arrSelected[i]){
                                result += arrAnimals[i] + " , ";
                            }
                        }
                        result = result.substring(0, result.length() - 3);
                        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNeutralButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Exit", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }
}