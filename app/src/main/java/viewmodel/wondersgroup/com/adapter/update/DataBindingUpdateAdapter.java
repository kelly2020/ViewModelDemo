package viewmodel.wondersgroup.com.adapter.update;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import viewmodel.wondersgroup.com.R;
import viewmodel.wondersgroup.com.base.BaseBindingViewHolder;
import viewmodel.wondersgroup.com.databinding.ItemUpdateBindViewBinding;
import viewmodel.wondersgroup.com.mode.update.UserUpdate;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class DataBindingUpdateAdapter extends RecyclerView.Adapter {
    private List<UserUpdate> mUsers;

    public DataBindingUpdateAdapter(List<UserUpdate> users){

        mUsers = users;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       ItemUpdateBindViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_update_bind_view,parent,false);

       return new BaseBindingViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemUpdateBindViewBinding binding = DataBindingUtil.getBinding(holder.itemView);
        binding.setUser(mUsers.get(position));
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

//    class myViewHolder extends RecyclerView.ViewHolder{
//
//        public myViewHolder(@NonNull View itemView) {
//            super(itemView);
//        }
//    }
}
