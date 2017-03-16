package com.hbjy.lxy.reset.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hbjy.lxy.rxview.helper.SupportFragment;

/**
 * Created by 李小勇 on 2017/3/16.
 */

public abstract class BaseFragment extends SupportFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view = createView(inflater,container,savedInstanceState);
        init(savedInstanceState);
        return view;

    }

    protected abstract void init(@Nullable Bundle savedInstanceState);
    protected abstract View createView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    protected void showToast(CharSequence text){
        Toast.makeText(_mActivity.getApplication(),text,Toast.LENGTH_SHORT).show();
    }

    protected void showToast(int resid){
        Toast.makeText(_mActivity.getApplication(),resid,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        _mActivity = null;
    }
}
