package com.heyskill.latte_core.app;

import android.app.Application;
import android.content.Context;

import java.util.HashMap;
import java.util.WeakHashMap;

public final class Latte {

    public static Configurator init(Context context){
        Configurator.getInstance()
                .getLatteConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT,context.getApplicationContext());
        return  Configurator.getInstance();
    }

    public static Configurator getConfigurator(){

        return Configurator.getInstance();
    }

//    public static HashMap<String,Object> getConfigurations(){
//        return Configurator.getInstance().getLatteConfigs();
//    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }


    public static Context getApplication(){
        return (Context) getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }


    public static Application getApplicationContext() {
        return Configurator.getInstance().getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }

}
