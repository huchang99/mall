package com.heyskill.latte_core.net;

import android.content.Context;

import com.heyskill.latte_core.net.callBack.IError;
import com.heyskill.latte_core.net.callBack.IFailure;
import com.heyskill.latte_core.net.callBack.IRequest;
import com.heyskill.latte_core.net.callBack.iSuccess;
import com.heyskill.latte_core.ui.LoaderStyle;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class RestClientBuilder {
    private  String mUrl;
    private  static final  Map<String,Object> PARAMS = RestCreator.getParams();
    private  IRequest mRequest;
    private  iSuccess mSuccess;
    private  IFailure mFailture;
    private  IError mError;
    private  RequestBody mBody;
    private  Context mContext;
    private  LoaderStyle mLoaderstyle;
    private  File mFile;
    private  String mDownloadDir;
    private  String mExtension;
    private  String mName;

    RestClientBuilder(){
    }

    public final RestClientBuilder url(String url){
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String,Object> params){
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key,Object value){
       PARAMS.put(key, value);
       return this;
    }

    public final RestClientBuilder file(File file){
        this.mFile = file;
        return this;
    }

    public final RestClientBuilder file(String file){
        this.mFile = new File(file);
        return this;
    }

    public final RestClientBuilder name(String name){
        this.mName = name;
        return this;
    }

    public final RestClientBuilder dir(String dir){
        this.mDownloadDir = dir;
        return this;
    }
    public final RestClientBuilder extension(String extension){
        this.mExtension = extension;
        return this;
    }

    public final RestClientBuilder raw(String raw){
       this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),raw);
       return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest){
        this.mRequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(iSuccess miSuccess){
        this.mSuccess = miSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure){
        this.mFailture = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError){
        this.mError = iError;
        return this;
    }

    public final RestClientBuilder loader(Context context,LoaderStyle style){
        this.mContext = context;
        this.mLoaderstyle = style;
        return this;
    }

    public final RestClientBuilder loader(Context context){
        this.mContext = context;
        this.mLoaderstyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }


    public final RestClient build(){
        return  new RestClient(mUrl,PARAMS,mRequest,mSuccess,mFailture,mError,mBody,mContext,mLoaderstyle,mFile,mDownloadDir,mExtension,mName);
    }


}

