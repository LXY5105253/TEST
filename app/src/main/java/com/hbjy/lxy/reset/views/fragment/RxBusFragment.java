package com.hbjy.lxy.reset.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hbjy.lxy.library.rx.RxBus;
import com.hbjy.lxy.library.rx.transformers.SchedulersCompat;
import com.hbjy.lxy.reset.R;
import com.hbjy.lxy.reset.base.BaseFragment;
import com.hbjy.lxy.reset.utils.event.TextEvent;
import com.trello.rxlifecycle.android.FragmentEvent;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.functions.Action1;

/**
 * Created by Administrator on 2017/3/9 0009.
 */

public class RxBusFragment extends BaseFragment {
    @InjectView(R.id.rxbus_tv_show)
    TextView tvShow;

    public static RxBusFragment getInstance(){
        Bundle bundle = new Bundle();
        RxBusFragment fragment = new RxBusFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void init(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState == null){
            initEvent();
        }

    }

    @Override
    protected View createView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rxbus, container,false);
        ButterKnife.inject(this, view);
        return view;
    }

    private void initEvent(){
        RxBus.getInstance()
                .toObservable(TextEvent.class)
                .compose(this.<TextEvent>bindUntilEvent(FragmentEvent.PAUSE))
                .compose(SchedulersCompat.<TextEvent>observeOnMainThread())
                .subscribe(new Action1<TextEvent>() {
                    @Override
                    public void call(TextEvent textEvent) {
                        tvShow.setText(textEvent.getText());
                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
