package com.example.savicsapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.savicsapplication.R;
import com.example.savicsapplication.data.source.Patient;
import com.example.savicsapplication.databinding.FragmentHomeBinding;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private PatientsAdapter mAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);

        // Inflate view and obtain an instance of the binding class.
        final FragmentHomeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        // Specify the current activity as the lifecycle owner.
        binding.setLifecycleOwner(this);
        binding.setViewModel(homeViewModel);


        homeViewModel.getPatientsList().observe(this, new Observer<List<Patient>>() {
            @Override
            public void onChanged(List<Patient> patients) {
                if (patients != null) {
                    mAdapter = new PatientsAdapter(patients);
                    binding.recyclerview.setAdapter(mAdapter);
                }
            }
        });

        homeViewModel.getIsExceededLimitations().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isExceeded) {
                if (isExceeded) {
                    toast(getString(R.string.max_patients_reached));
                }
            }
        });

        homeViewModel.getShowGreetingMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                toast(s);
            }
        });

        return binding.getRoot();
    }

    private void toast(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();

    }

}
