package viewmodel.wondersgroup.com.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import viewmodel.wondersgroup.com.R;
import viewmodel.wondersgroup.com.mode.ApplyRecordResultModel;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class ConsumablesApplyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<ApplyRecordResultModel.BodyBean.ApplyRecordsBean> mDatas;
    public ConsumablesApplyAdapter(List<ApplyRecordResultModel.BodyBean.ApplyRecordsBean> datas){
        mDatas = datas;

    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ConsumableHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comsumable_lay,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ConsumableHolder){
            ConsumableHolder viewHolder = (ConsumableHolder) holder;
            String applyDesc = mDatas.get(position).getApplyDesc();
            viewHolder.consumableView.setText(applyDesc);
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class ConsumableHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_view_consumable)
        TextView consumableView;
        public ConsumableHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public void setNodifyData(){
        notifyDataSetChanged();
    }
}
