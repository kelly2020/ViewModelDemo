package viewmodel.wondersgroup.com.activity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import viewmodel.wondersgroup.com.R;
import viewmodel.wondersgroup.com.adapter.DataBindingAdapter;
import viewmodel.wondersgroup.com.databinding.ActivityDataBindingBinding;
import viewmodel.wondersgroup.com.mode.UserBind;
//import androidx.databinding.DataBindingUtil;

public class DataBindingActivity extends AppCompatActivity {

    Map<String, String> hashMap;

    private DataBindingAdapter adapter;
    private ActivityDataBindingBinding binding;

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
        adapter = new DataBindingAdapter(userBinds);

        binding.recyclerview.setAdapter(adapter);


    }
}
