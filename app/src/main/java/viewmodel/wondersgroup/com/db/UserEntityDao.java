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


}
