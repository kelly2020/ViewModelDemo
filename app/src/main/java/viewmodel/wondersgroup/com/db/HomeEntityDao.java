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

}
