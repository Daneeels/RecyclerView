package com.example.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<VH>{

    ArrayList<Mahasiswa> items;

    public Adapter(ArrayList<Mahasiswa> items){
        this.items = items;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new VH(view).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.nama.setText(items.get(position).getnama());
        holder.nim.setText(items.get(position).getnim());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

class VH extends RecyclerView.ViewHolder{

    TextView nama;
    TextView nim;
    private Adapter adapter;

    public VH(@NonNull View itemView) {
        super(itemView);

        nama = itemView.findViewById(R.id.nama);
        nim = itemView.findViewById(R.id.nim);

        itemView.findViewById(R.id.delete).setOnClickListener(view -> {
            adapter.items.remove(getAdapterPosition());
            adapter.notifyItemRemoved(getAdapterPosition());
        });

    }

    public VH linkAdapter(Adapter adapter){
        this.adapter = adapter;
        return this;
    }
}
