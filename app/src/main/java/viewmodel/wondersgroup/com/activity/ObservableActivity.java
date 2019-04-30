package viewmodel.wondersgroup.com.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import viewmodel.wondersgroup.com.R;
import viewmodel.wondersgroup.com.databinding.ActivityObservableBinding;
import viewmodel.wondersgroup.com.mode.observable.ObserableField;
import viewmodel.wondersgroup.com.mode.observable.Student;
import viewmodel.wondersgroup.com.mode.observable.UserModel;

/**
 * 三种数据改变方式测试
 */
public class ObservableActivity extends AppCompatActivity {
    ActivityObservableBinding binding;
    ObserableField obserableField;
    UserModel userModel;

    ObservableArrayList<Student> students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_observable);

        obserableField = new ObserableField();
        userModel = new UserModel();
        students = new ObservableArrayList<>();

        binding.setField(obserableField);
        binding.setUser(userModel);

        setData();
        setListener();
    }

    private void setListener() {
        binding.btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (obserableField.flag.get()){
                    obserableField.flag.set(false);
                } else {
                    obserableField.flag.set(true);
                }

            }
        });

        binding.btnModifyCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userModel.isFlag()){
                    userModel.setFlag(false);
                } else {
                    userModel.setFlag(true);
                }
            }
        });
    }

    private void setData() {


        obserableField.name.set("kelly");
        obserableField.age.set(20);
        obserableField.flag.set(false);
        binding.setField(obserableField);


        userModel.setName("joee");
        userModel.setAge(40);
        userModel.setFlag(true);

        //TODO view 上面设置显示数据问题
        Student student = new Student();
        student.setAge(1000);
        student.setName("obser");
        student.setFlag(true);

        students.add(0,student);
    }
}
