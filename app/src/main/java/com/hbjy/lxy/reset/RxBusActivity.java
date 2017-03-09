package com.hbjy.lxy.reset;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by Administrator on 2017/3/9 0009.
 */
@Route(path = "/lxy/rxbus")
public class RxBusActivity extends BaseActivity {
    @Override
    public void navigation() {
        ARouter.getInstance().build("/lxy/rxbus").navigation();
    }
}
