package viewmodel.wondersgroup.com;

import android.app.Application;

import viewmodel.wondersgroup.com.db.AppDatabase;
import viewmodel.wondersgroup.com.net.UserRepository;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase.getInstance(this);
    }


    public AppDatabase getAppDatabase(){
        return AppDatabase.getInstance(this);
    }

    public UserRepository getRepository(){
        return UserRepository.getInstance(getAppDatabase());
    }

}
