package viewmodel.wondersgroup.com.net;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import viewmodel.wondersgroup.com.db.AppDatabase;
import viewmodel.wondersgroup.com.db.HomeEntity;
import viewmodel.wondersgroup.com.db.UserData;
import viewmodel.wondersgroup.com.mode.HomeData;
import viewmodel.wondersgroup.com.mode.User;
import viewmodel.wondersgroup.com.mode.UserParam;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class UserRepository {
    private static UserRepository mInstance;

    private static WebService webService;

    private static Executor executor;
    private AppDatabase mAppDatabase;

    public UserRepository(AppDatabase appDatabase) {
        mAppDatabase = appDatabase;
    }

    public static UserRepository getInstance(AppDatabase appDatabase) {
        if (mInstance == null) {
            synchronized (UserRepository.class) {
                if (mInstance == null) {
                    mInstance = new UserRepository(appDatabase);

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(Api.BaseUrl)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();


                    webService = retrofit.create(WebService.class);
                    executor = Executors.newFixedThreadPool(3);
                }
            }
        }
        return mInstance;
    }

    public LiveData<UserData> getUser() {
        LiveData<UserData> users = mAppDatabase.getUserDao().getUsers();

        if (users.getValue() == null) {

            refreshData();
        }

        LiveData<UserData> user = mAppDatabase.getUserDao().getUsers();

        return user;

    }

    public LiveData<List<HomeEntity>> getHomeDatas() {


        requestHomeDatas();

        return mAppDatabase.getHomeDao().getHomeDatas();
    }

    private void requestHomeDatas() {
        //请求服务器数据 并保存到数据库

        final MutableLiveData<List<HomeEntity>> data = new MutableLiveData<>();
        final List<HomeEntity> homeEntities = new ArrayList<>();

        webService.getHome().enqueue(new Callback<HomeData>() {
            @Override
            public void onResponse(Call<HomeData> call, final Response<HomeData> response) {

                List<HomeData.HomeBody> bodys = response.body().getBody();
                for (HomeData.HomeBody homeBody : bodys) {
                    //通过解析服务器数据的格式 然后把对象数据存到 数据库表中对应的Java对象
                    HomeEntity homeEntity = new HomeEntity();

                    homeEntity.setId(homeBody.getId());
                    homeEntity.setPermissionName(homeBody.getPermissionName());
                    homeEntity.setServiceType(homeBody.getServiceType());


                    homeEntities.add(homeEntity);
                }


                data.setValue(homeEntities);
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        mAppDatabase.getHomeDao().add(homeEntities);
                        Log.e("excutor", "数据库插入集合");
                    }
                });
            }

            @Override
            public void onFailure(Call<HomeData> call, Throwable t) {
                Log.e("body", "t =" + t);

            }
        });

    }

    private void refreshData() {


        //在线程中执行对数据库的操作   executor 也是可以开启线程
        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                UserParam userParam = new UserParam();
                userParam.setAccountId("2c9180825f4d966d015f52918a39000a");


                final Response<User> response;
                try {
                    response = webService.getUsers(userParam).execute();


                    User.Body body = response.body().getBody();


                    UserData userData = new UserData();
                    userData.setId(body.getAccountId());
                    userData.setAccountId(body.getAccountId());
                    userData.setEmail(body.getEmail());
                    userData.setHeadIcon(body.getHeadIcon());
                    userData.setRealName(body.getRealName());


                    mAppDatabase.getUserDao().add(userData);


                    Log.e("excutor", "数据库插入对象");


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }


}
