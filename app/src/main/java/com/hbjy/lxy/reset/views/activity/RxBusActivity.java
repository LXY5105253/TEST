package com.hbjy.lxy.reset.views.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hbjy.lxy.library.rx.transformers.RxBus;
import com.hbjy.lxy.reset.R;
import com.hbjy.lxy.reset.base.BaseActivity;
import com.hbjy.lxy.reset.utils.event.TextEvent;
import com.hbjy.lxy.reset.views.fragment.RxBusFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/9 0009.
 */
@Route(path = "/lxy/rxbus")
public class RxBusActivity extends BaseActivity {
    @InjectView(R.id.rxbus_bt_test)
    Button btTest;
    @InjectView(R.id.rxbus_fragment_content)
    FrameLayout fragmentContent;

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private RxBusFragment rxBusFragment;

    @Override
    public void navigation() {
        ARouter.getInstance().build("/lxy/rxbus").navigation();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_rxbus);
        ButterKnife.inject(this);
    }

    private void init(){
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        rxBusFragment = new RxBusFragment();
        transaction.replace(R.id.rxbus_fragment_content,rxBusFragment).commit();
    }

    @OnClick(R.id.rxbus_bt_test)
    public void onClick() {
        RxBus.getInstance().postEvent(new TextEvent("Click"));
    }


}
