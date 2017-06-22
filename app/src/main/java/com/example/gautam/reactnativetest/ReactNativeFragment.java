package com.example.gautam.reactnativetest;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;


public class ReactNativeFragment extends Fragment {


    private ReactRootView reactRootView;
    private ReactInstanceManager reactInstanceManager;
    private boolean isFirst;
    private boolean isSelected;
    private RelativeLayout myLayout;
    private Handler reactHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myLayout = new RelativeLayout(getActivity());
        return myLayout;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onPageSelected();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (reactInstanceManager != null) {
            reactInstanceManager.onHostResume(getActivity(), null);
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        if (reactInstanceManager != null) {
            reactInstanceManager.onHostPause(getActivity());
        }
    }

    public void onPageSelected() {
//        if (reactHandler == null) {
//            reactHandler = new Handler();
//        }
//
//        reactHandler.removeCallbacksAndMessages(null);
        isSelected = true;

        reactRootView = new ReactRootView(getActivity());
        myLayout.removeAllViews();
        myLayout.addView(reactRootView);
        reactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getActivity().getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED).build();
        reactRootView.startReactApplication(reactInstanceManager, "test");
    }

    public void onPageUnselected() {
//        isSelected = false;
//        if (reactRootView != null && reactInstanceManager != null) {
//            reactInstanceManager.detachRootView(reactRootView);
//            reactRootView.unmountReactApplication();
//            reactInstanceManager.destroy();
//            System.gc();
//        }
//        if (reactInstanceManager != null) {
//            reactInstanceManager.onHostDestroy(getActivity());
//        }
    }

    public void setIsFirst(boolean isFirst) {

        this.isFirst = isFirst;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (reactInstanceManager != null) {
            reactInstanceManager.onHostDestroy(getActivity());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

//        reactHandler.removeCallbacksAndMessages(null);
    }
}
