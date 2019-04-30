package viewmodel.wondersgroup.com.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import viewmodel.wondersgroup.com.R;
import viewmodel.wondersgroup.com.adapter.update.DataBindingUpdate1Adapter;
import viewmodel.wondersgroup.com.base.BaseBindingAdapter;
import viewmodel.wondersgroup.com.databinding.ActivityDataBindingUpdateBinding;
import viewmodel.wondersgroup.com.mode.update.UserUpdate;

/**
 * databinding 数据绑定提高
 */

public class DataBindingUpdateActivity extends AppCompatActivity implements BaseBindingAdapter.OnItemClickListener {
    private ActivityDataBindingUpdateBinding binding;

    private DataBindingUpdate1Adapter adapter;


    private List<UserUpdate> list;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding_update);
       binding.setText(10);

       binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));

       if (list == null){
           list = new ArrayList<>();
       }
       UserUpdate userUpdate1 = new UserUpdate();
       userUpdate1.setAge(12);
       userUpdate1.setName("kelly");
       list.add(userUpdate1);
        UserUpdate userUpdate2 = new UserUpdate();
        userUpdate2.setAge(30);
        userUpdate2.setName("maka");
        list.add(userUpdate2);


//       adapter = new DataBindingUpdateAdapter(list);
        adapter = new DataBindingUpdate1Adapter(this);

//       adapter.getItems().add(userUpdate1);
//        adapter.getItems().add(userUpdate2);
//        支持数据源发生变化时，自动更新View。
        adapter.setItemClickListener(this);
        binding.recyclerview.setAdapter(adapter);

       //因为使用了ObservableArrayList 对数据变化进行监听
        adapter.getItems().addAll(list);

        binding.notifyBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
//               UserUpdate userUpdate = new UserUpdate();
//               userUpdate.setName("刘德华");
//               userUpdate.setAge(0);
//               支持数据源发生变化时，自动更新View。
//               adapter.getItems().add(userUpdate);
               adapter.getItems().addAll(list);
               Toast.makeText(DataBindingUpdateActivity.this,"点击了....." ,Toast.LENGTH_LONG).show();

           }
       });
    }

    @Override
    public void onItemClick(Object item) {

            // 根据索引进行删除我们可以删除集合里面的数据来实现删除效果
//            adapter.getItems().remove(0);
            //移除一个对象
            adapter.getItems().remove(item);
            //删除一个集合 会出现bug 不能删除 需要手动进行adpter.notifyDataSetChanged
//            adapter.getItems().removeAll(list);


        Toast.makeText(this,"删除成功",Toast.LENGTH_LONG).show();
    }
}
