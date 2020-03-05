package com.example.savicsapplication;

import android.content.Context;

import com.example.savicsapplication.data.source.local.LocalSettings;
import com.example.savicsapplication.data.source.local.UserPersistence;

public class Injection {

    public static LocalSettings provideLocalSettings(Context context) {
        return new LocalSettings(provideUserPersistence(context));
    }

    private static UserPersistence provideUserPersistence(Context context) {
        return UserPersistence.getInstance(context);
    }
}
