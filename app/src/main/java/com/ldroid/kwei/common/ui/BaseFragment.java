/**
 *
 */
package com.ldroid.kwei.common.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class BaseFragment extends Fragment implements OnClickListener {


    public BaseFragment() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPresenter();
        initUI();
        initListener();
        initData();
    }

    protected abstract void initPresenter();

    protected abstract void initUI();

    protected abstract void initListener();

    protected abstract void initData();


    public View findViewById(int paramInt) {
        return getView().findViewById(paramInt);
    }


    public void startAnimActivity(Intent intent) {
        startActivity(intent);
    }

    public void startAnimActivity(Class<?> cla) {
        startActivity(new Intent(getActivity(), cla));
    }

}
