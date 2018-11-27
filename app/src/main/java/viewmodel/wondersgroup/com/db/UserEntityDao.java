package viewmodel.wondersgroup.com.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
@Dao
public interface UserEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(UserData user);

    @Query("select * from UserData")
    LiveData<UserData> getUsers();

    //查询是否插入用户数据 如果插入就直接显示数据库数据 否则 请求网络
    @Query("select * from UserData")
    UserData getUserData();
}
