/**
 *
 */
package com.ldroid.kwei.interactor;

import com.ldroid.kwei.common.mvp.BaseInteractor;
import com.ldroid.kwei.entities.out.LoginOutEntity;
import com.ldroid.kwei.module.login.LoginService;
import com.ldroid.kwei.common.net.RetrofitCreator;
import com.ldroid.kwei.entities.in.LoginInEntity;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class LoginInteractor extends BaseInteractor<LoginOutEntity, LoginInEntity> {

    @Override
    public Observable<LoginOutEntity> buildObservable(LoginInEntity params) {
        // 找个合适的方法去生成service
        // .....
        Retrofit retrofit = RetrofitCreator.INSTANCE.getInstance();
        LoginService service = retrofit.create(LoginService.class);
        return service.login(params.getName(), params.getPassword());
    }
}
