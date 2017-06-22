package com.example.gautam.reactnativetest;

import android.app.Application;

/**
 * Created by gautam on 16/06/17.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        /*reactNativeHost = new ReactNativeHost(this) {
            @Override
            public boolean getUseDeveloperSupport() {
                return true;
            }

            @Override
            protected List<ReactPackage> getPackages() {
                ArrayList<ReactPackage> packages = new ArrayList<>();
                packages.add(new MainReactPackage());
                return packages;
            }
        };
        reactNativeHost.getReactInstanceManager().detachRootView();*/
    }
}
