package com.example.savicsapplication.ui.settings;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.savicsapplication.Injection;
import com.example.savicsapplication.data.source.local.LocalSettings;

public class SettingsViewModel extends AndroidViewModel {

    private MutableLiveData<String> mUsername = new MutableLiveData<>();
    private MutableLiveData<Integer> mMaxNumOfPatients = new MutableLiveData<>();
    private MutableLiveData<Integer> mCurrentNumOfPatients = new MutableLiveData<>();

    private LocalSettings mLocalSettings;

    public SettingsViewModel(Application application) {
        super(application);
        mLocalSettings = Injection.provideLocalSettings(application);

        mUsername.setValue(mLocalSettings.getUserName());
        mMaxNumOfPatients.setValue(mLocalSettings.getMaxNumberOfPatients());
        mCurrentNumOfPatients.setValue(mLocalSettings.getCurrentNumberOfPatients());
    }

    public String getUsername() {
        return mUsername.getValue();
    }

    public Integer getMaxNumOfPatients() {
        return mMaxNumOfPatients.getValue();
    }

    public Integer getCurrentNumOfPatients() {
        return mCurrentNumOfPatients.getValue();
    }

    public void setUsername(String username) {
        this.mUsername.setValue(username);
    }

    public void setMaxNumOfPatients(Integer maxNumOfPatients) {
        this.mMaxNumOfPatients.setValue(maxNumOfPatients);
    }


    void saveSettings() {
        mLocalSettings.setUsername(mUsername.getValue());
        mLocalSettings.setMaxNumberOfPatients(mMaxNumOfPatients.getValue());
    }
}