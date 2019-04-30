package viewmodel.wondersgroup.com.mode;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import viewmodel.wondersgroup.com.BR;

/**
 * Created by zhangwentao on 16/10/31.
 * Description : 效率比较高虽然书写麻烦
 * Version :
 */
public class UserBind extends BaseObservable {
    private String firstName;
    private String lastName;
    private String nullValue;
    private String headUrl;
    private int age;
    private int state;


    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getNullValue() {
        return nullValue;
    }

    public void setNullValue(String nullValue) {
        this.nullValue = nullValue;
    }

    //动态监听的字段
    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
