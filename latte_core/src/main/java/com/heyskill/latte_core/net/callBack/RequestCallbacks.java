package com.heyskill.latte_core.net.callBack;

import android.os.Handler;

import com.heyskill.latte_core.ui.LatteLoader;
import com.heyskill.latte_core.ui.LoaderStyle;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestCallbacks implements Callback<String> {

    private final IRequest REQUEST;
    private final iSuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final LoaderStyle LOADER_STYPE;

    public RequestCallbacks(IRequest request, iSuccess success, IFailure failure, IError error, LoaderStyle loaderStyle) {
        REQUEST = request;
    SUCCESS = success;
    FAILURE = failure;
    ERROR = error;
    LOADER_STYPE = loaderStyle;
}

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body());
                }
            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }
        LatteLoader.stopLoading();
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (FAILURE != null) {
            FAILURE.onFailure();
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }
        LatteLoader.stopLoading();
    }
}
