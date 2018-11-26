package viewmodel.wondersgroup.com.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
@Database(entities = {UserData.class,HomeEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase mInstance;

    public static AppDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "user.db").build();
        }
        return mInstance;
    }


    public abstract UserEntityDao getUserDao();
    public abstract HomeEntityDao getHomeDao();

    static final Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            修改表  ALTER TABLE ...(命令允许用户重命名或添加新的字段在已有表中，不能从表中删除字段。并且只能在表的末尾添加字段)


//            database.execSQL("ALTER TABLE UserData delete COLUMN ID TEXT  ");
        }
    };
}


