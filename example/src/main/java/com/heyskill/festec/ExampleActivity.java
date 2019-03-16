package com.heyskill.festec;


import android.os.Bundle;

import com.heyskill.latte_core.activities.ProxyActivity;
import com.heyskill.latte_core.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {


    @Override
    public LatteDelegate setRootDelegare() {
        return new ExampleDelegate();
    }
}
