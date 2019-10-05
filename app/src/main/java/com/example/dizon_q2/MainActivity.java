package com.example.dizon_q2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    CheckBox subj1, subj2, subj3, subj4, subj5, subj6, subj7, subj8;
    EditText cm_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subj1 = findViewById(R.id.checkBox);
        subj2 = findViewById(R.id.checkBox2);
        subj3 = findViewById(R.id.checkBox3);
        subj4 = findViewById(R.id.checkBox4);
        subj5 = findViewById(R.id.checkBox5);
        subj6 = findViewById(R.id.checkBox6);
        subj7 = findViewById(R.id.checkBox7);
        subj8 = findViewById(R.id.checkBox8);
        cm_01 = findViewById(R.id.editText);
    }

    public void saveData (View v){


        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);



            if (subj1.isChecked()){
                writer.write((subj1.getText().toString()+',').getBytes());

            }

            if (subj2.isChecked()){
                writer.write((subj2.getText().toString()+',').getBytes());

            }

            if (subj3.isChecked()){
                writer.write((subj3.getText().toString()+',').getBytes());

            }

            if (subj4.isChecked()){
                writer.write((subj4.getText().toString()+',').getBytes());
                System.out.print(" ");
            }

            if (subj5.isChecked()){
                writer.write((subj5.getText().toString()+',').getBytes());
                System.out.print(" ");
            }

            if (subj6.isChecked()){
                writer.write((subj6.getText().toString()+',').getBytes());
                System.out.print(" ");
            }

            if (subj7.isChecked()){
                writer.write((subj7.getText().toString()+',').getBytes());
                System.out.print(" ");
            }

            if (subj8.isChecked()){
                writer.write((subj8.getText().toString()).getBytes());
                System.out.print(" ");
            }


        } catch (FileNotFoundException e) {
            Log.d("error", "Subject not found.");
        } catch (IOException e) {
            Log.d("error", "IO Error.");
        } finally {
            try {
                writer.close();

            } catch (IOException e) {
                Log.d("error", "Subject not found");
            }


        }

        String data9 = cm_01.getText().toString()+" ";

        FileOutputStream writer2 = null;
        try {
            writer2 = openFileOutput("data2.txt", MODE_PRIVATE);

            writer2.write(data9.getBytes());


        } catch (FileNotFoundException e) {
            Log.d("error", "No Comment.");
        } catch (IOException e) {
            Log.d("error", "IO Error.");
        } finally {
            try {
                writer2.close();

            } catch (IOException e) {
                Log.d("error", "No Comment");
            }


        }
        Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show();
    }

    public void NextPage(View v) {
        startActivity(new Intent(MainActivity.this, SecondPage.class));
    }
}