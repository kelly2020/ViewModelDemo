package viewmodel.wondersgroup.com.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import viewmodel.wondersgroup.com.R;
import viewmodel.wondersgroup.com.UserProfileViewModel;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class UserProfileFragment extends Fragment {
    @BindView(R.id.text_view_userName)
    TextView userName;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_serprofile_layout, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this,view);

        UserProfileViewModel viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);


//        viewModel.getUsers().observe(this, new Observer<UserData>() {
//            @Override
//            public void onChanged(UserData user) {
////                userName.setText(user.getDesc());
//            }
//        });


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
