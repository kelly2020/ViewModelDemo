package viewmodel.wondersgroup.com;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import viewmodel.wondersgroup.com.db.HomeEntity;
import viewmodel.wondersgroup.com.db.UserData;
import viewmodel.wondersgroup.com.net.UserRepository;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class UserProfileViewModel extends AndroidViewModel {
    private UserRepository repository;

    public UserProfileViewModel(@NonNull Application application) {
        super(application);
        repository = ((AppApplication) application).getRepository();

    }

    public LiveData<UserData> getUsers() {

        return repository.getUser();
    }

    public LiveData<List<HomeEntity>> getHomeDatas() {

        return repository.getHomeDatas();
    }


}
