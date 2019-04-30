package viewmodel.wondersgroup.com.mode.observable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import viewmodel.wondersgroup.com.BR;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :采用普通的继承方式 使得数据能够实时更新view 也可以更新
 * Version :
 */
public class UserModel extends BaseObservable {
    private String name;
    private int age;
    private boolean flag;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
        notifyPropertyChanged(BR.name);
    }
    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
    @Bindable
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
        notifyPropertyChanged(BR.flag);
    }
}
