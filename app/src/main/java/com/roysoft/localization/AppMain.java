package com.roysoft.localization;

import android.app.Application;
import android.content.Context;

public class AppMain extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));
    }
}
