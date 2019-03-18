package com.heyskill.latte_ec.launcher;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.heyskill.latte_core.app.Latte;
import com.heyskill.latte_core.delegates.LatteDelegate;
import com.heyskill.latte_core.util.timer.BaseTimerTask;
import com.heyskill.latte_core.util.timer.ITimerListener;
import com.heyskill.latte_ec.R;

import java.text.MessageFormat;
import java.util.Timer;

public class LauncherDelegate extends LatteDelegate implements ITimerListener {

    private AppCompatTextView tv_launcher_timer;
    private Timer mTimer = null;
    private int mCount = 5;

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(Bundle savedInstanceState, View rootView) {

        initViewId(rootView);
        initTimer();
        tv_launcher_timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initViewId(View rootView){
        tv_launcher_timer = rootView.findViewById(R.id.tv_launcher_timer);


    }

    private void initTimer(){
        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        mTimer.schedule(task,0,1000);
    }

    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(tv_launcher_timer != null){
                    tv_launcher_timer.setText(MessageFormat.format("跳过\n{0}s",mCount));
                    mCount--;
                    if(mCount < 0){
                        if(mTimer != null){
                            mTimer.cancel();
                            mTimer = null;
                        }
                    }
                }
            }
        });
    }
}
