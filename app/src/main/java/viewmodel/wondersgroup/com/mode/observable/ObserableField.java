package viewmodel.wondersgroup.com.mode.observable;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :使用ObserableField方式使得数据动态更新 view也可以更新
 * Version :
 */
public class ObserableField {
    public final ObservableField<String> name = new ObservableField<>();
    public final  ObservableInt age = new ObservableInt();
    public final ObservableBoolean flag = new ObservableBoolean();
}
