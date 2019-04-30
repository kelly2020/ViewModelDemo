package viewmodel.wondersgroup.com.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import viewmodel.wondersgroup.com.R;
import viewmodel.wondersgroup.com.databinding.ItemBindLayoutBinding;
import viewmodel.wondersgroup.com.mode.UserBind;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class DataBindingAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<UserBind> mDatas;

    public DataBindingAdapter2(List<UserBind> mDatas) {
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        ListItemBinding binding = ListItemBinding.inflate(layoutInflater, viewGroup, false);
// or
//        ListItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false);

        ItemBindLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_bind_layout, parent, false);

        return new DataBindingHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  DataBindingHolder){
//            DataBindingHolder viewHolder = (DataBindingHolder) holder;
            //下面两种方式都可以获取bind
//            ItemBindLayoutBinding bind = DataBindingUtil.bind(viewHolder.itemView);
            ItemBindLayoutBinding bind = DataBindingUtil.getBinding(holder.itemView);

            bind.setUser(new UserBind());
            bind.executePendingBindings();
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class DataBindingHolder extends RecyclerView.ViewHolder {

        public DataBindingHolder(@NonNull View itemView) {
            super(itemView);
        }

    }
}
