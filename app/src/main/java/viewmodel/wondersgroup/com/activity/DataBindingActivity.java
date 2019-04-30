package viewmodel.wondersgroup.com.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingConversion;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import viewmodel.wondersgroup.com.R;
import viewmodel.wondersgroup.com.adapter.DataBindingAdapter2;
import viewmodel.wondersgroup.com.databinding.ActivityDataBindingBinding;
import viewmodel.wondersgroup.com.mode.ObserveFieldUser;
import viewmodel.wondersgroup.com.mode.UserBind;

public class DataBindingActivity extends AppCompatActivity {

    Map<String, String> hashMap;

    private DataBindingAdapter2 adapter;
    private ActivityDataBindingBinding binding;

    private UserBind userBind;
    private ObserveFieldUser observeUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);

        initAdapterData();

        List<String> list = new ArrayList<>();
        list.add("Ces =");
        binding.setIndex(0);
        binding.setList(list);

        hashMap = new HashMap<>();
        hashMap.put("key", "map 显示数据绑定");

        binding.setKey("key");

        binding.setMap(hashMap);

        binding.setFlag(false);

        userBind = new UserBind();
        userBind.setHeadUrl("http://smartcampus.eduincloud.net//phone/service/material_%20filing@3x.png");
        userBind.setState(0);
        userBind.setFirstName("张三");
        binding.setUser(userBind);

        //添加绑定事件
        binding.setHandler(new MyHandlers());

    //适合较少字段
        observeUser = new ObserveFieldUser();
        observeUser.age.set(10);
        observeUser.firstName.set("ObserveFile 添加的值");
        observeUser.lastName.set("轩轩");

        binding.setObserveUser(observeUser);

        binding.setStringUtil(new MyStringUtils());

    }

    //通过使用 databing 来为recyclerview 添加显示数据
    private void initAdapterData() {
        List<UserBind> userBinds = new ArrayList<>();

        UserBind userBind1 = new UserBind();
        userBind1.setNullValue("暂时没有数据");
        userBind1.setLastName("紫轩");
        userBind1.setFirstName(null);

        UserBind userBind2 = new UserBind();
        userBind2.setNullValue("暂时没有数据");
        userBind2.setLastName("天王");
        userBind2.setFirstName("刘");

        userBinds.add(userBind1);
        userBinds.add(userBind2);

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new DataBindingAdapter2(userBinds);

        binding.recyclerview.setAdapter(adapter);


    }

    /**
     * 绑定点击事件  下面两种方式都可以添加点击事件  @{handler.onClickAge}   @{handler::onClickFriend}
     */
    public class MyHandlers {
        public void onClickFriend(View view) {
            Toast.makeText(DataBindingActivity.this, "修改值", Toast.LENGTH_LONG).show();
            userBind.setFirstName("爱新觉罗");
        }
//
        public void onClickAge(View view) {
            Toast.makeText(DataBindingActivity.this, "修改年龄", Toast.LENGTH_LONG).show();
            observeUser.age.set(20);

        }

        public void onSaveClick(View view, UserBind user){
            Toast.makeText(DataBindingActivity.this, "user.name=" + user.getFirstName(), Toast.LENGTH_LONG).show();
        }
        public void onSaveClick(View view){
            Toast.makeText(DataBindingActivity.this, "user.name=" + "123", Toast.LENGTH_LONG).show();
        }
    }

    @BindingAdapter("android:src")
    public static void setSrc(ImageView view, String oldUrl) {

        Glide.with(view.getContext()).load(oldUrl).into(view);
    }

    @BindingAdapter("android:background")
    public static void setBackground(TextView view, int state) {

        switch (state) {
            case 0:
                view.setBackgroundResource(R.mipmap.ic_launcher);
                break;
            case 1:
                break;
        }

    }
//
// @BindingAdapter("android:background")
//    public static void setTextBackground(TextView view, int age) {
//        view.setText("age=" + age);
//    }

    public class MyStringUtils {
        public String getStringFromInt(int value) {
            return String.valueOf(value);
        }
    }

    //sh
    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }

}
