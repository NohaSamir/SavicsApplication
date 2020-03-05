package com.example.savicsapplication.ui.home;

import android.app.Application;
import android.text.TextUtils;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.savicsapplication.Injection;
import com.example.savicsapplication.R;
import com.example.savicsapplication.data.source.Patient;
import com.example.savicsapplication.data.source.local.LocalSettings;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomeViewModel extends AndroidViewModel {
    
    public enum Gender {
        M, F, O
    }

    private MutableLiveData<List<Patient>> mPatientsListLiveData = new MutableLiveData<>();
    private MutableLiveData<Patient> mPatient = new MutableLiveData<>();

    private MutableLiveData<Boolean> isExceededLimitations = new MutableLiveData<>();
    private MutableLiveData<String> showGreetingMessage = new MutableLiveData<>();
    private List<Patient> mPatientsList = new ArrayList<>();
    private LocalSettings mLocalSettings;

    public HomeViewModel(Application application) {
        super(application);

        mLocalSettings = Injection.provideLocalSettings(application);

        mPatient.setValue(new Patient());

        if (!TextUtils.isEmpty(mLocalSettings.getUserName()))
            showGreetingMessage.setValue(application.getString(R.string.hi_again, mLocalSettings.getUserName()));
    }

    MutableLiveData<List<Patient>> getPatientsList() {
        return mPatientsListLiveData;
    }

    /**
     * If I reached the max number of patients allowed, a warning Toast should be displayed, and the patient is not added.
     */
    public void addPatient() {

        if (mPatientsList.size() < mLocalSettings.getMaxNumberOfPatients()) {
            mPatientsList.add(mPatient.getValue());
            mPatientsListLiveData.setValue(mPatientsList);
            mLocalSettings.setCurrentNumberOfPatients(mPatientsList.size());

            //Create new patient
            Patient patient = mPatient.getValue();
            if (patient != null)
                mPatient.setValue(new Patient(patient.getFullName(), patient.getAge(), patient.getEmail(), patient.getGender()));
        } else
            isExceededLimitations.setValue(true);
    }

    MutableLiveData<Boolean> getIsExceededLimitations() {
        return isExceededLimitations;
    }

    MutableLiveData<String> getShowGreetingMessage() {
        return showGreetingMessage;
    }

    public void onGenderChange(Gender gender) {
        Objects.requireNonNull(mPatient.getValue()).setGender(gender.name().charAt(0));
    }

    public Patient getPatient() {
        return mPatient.getValue();
    }


}