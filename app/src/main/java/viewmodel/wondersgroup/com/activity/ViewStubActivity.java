package viewmodel.wondersgroup.com.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import viewmodel.wondersgroup.com.R;
import viewmodel.wondersgroup.com.databinding.ActivityViewStubBinding;
import viewmodel.wondersgroup.com.listener.OkListener;
import viewmodel.wondersgroup.com.mode.UserBind;

public class ViewStubActivity extends AppCompatActivity implements OkListener {
    ActivityViewStubBinding binding;
    UserBind userBind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_stub);

        binding.setClick(this);

        userBind = new UserBind();
        userBind.setFirstName("张三");

        binding.setUser(userBind);

//        binding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
//            @Override
//            public void onInflate(ViewStub viewStub, View view) {
//                ViewStubBinding binding = DataBindingUtil.bind(view);
//
//                UserBind userBind = new UserBind();
//                userBind.setFirstName("viewStub");
//                binding.setUser(userBind);
//            }
//        });
    }

    @Override
    public void onClickListener(View view) {
        Toast.makeText(this,"点击事件",Toast.LENGTH_LONG).show();
    }

    @Override
    public void changeAgeClick(View view) {
        userBind.setFirstName("李四");
    }

}
