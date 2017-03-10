package com.hbjy.lxy.reset.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hbjy.lxy.library.rx.transformers.RxBus;
import com.hbjy.lxy.reset.R;
import com.hbjy.lxy.reset.utils.event.TextEvent;

import butterknife.ButterKnife;
import butterknife.InjectView;
import rx.functions.Action1;

/**
 * Created by Administrator on 2017/3/9 0009.
 */

public class RxBusFragment extends android.support.v4.app.Fragment {
    @InjectView(R.id.rxbus_tv_show)
    TextView tvShow;

    public RxBusFragment getInstance(){
        Bundle bundle = new Bundle();
        RxBusFragment fragment = new RxBusFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rxbus, container);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initEvent();
    }

    private void initEvent(){
        RxBus.getInstance()
                .toObservable(TextEvent.class)
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
