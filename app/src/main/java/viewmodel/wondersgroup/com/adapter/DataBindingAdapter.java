package viewmodel.wondersgroup.com.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;
import viewmodel.wondersgroup.com.R;
import viewmodel.wondersgroup.com.mode.UserBind;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class DataBindingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<UserBind> mData;

    public DataBindingAdapter(List<UserBind> data) {
        mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_bind_layout, parent, false);

        BindingViewHolder viewHolder = new BindingViewHolder(binding.getRoot());
        viewHolder.setBinding(binding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BindingViewHolder) {
            BindingViewHolder viewHolder = (BindingViewHolder) holder;
            UserBind user = mData.get(position);
            viewHolder.getBinding().setVariable(BR.user, user);
            viewHolder.getBinding().executePendingBindings();
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class BindingViewHolder extends RecyclerView.ViewHolder {

        ViewDataBinding binding;

        public BindingViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }
    }
}
