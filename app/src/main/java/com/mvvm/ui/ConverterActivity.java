package com.mvvm.ui;

import android.databinding.BindingConversion;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.mvvm.R;
import com.mvvm.databinding.ConverterBinding;
import com.mvvm.event.UserFollowEvent;
import com.mvvm.model.User;

/**
 * 演示事件绑定的实现方案
 * Created by chiclaim on 2016/02/23
 */
public class ConverterActivity extends BaseActivity implements UserFollowEvent {

    private static final String TAG = "ConverterActivity";

    private User user;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConverterBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_converter);
        user = new User();
        binding.setUser(user);
        binding.setUserFollowEvent(this);

        Button myButton = (Button) findViewById(R.id.my_button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: 点击自定义的button");
            }
        });
        
    }

    @Override
    public void follow(View view) {
        user.setIsFollow(true);
    }

    @Override
    public void unFollow(View view) {
        user.setIsFollow(false);
    }


    //Note:最新版本的 dataBinding插件 在设置background 会自动把color转成ColorDrawable
    //所以不需要以下转换方法,如果创建了该方法,系统则会调用.
    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        Log.d("BindingConversion", "convertColorToDrawable:" + color);
        return new ColorDrawable(color);
    }

}
