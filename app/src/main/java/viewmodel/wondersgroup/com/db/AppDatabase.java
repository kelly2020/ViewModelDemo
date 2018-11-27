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
@Database(entities = {UserData.class,HomeEntity.class,Student.class}, version = 3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase mInstance;

    public static AppDatabase getInstance(Context context) {
        if (mInstance == null) {
            //以下两种方式都可以进行数据库版本升级  一个是 一个版本一个版本升级 一个是多版本升级
//            mInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "user.db")
//                    .addMigrations(MIGRATION_1_2,MIGRATION_2_3,MIGRATION_3_4,MIGRATION_4_5).build();

            mInstance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "user.db")
                    .addMigrations(MIGRATION_1_5).build();
        }
        return mInstance;
    }


    public abstract UserEntityDao getUserDao();
    public abstract HomeEntityDao getHomeDao();
    public abstract StudentDao getStudentDao();

    static final Migration MIGRATION_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            修改表  ALTER TABLE ...(命令允许用户重命名或添加新的字段在已有表中，不能从表中删除字段。并且只能在表的末尾添加字段)

            database.execSQL("ALTER TABLE HomeEntity add COLUMN homeId TEXT");
        }
    };

    static final Migration MIGRATION_2_3 = new Migration(2,3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE Student (studentName text, PRIMARY KEY(studentId))");
        }
    };

    static final Migration MIGRATION_3_4 = new Migration(3,4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

            //删除表
            database.execSQL("DROP TABLE Student");
        }
    };

    //当需要增加一个表的时候 先增加一个Entity 对象 和对应的表字段  然后 修改版本号 然后执行下面的sql primary key 应该写到后面
    static final Migration MIGRATION_4_5 = new Migration(4,5) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE Student (studentName text, PRIMARY KEY(studentId))");
        }
    };


    //当有很多版本的时候 我们可以进行 一次性的版本升级 然后里面的sql 就是多次版本修改所有sql
    static final Migration MIGRATION_1_5 = new Migration(1,5) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

            database.execSQL("ALTER TABLE HomeEntity add COLUMN homeId TEXT");

            database.execSQL("CREATE TABLE Student (studentName text, PRIMARY KEY(studentId))");

            //删除表
            database.execSQL("DROP TABLE Student");

            database.execSQL("CREATE TABLE Student (studentName text, PRIMARY KEY(studentId))");
        }
    };
}


