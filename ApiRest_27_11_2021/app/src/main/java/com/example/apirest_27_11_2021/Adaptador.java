package com.example.apirest_27_11_2021;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador  extends RecyclerView.Adapter<Adaptador.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserId;
        TextView tvId;
        TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserId= itemView.findViewById(R.id.tvUserId);
            tvId= itemView.findViewById(R.id.tvId);
            tvTitle= itemView.findViewById(R.id.tvTitle);
        }

        public TextView getTvUserId() {
            return this.tvUserId;
        }

        public TextView getTvId() {
            return this.tvId;
        }

        public TextView getTvTitle() {
            return this.tvTitle;
        }
    }
    List<ObjectoEjercicio> dataset;
    public Adaptador(List<ObjectoEjercicio> dataset) {
        this.dataset = dataset;
    }

    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {
        ObjectoEjercicio objectoEjercicio = dataset.get(position);
        holder.getTvTitle().setText(objectoEjercicio.getTitle());
        holder.getTvId().setText(objectoEjercicio.getId());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
