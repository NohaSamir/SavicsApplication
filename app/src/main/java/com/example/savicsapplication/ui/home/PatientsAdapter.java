package com.example.savicsapplication.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.savicsapplication.R;
import com.example.savicsapplication.data.source.Patient;
import com.example.savicsapplication.databinding.ListItemBinding;

import java.util.List;

public class PatientsAdapter extends RecyclerView.Adapter<PatientsAdapter.PatientsViewHolder> {

    private List<Patient> patients;

    PatientsAdapter(List<Patient> patients) {
        this.patients = patients;
    }

    @NonNull
    @Override
    public PatientsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.list_item, parent, false);
        return new PatientsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PatientsViewHolder holder, int position) {
        holder.bind(position, patients.get(position));
    }

    @Override
    public int getItemCount() {
        return patients.size();
    }

    static class PatientsViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        PatientsViewHolder(@NonNull ListItemBinding itemView) {
            super(itemView.getRoot());
            textView = itemView.patientTextView;
        }

        void bind(int position, Patient patient) {
            String text = position + patient.toString();
            textView.setText(text);
        }
    }
}
