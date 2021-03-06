package viewmodel.wondersgroup.com.db;

import java.util.List;

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
public interface HomeEntityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(List<HomeEntity> user);

    @Query("select * from HomeEntity")
    LiveData<List<HomeEntity>> getHomeDatas();

    //查询数据库中是否已经存入数据 用来判断是否要请求网络
    @Query("select * from HomeEntity")
    List<HomeEntity> getDatas();

}
