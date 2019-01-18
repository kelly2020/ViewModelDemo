package viewmodel.wondersgroup.com.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import viewmodel.wondersgroup.com.R;
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
        return new DataBindingHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_data_binding, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class DataBindingHolder extends RecyclerView.ViewHolder {

        public DataBindingHolder(@NonNull View itemView) {
            super(itemView);
               DataBindingUtil.bind(itemView);
        }

        public void bind(UserBind userBind){


        }
    }
}
