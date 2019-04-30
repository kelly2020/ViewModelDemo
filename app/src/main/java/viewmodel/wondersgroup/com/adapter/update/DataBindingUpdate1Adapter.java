package viewmodel.wondersgroup.com.adapter.update;

import android.content.Context;

import viewmodel.wondersgroup.com.R;
import viewmodel.wondersgroup.com.base.BaseBindingAdapter;
import viewmodel.wondersgroup.com.databinding.ItemUpdateBindViewBinding;
import viewmodel.wondersgroup.com.mode.update.UserUpdate;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class DataBindingUpdate1Adapter extends BaseBindingAdapter<UserUpdate,ItemUpdateBindViewBinding> {
    public DataBindingUpdate1Adapter(Context context) {
        super(context);

    }

    @Override
    protected int getLayoutResId(int viewType) {
        return R.layout.item_update_bind_view;
    }

    @Override
    protected void onBindItem(ItemUpdateBindViewBinding binding, UserUpdate item) {
        binding.setUser(item);
        binding.executePendingBindings();
    }
}
