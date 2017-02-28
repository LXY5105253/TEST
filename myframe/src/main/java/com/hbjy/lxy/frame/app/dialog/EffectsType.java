package com.hbjy.lxy.frame.app.dialog;

import com.hbjy.lxy.frame.app.dialog.effects.BaseEffects;
import com.hbjy.lxy.frame.app.dialog.effects.Fall;

/**
 * Created by Administrator on 2017/2/27 0027.
 */

public enum  EffectsType {
    Fall(Fall.class);
    private Class<? extends BaseEffects> effectsClazz;

    private EffectsType(Class<? extends BaseEffects> mclass) {
        effectsClazz = mclass;
    }

    public BaseEffects getAnimator() {
        BaseEffects bEffects=null;
        try {
            bEffects = effectsClazz.newInstance();
        } catch (ClassCastException e) {
            throw new Error("Can not init animatorClazz instance");
        } catch (InstantiationException e) {
            throw new Error("Can not init animatorClazz instance");
        } catch (IllegalAccessException e) {
            throw new Error("Can not init animatorClazz instance");
        }
        return bEffects;
    }
}
