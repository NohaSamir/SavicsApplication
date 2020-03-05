package com.example.savicsapplication.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.savicsapplication.R;
import com.example.savicsapplication.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {

    private SettingsViewModel settingsViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingsViewModel =
                ViewModelProviders.of(this).get(SettingsViewModel.class);
        FragmentSettingsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false);

        binding.setLifecycleOwner(this);
        binding.setViewModel(settingsViewModel);

        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsViewModel.saveSettings();
                toast();
            }
        });

        return binding.getRoot();
    }

    private void toast() {
        Toast.makeText(getContext(), getString(R.string.settings_toast, settingsViewModel.getMaxNumOfPatients(), settingsViewModel.getUsername()), Toast.LENGTH_LONG).show();
    }
}
