package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class InputItem extends AppCompatActivity {

    EditText editTextNama;
    EditText editTextNim;
    Button add2;

    public void initComponents(){
        editTextNama = findViewById(R.id.editTextNama);
        editTextNim = findViewById(R.id.editTextNim);
        add2 = findViewById(R.id.add2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_item);

        initComponents();
        add2.setOnClickListener(view -> {
            Intent intent = new Intent(InputItem.this, MainActivity.class);
            intent.putExtra("editTextNama",editTextNama.getText().toString());
            intent.putExtra("editTextNim",editTextNim.getText().toString());
            startActivity(intent);
        });
    }
}