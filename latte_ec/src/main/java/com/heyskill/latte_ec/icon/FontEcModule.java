package com.heyskill.latte_ec.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

public class FontEcModule implements IconFontDescriptor {
    @Override
    public String ttfFileName() {
        return "fontawesome-webfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return EcIcons.values();
    }
}
