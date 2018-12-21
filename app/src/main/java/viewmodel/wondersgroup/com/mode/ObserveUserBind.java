package viewmodel.wondersgroup.com.mode;

import androidx.databinding.BaseObservable;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class ObserveUserBind extends BaseObservable {
    private String firstName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
//        notifyPropertyChanged(BR.firstName);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
