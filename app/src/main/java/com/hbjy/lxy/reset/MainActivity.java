package com.hbjy.lxy.reset;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

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
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,info);
        setListAdapter(adapter);

    }

    private static ActivityInfo[] info = {

    };

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        BaseActivity activity = info[position].activity;
        if (activity != null) {
            activity.navigation();
        }
    }

    public class ActivityInfo{
        private String title;
        private String message;
        public  BaseActivity activity;

        public ActivityInfo(String message, BaseActivity activity) {
            this.message = message;
            this.activity = activity;
            title = activity.getClass().getSimpleName();
        }
    }
}
