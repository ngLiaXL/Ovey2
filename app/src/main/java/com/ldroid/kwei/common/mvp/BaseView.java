/**
 *
 */
package com.ldroid.kwei.common.mvp;

import android.content.Context;

public interface BaseView {

    Context context();

    void showLoading(String message);

    void dismissLoading();

    void onError(String message);
}
