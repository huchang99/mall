package com.heyskill.festec;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.heyskill.latte_core.delegates.LatteDelegate;
import com.heyskill.latte_core.net.RestClient;
import com.heyskill.latte_core.net.callBack.IError;
import com.heyskill.latte_core.net.callBack.IFailure;
import com.heyskill.latte_core.net.callBack.iSuccess;

public class ExampleDelegate extends LatteDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {
        testRestClient();
    }

    private void testRestClient(){
        RestClient.builder()
                .url("http://127.0.0.1/index")
                .loader(getContext())
                .success(new iSuccess(){
                    @Override
                    public void onSuccess(String response) {
                        Log.d("hhhh",response);
                        Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {
                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {
                    }
                })
                .build()
                .get();

    }
}
