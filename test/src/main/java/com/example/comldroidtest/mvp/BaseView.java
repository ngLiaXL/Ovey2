/**
 *
 */
package com.example.comldroidtest.mvp;

import android.content.Context;

public interface BaseView {

    Context context();

    void showLoading(String message);

    void hideLoading();

    void onError(String message);
}
