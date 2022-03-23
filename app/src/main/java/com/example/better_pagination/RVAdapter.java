package com.example.better_pagination;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    ArrayList<Employee> list = new ArrayList<>();

    public RVAdapter(Context ctx)
    {
        this.context = ctx;
    }
    public void setItems(ArrayList<Employee> emp)
    {
        list.addAll(emp);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new EmployeeVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    EmployeeVH vh = (EmployeeVH) holder;
    Employee emp = list.get(position);
    vh.txt_name.setText(emp.getName());
    vh.txt_position.setText(emp.getPosition());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EmployeeVH extends RecyclerView.ViewHolder {
        public TextView txt_name,txt_position,txt_option;
        public EmployeeVH(@NonNull View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_position = itemView.findViewById(R.id.txt_position);
            txt_option = itemView.findViewById(R.id.txt_option);
        }
    }
}