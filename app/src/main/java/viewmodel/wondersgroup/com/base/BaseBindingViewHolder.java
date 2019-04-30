package viewmodel.wondersgroup.com.base;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :adapter 中需要返回Recyclerview.ViewHolder 我们可以把它的返回写成一个基类
 * Version :
 */
public class BaseBindingViewHolder extends RecyclerView.ViewHolder {

    public BaseBindingViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
