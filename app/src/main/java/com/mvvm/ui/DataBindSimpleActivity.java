package com.mvvm.ui;

import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;

import com.mvvm.R;
import com.mvvm.databinding.ActivitySimpleBinding;
import com.mvvm.model.User;

/**
 * 第一个示例界面，最简单的一个demo
 */
public class DataBindSimpleActivity extends BaseActivity {

    private ActivitySimpleBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_simple);
        fetchData();

    }

    /**
     * 模拟获取数据
     */
    private void fetchData() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                showLoadingDialog();
            }

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                hideLoadingDialog();
                User user = new User("Chiclaim", "13512341234");
                binding.setUser(user);
                //binding.setVariable(com.mvvm.BR.user, user);
                fetchData2();
            }
        }.execute();
    }

    /**
     * 模拟获取数据
     */
    private void fetchData2() {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                showLoadingDialog();
            }

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                hideLoadingDialog();
                User user = new User("第二次返回的名称", "13512341234");
                binding.setUser(user);
                //binding.setVariable(com.mvvm.BR.user, user);
            }
        }.execute();
    }
}

