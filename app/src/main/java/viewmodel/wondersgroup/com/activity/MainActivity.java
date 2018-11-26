package viewmodel.wondersgroup.com.activity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import viewmodel.wondersgroup.com.R;
import viewmodel.wondersgroup.com.UserProfileViewModel;
import viewmodel.wondersgroup.com.db.HomeEntity;
import viewmodel.wondersgroup.com.db.UserData;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.textview_show)
    TextView showView;
    @BindView(R.id.home_show)
    TextView homeView;

    private StringBuffer stringBuffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        stringBuffer = new StringBuffer();
        final UserProfileViewModel viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);

        viewModel.getUsers().observe(this, new Observer<UserData>() {
            @Override
            public void onChanged(UserData user) {
                showView.setText(user.getRealName());
            }
        });


        viewModel.getHomeDatas().observe(this, new Observer<List<HomeEntity>>() {
            @Override
            public void onChanged(List<HomeEntity> homeData) {

                for (HomeEntity homeEntity : homeData) {

                    stringBuffer.append(homeEntity.getPermissionName()).toString();

                    homeView.setText(stringBuffer);
                }
            }
        });


//        UserProfileFragment fragment = new UserProfileFragment();
//
//        FragmentManager supportFragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
//
//        fragmentTransaction.add(R.id.frameLayout, fragment);
//
//        fragmentTransaction.commit();


    }
}
