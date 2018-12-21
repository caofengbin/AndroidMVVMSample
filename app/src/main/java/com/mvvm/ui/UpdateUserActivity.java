package com.mvvm.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayMap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mvvm.R;
import com.mvvm.databinding.ActivityUpdateUserBinding;
import com.mvvm.model.User;
import com.mvvm.model.UserField;

/**
 * 第二个demo演示界面，数据可变的场景下，如果实现MVVM
 * Created by chiclaim on 2016/02/18
 */
public class UpdateUserActivity extends BaseActivity {
    private ActivityUpdateUserBinding binding;

    // 当前的Activity中使用了三种动态修改数据的方式，具体可以参照文章中的说明进行整理，
    // 推荐使用第二种方式，UserField中的实现方案。
    private User user;
    private UserField userField = new UserField();
    private ObservableArrayMap<String, Object> map = new ObservableArrayMap();

    public static void launch(Context context) {
        Intent intent = new Intent(context, UpdateUserActivity.class);
        context.startActivity(intent);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_update_user);
        user = new User("Chiclaim", "119");
        userField.realName.set("Chiclaim");
        userField.mobile.set("119");
        map.put("realName", "Chiclaim");
        map.put("mobile", "119");

        binding.setUser(user);
        binding.setFields(userField);
        binding.setCollection(map);
    }

    //如果(某个)字段发生变化.
    //1,通过User继承BaseObservable实现
    //2,通过ObservableField方式实现
    //3,通过Observable Collections的方式 如:ObservableArrayMap
    //4,当然可以通过binding.setUser(user) [相当于所有的View重新设置一遍]
    public void updateNameByPOJP(View view) {
        // 点击按钮完成之后，手动的修改user中的数据，然后通过 ActivityUpdateUserBinding set变量数据即可。
        if ("Johnny".equals(user.getRealName())) {
            user.setRealName("Chiclaim");
            user.setMobile("110");
        } else {
            user.setRealName("Johnny");
            user.setMobile("119");
        }

        //当然可以通过binding.setUser(user)
        binding.setUser(user);
    }

    public void updateNameByField(View view) {
        if ("Johnny".equals(userField.realName.get())) {
            userField.realName.set("Chiclaim");
            userField.mobile.set("110");
        } else {
            userField.realName.set("Johnny");
            userField.mobile.set("119");
        }
    }

    public void updateNameByCollection(View view) {
        if ("Johnny".equals(map.get("realName"))) {
            map.put("realName", "Chiclaim");
            map.put("mobile", "110");
        } else {
            map.put("realName", "Johnny");
            map.put("mobile", "119");
        }
    }
}
