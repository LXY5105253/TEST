package com.hbjy.lxy.reset.utils.event;

import com.hbjy.lxy.library.rx.event.BaseEventBus;

/**
 * Created by Administrator on 2017/3/9 0009.
 */

public class TextEvent extends BaseEventBus {
    private String text;

    public TextEvent(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
