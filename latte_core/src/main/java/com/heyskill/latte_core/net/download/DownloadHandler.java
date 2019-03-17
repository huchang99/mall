package com.heyskill.latte_core.net.download;

import android.os.AsyncTask;

import com.heyskill.latte_core.net.RestCreator;
import com.heyskill.latte_core.net.callBack.IError;
import com.heyskill.latte_core.net.callBack.IFailure;
import com.heyskill.latte_core.net.callBack.IRequest;
import com.heyskill.latte_core.net.callBack.iSuccess;

import java.util.WeakHashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class DownloadHandler {

    private final String URL;
    private final WeakHashMap<String, Object> PARAMS;
    private final IRequest REQUEST;
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final iSuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;


    public DownloadHandler(String url,
                           WeakHashMap<String, Object> params,
                           IRequest request,
                           String download_dir,
                           String extension,
                           String name,
                           iSuccess success,
                           IFailure failure,
                           IError error) {
        URL = url;
        PARAMS = params;
        REQUEST = request;
        DOWNLOAD_DIR = download_dir;
        EXTENSION = extension;
        NAME = name;
        SUCCESS = success;
        FAILURE = failure;
        ERROR = error;
    }

    public final void handleDownload(){
        if(REQUEST != null){
            REQUEST.onRequestStart();
        }
        RestCreator.getRestService()
                .download(URL,PARAMS)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()){
                            final ResponseBody requestBody = response.body();
                            final SaveFileTask task = new SaveFileTask(REQUEST,SUCCESS);
                            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                                    DOWNLOAD_DIR, EXTENSION, requestBody,NAME);
                            //这里要注意判断，否则文件下载不全
                            if(task.isCancelled()){
                                if(REQUEST != null){
                                    REQUEST.onRequestEnd();
                                }
                            }
                        }else {
                            if(ERROR != null){
                                ERROR.onError(response.code(),response.message());
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                       if(FAILURE != null){
                           FAILURE.onFailure();
                       }
                    }
                });
    }
}
