package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("UalxOVDHEPrhRS5J0GxwWKldQQGgdfVHjGSn38Q8")
                // if defined
                .clientKey("cMAA5aGrzbtgGNY9Ksi72M7lhMcHG4oVymQnsVcp")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
