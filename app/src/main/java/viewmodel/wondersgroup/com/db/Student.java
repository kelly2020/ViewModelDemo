package viewmodel.wondersgroup.com.db;

import org.jetbrains.annotations.NotNull;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
@Entity
public class Student {
    @PrimaryKey
    @NotNull
    private String studentId;
    private String studentName;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
