package viewmodel.wondersgroup.com.base;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by zhangwentao on 16/10/31.
 * Description : RecyclerView.Adapter<RecyclerView.ViewHoler> 这种方式书写的话需要代码里面类实现 RecyclerView.ViewHolder
 *
 * ObservableArrayList实现了ObservableList接口。通过ObservableList，我们可以为ObservableArrayList添加一个或多个Listener。
 * 当ObservableArrayList中的数据发生变化时（添加了一个或多个元素、删除了其中某个或某些元素时），这些Listener或收到数据源发生改变的通知。
 *
 * 其实ObservableArrayList的实现并不复杂，只需要重写add、addAll、remove等等等等这些可能造成集合发生变化的方法就可以实现上述效果。
 *
 * 虽然实现不复杂，但是ObservableArrayList却可以解决我们上面遇到的修改数据源的问题。使之支持数据源发生变化时，自动更新View。
 * 我们只需要在集合发生改变时，调用adapter.notifyXXX()等方法就可以实现当数据源发生变化时，View也可以自动发生变化，而外部却无需调用adapter.notifyXXX()了
 * Version :
 */
public abstract class BaseBindingAdapter<M, B extends ViewDataBinding> extends RecyclerView.Adapter {
    protected Context mContext;
//    protected List<M> items;
    //TODO 测试使用该类能不能实现实时更新数据
    protected ObservableArrayList<M> items;
    protected ListChangedCallback itemsChangeCallback;
    protected OnItemClickListener<M> mItemClickListener;

    public BaseBindingAdapter(Context context){
        mContext = context;
        this.items = new ObservableArrayList<>();
        this.itemsChangeCallback = new ListChangedCallback();

    }

    public ObservableArrayList<M> getItems()
    {
        return items;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        B binding =  DataBindingUtil.inflate(LayoutInflater.from(mContext),this.getLayoutResId(viewType),parent,false);
        return new BaseBindingViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
         B binding = DataBindingUtil.getBinding(holder.itemView);
         this.onBindItem(binding,items.get(position));
         Log.e("onBindViewHolder","position=" + position);

         if (mItemClickListener != null){
             holder.itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     mItemClickListener.onItemClick(items.get(position),position);
                 }
             });
         }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    protected abstract @LayoutRes int getLayoutResId(int viewType);

    protected abstract void onBindItem(B binding, M item);

//item显示到屏幕的时候
    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.items.addOnListChangedCallback(itemsChangeCallback);
        Log.e("adapter","onAttachedToRecyclerView");
    }
    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.items.removeOnListChangedCallback(itemsChangeCallback);
        Log.e("adapter","onDetachedFromRecyclerView");
    }

    /**
     * 集合数据发生改变的时候调用notifyXXX()等方法就可以实现当数据源发生变化时，View也可以自动发生变化
     * @param newItems
     */
    protected void onChanged(ObservableArrayList<M> newItems){
        resetItems(newItems);
        notifyDataSetChanged();

    }

    protected void onItemRangeChanged(ObservableArrayList<M> newItems, int positionStart, int itemCount) {
        resetItems(newItems);
        notifyItemRangeChanged(positionStart,itemCount);
    }
    protected void onItemRangeInserted(ObservableArrayList<M> newItems, int positionStart, int itemCount) {
        resetItems(newItems);
        notifyItemRangeInserted(positionStart,itemCount);
        notifyItemRangeChanged(positionStart + itemCount, items.size() - positionStart - itemCount);
    }

    protected void onItemRangeMoved(ObservableArrayList<M> newItems) {
        resetItems(newItems);
        notifyDataSetChanged();
    }
    protected void onItemRangeRemoved(ObservableArrayList<M> newItems, int positionStart, int itemCount) {
        resetItems(newItems);
        notifyItemRangeRemoved(positionStart,itemCount);
        notifyItemRangeChanged(positionStart, items.size() - positionStart);
    }

    protected void resetItems(ObservableArrayList<M> newItems)
    {
        this.items = newItems;
    }

    class ListChangedCallback extends ObservableArrayList.OnListChangedCallback<ObservableArrayList<M>>{

        @Override
        public void onChanged(ObservableArrayList<M> newItems) {
            BaseBindingAdapter.this.onChanged(newItems);
        }

        @Override
        public void onItemRangeChanged(ObservableArrayList<M> newItems, int positionStart, int itemCount) {
            BaseBindingAdapter.this.onItemRangeChanged(newItems,positionStart,itemCount);
        }

        @Override
        public void onItemRangeInserted(ObservableArrayList<M> newItems, int positionStart, int itemCount) {
            BaseBindingAdapter.this.onItemRangeInserted(newItems,positionStart,itemCount);

        }

        @Override
        public void onItemRangeMoved(ObservableArrayList<M> newItems, int fromPosition, int toPosition, int itemCount) {
            BaseBindingAdapter.this.onItemRangeMoved(newItems);

        }

        @Override
        public void onItemRangeRemoved(ObservableArrayList<M> newItems, int positionStart, int itemCount) {
            BaseBindingAdapter.this.onItemRangeRemoved(newItems,positionStart,itemCount);
        }
    }

    /**
     * 添加点击事件
     * @param listener
     */
    public void setItemClickListener(OnItemClickListener<M> listener)
    {
        this.mItemClickListener = listener;
    }

    public interface OnItemClickListener<M>
    {
        void onItemClick(M item,int positon);
    }
}
