package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Mahasiswa> listMahasiswa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataMahasiswa();

        RecyclerView recyclerView = findViewById(R.id.recycleView);
        Button button = findViewById(R.id.add);
        Button btn_add = findViewById(R.id.btn_add);
        LinearLayout ll = findViewById(R.id.form);
        EditText edt_name = findViewById(R.id.edt_name);
        EditText edt_nim = findViewById(R.id.edt_nim);

        Adapter adapter = new Adapter(listMahasiswa);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button.setOnClickListener(view -> {
            ll.setVisibility(View.VISIBLE);
        });

        btn_add.setOnClickListener(view -> {
            String nama = edt_name.getText().toString();
            String nim = edt_nim.getText().toString();

            listMahasiswa.add(new Mahasiswa(nama,nim));
            adapter.notifyItemInserted(listMahasiswa.size()-1);
            ll.setVisibility(View.GONE);
        });

    }

    private void dataMahasiswa(){

        listMahasiswa = new ArrayList<>();
        listMahasiswa.add(new Mahasiswa("Jessica","201235"));
        listMahasiswa.add(new Mahasiswa("Jubilee","201236"));
        listMahasiswa.add(new Mahasiswa("Jerome","201237"));
        listMahasiswa.add(new Mahasiswa("Jack","201238"));
    }

}