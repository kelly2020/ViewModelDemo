package viewmodel.wondersgroup.com.activity;

import android.content.Intent;
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
import viewmodel.wondersgroup.com.listener.MyClick;
import viewmodel.wondersgroup.com.mode.update.UserUpdate;

/**
 * databinding 数据绑定提高
 */

public class DataBindingUpdateActivity extends AppCompatActivity implements BaseBindingAdapter.OnItemClickListener,MyClick {
    private ActivityDataBindingUpdateBinding binding;

    private DataBindingUpdate1Adapter adapter;


    private List<UserUpdate> list;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding_update);
       //初始化监听对象
       binding.setClick(this);
       initAdapter();
       setData();
       setListener();
    }

    private void setListener() {
        binding.notifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserUpdate userUpdate = new UserUpdate();
                userUpdate.setName("刘德华");
                userUpdate.setAge(0);
                // 支持数据源发生变化时，自动更新View。
                adapter.getItems().add(userUpdate);
                //adapter.getItems().addAll(list);

                //获取到集合中的元素 然后修改age 为100
                for (int i=0;i< adapter.getItems().size();i++){
                    UserUpdate user = adapter.getItems().get(i);
                    user.setAge(100);

                    adapter.getItems().set(i,user);
                }

//               UserUpdate user = adapter.getItems().get(0);
//               user.setAge(100);
                //获取集合中第一个元素的age值
//               int age = user.getAge();
//               Toast.makeText(DataBindingUpdateActivity.this,"点击了....."+age  ,Toast.LENGTH_LONG).show();
                //并把值设置给第一个元素
//               adapter.getItems().set(1,user);
            }
        });
    }

    private void initAdapter() {
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new DataBindingUpdateAdapter(list);
        adapter = new DataBindingUpdate1Adapter(this);

//      adapter.getItems().add(userUpdate1);
//      adapter.getItems().add(userUpdate2);
//      支持数据源发生变化时，自动更新View。
        adapter.setItemClickListener(this);
        binding.recyclerview.setAdapter(adapter);
    }

    private void setData() {
        binding.setText(10);


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

        //因为使用了ObservableArrayList 对数据变化进行监听
        adapter.getItems().addAll(list);
    }

    @Override
    public void onItemClick(Object item,int positon) {

        // 根据索引进行删除我们可以删除集合里面的数据来实现删除效果
        //  adapter.getItems().remove(0);
        //移除一个对象
//        adapter.getItems().remove(item);
        //删除一个集合 会出现bug 不能删除 需要手动进行adpter.notifyDataSetChanged
        //adapter.getItems().removeAll(list);



//        Toast.makeText(this,"删除成功",Toast.LENGTH_LONG).show();



//修改adapter 上面数据集合中具体点击对象的属性值 从而更新view
        UserUpdate userUpdate = (UserUpdate) item;

        if (userUpdate.isCheck()){
            userUpdate.setCheck(false);
        } else {
            userUpdate.setCheck(true);
        }
//将变化对象传递给ObservableArrayList 集合 对数据进行监听修改
        adapter.getItems().set(positon,userUpdate);
    }


    @Override
    public void onBtnClick(View view) {
        Toast.makeText(this,"点击",Toast.LENGTH_LONG).show();
        startActivity(new Intent(this,ObservableActivity.class));
    }
//

}
