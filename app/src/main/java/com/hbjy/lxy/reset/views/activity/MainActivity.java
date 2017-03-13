package com.hbjy.lxy.reset.views.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hbjy.lxy.reset.base.BaseActivity;

import butterknife.ButterKnife;

@Route(path = "/lxy/main")
public class MainActivity extends ListActivity {

    private void navigation(){
        ARouter.getInstance().build("/lxy/main").navigation();
    }
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //listactivity下最好不要用setContentView();
        //setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        ArrayAdapter<BaseActivity> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,info);
        setListAdapter(adapter);

    }



    private static ActivityInfo[] info = {
            new ActivityInfo("RxBus测试",RxBusActivity.class)

    };

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        try {
            BaseActivity activity = info[position].clazz.newInstance();
            activity.navigation();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    public static class ActivityInfo{
        private String title;
        private String message;
        public Class<? extends BaseActivity> clazz;

        public ActivityInfo(String message, Class<? extends BaseActivity> clazz) {
            this.message = message;
            this.clazz = clazz;
            title = clazz.getClass().getSimpleName();
        }
    }
}
