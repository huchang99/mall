package com.heyskill.festec;


import android.os.Bundle;

import com.heyskill.latte_core.activities.ProxyActivity;
import com.heyskill.latte_core.delegates.LatteDelegate;
import com.heyskill.latte_ec.launcher.LauncherDelegate;
import com.heyskill.latte_ec.launcher.LauncherScrollDelegate;

public class ExampleActivity extends ProxyActivity {


    @Override
    public LatteDelegate setRootDelegare() {
        //return new ExampleDelegate();
        return new LauncherScrollDelegate();
    }

}
