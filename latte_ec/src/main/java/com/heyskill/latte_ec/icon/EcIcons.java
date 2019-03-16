package com.heyskill.latte_ec.icon;

import com.joanzapata.iconify.Icon;

public enum  EcIcons implements Icon {
    icon_test('\ue6da'),
    icon_guanli('\ueb62'),
    icon_dingyi('\ueb63');

    private char character;

    EcIcons(char character){
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_','-');
    }

    @Override
    public char character() {
        return character;
    }
}
