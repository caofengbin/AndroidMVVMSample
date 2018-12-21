package com.mvvm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;

import com.mvvm.BR;
import com.mvvm.R;

/**
 * 1, 用户修改用户名 , 如果多界面都使用了用户名,则需要在使用的界面同步更新.
 * 2, 界面列表使用dataBinding
 */
public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
        }

        Log.d("MainActivuty", BR.book1 + "");
    }

    /**
     * 第一个按钮的点击响应，跳转到 Simple Sample当中的Activity
     *
     * @param view 第一个按钮
     */
    public void simpleSample(View view) {
        launchActivity(DataBindSimpleActivity.class);
    }

    /**
     * 第二个按钮的点击响应，跳转到数据可变化的界面当中去
     * @param view
     */
    public void observableSample(View view) {
        UpdateUserActivity.launch(this);
    }

    public void dataBindingList(View view) {
        GitHubContributorsActivity.launch(this);
    }

    public void elSample(View view) {
        ELActivity.launch(this);
    }


    public void converter(View view) {
        Intent intent = new Intent(this, ConverterActivity.class);
        startActivity(intent);
    }

    public void customSetter(View view) {
        Intent intent = new Intent(this, CustomSetterActivity.class);
        startActivity(intent);
    }

    public void searchDebounce(View view) {
        Intent intent = new Intent(this, SearchDebounceActivity.class);
        startActivity(intent);
    }
}
