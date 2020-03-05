package com.example.savicsapplication.data.source.local;

public class LocalSettings {

    private static final int DEFAULT_MAX_NUM_OF_PATIENTS = 5;
    private UserPersistence userPersistence;

    public LocalSettings(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void setUsername(String userName) {
        userPersistence.put(UserPersistence.Key.USERNAME, userName);
    }

    public String getUserName() {
        return userPersistence.getString(UserPersistence.Key.USERNAME);
    }

    public void setMaxNumberOfPatients(int number) {
        userPersistence.put(UserPersistence.Key.MAX_NUM_OF_PATIENTS, number);
    }

    public int getMaxNumberOfPatients() {
        return userPersistence.getInt(UserPersistence.Key.MAX_NUM_OF_PATIENTS, DEFAULT_MAX_NUM_OF_PATIENTS);
    }

    public void setCurrentNumberOfPatients(int number) {
        userPersistence.put(UserPersistence.Key.CURRENT_NUM_OF_PATIENTS, number);
    }

    public int getCurrentNumberOfPatients() {
        return userPersistence.getInt(UserPersistence.Key.CURRENT_NUM_OF_PATIENTS);
    }

    public void clear() {
        userPersistence.clear();
    }
}
