package com.example.savicsapplication.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.savicsapplication.data.source.Patient;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Patient>> mPatientsListLiveData = new MutableLiveData<>();

    private List<Patient> mPatientsList = new ArrayList<>();

    public HomeViewModel() {

    }

    public MutableLiveData<List<Patient>> getPatientsList() {
        return mPatientsListLiveData;
    }

    public void addPatient(Patient patient) {
        mPatientsList.add(patient);
        mPatientsListLiveData.setValue(mPatientsList);
    }
}