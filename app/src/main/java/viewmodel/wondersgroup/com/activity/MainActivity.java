package viewmodel.wondersgroup.com.activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.malinskiy.superrecyclerview.OnMoreListener;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import viewmodel.wondersgroup.com.R;
import viewmodel.wondersgroup.com.UserProfileViewModel;
import viewmodel.wondersgroup.com.adapter.ConsumablesApplyAdapter;
import viewmodel.wondersgroup.com.mode.ApplyRecordResultModel;
import viewmodel.wondersgroup.com.netwrong.NetView;
import viewmodel.wondersgroup.com.view.RefreshRecyclerView;

public class MainActivity extends AppCompatActivity implements NetView {
    @BindView(R.id.textview_show)
    TextView showView;
    @BindView(R.id.home_show)
    TextView homeView;
    @BindView(R.id.text_view_total_count)
    TextView totalCountView;
    @BindView(R.id.text_view_pending_deal)
    TextView pendingDealView;
    @BindView(R.id.imageType)
    ImageView imageType;

    @BindView(R.id.recyclerview)
    RefreshRecyclerView recyclerView;

    private StringBuffer stringBuffer;

    private ConsumablesApplyAdapter adapter;
    private List<ApplyRecordResultModel.BodyBean.ApplyRecordsBean> mDatas;
    private UserProfileViewModel viewModel;
    private int startPage = 1;
    private int count;

    private ApplyRecordResultModel.BodyBean bodyBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        stringBuffer = new StringBuffer();
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);

        initView();

        initData();

        requestData();

//        viewModel.getUsers().observe(this, new Observer<UserData>() {
//            @Override
//            public void onChanged(UserData user) {
//                showView.setText(user.getRealName());
//            }
//        });


//        viewModel.getHomeDatas().observe(this, new Observer<List<HomeEntity>>() {
//            @Override
//            public void onChanged(List<HomeEntity> homeData) {
//
//                for (HomeEntity homeEntity : homeData) {
//
//                    stringBuffer.append(homeEntity.getPermissionName()).toString();
//
//                    homeView.setText(stringBuffer);
//                }
//            }
//        });
//
//        UserProfileFragment fragment = new UserProfileFragment();
//
//        FragmentManager supportFragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
//
//        fragmentTransaction.add(R.id.frameLayout, fragment);
//
//        fragmentTransaction.commit();


    }

    private void initData() {

        if (mDatas == null) {
            mDatas = new ArrayList<>();
        }

        adapter = new ConsumablesApplyAdapter(mDatas);
        recyclerView.setAdapter(adapter);

        recyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView.hideMoreProgress();
                startPage = 1;
                requestData();
            }
        });


        recyclerView.setOnMoreListener(new OnMoreListener() {
            @Override
            public void onMoreAsked(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {
                if (bodyBean != null) {
                    if (bodyBean.getApplyTotal() > adapter.getItemCount()) {
                        startPage++;
                        requestData();
                    } else {
                        recyclerView.setRefreshing(false);
                        recyclerView.hideMoreProgress();
                    }
                } else {
                    recyclerView.setRefreshing(false);
                    recyclerView.hideMoreProgress();
                }

            }
        });
    }

    private void requestData() {
        viewModel.getUsersFromNet(this, startPage).observe(this, new Observer<ApplyRecordResultModel.BodyBean>() {
            @Override
            public void onChanged(ApplyRecordResultModel.BodyBean user) {
                bodyBean = user;
                totalCountView.setText(String.format(getResources().getString(R.string.resource_total_count), user.getApplyTotal()));

                if (startPage == 1) {
                    count = user.getAwaitNum();
                } else {
                    count += user.getAwaitNum();
                }
                pendingDealView.setText(String.format(getResources().getString(R.string.resource_pending_deal), count));
                List<ApplyRecordResultModel.BodyBean.ApplyRecordsBean> applyRecords = user.getApplyRecords();


                if (mDatas != null) {

                    if (startPage == 1) {
                        mDatas.clear();
                        mDatas.addAll(applyRecords);
                    } else {
                        mDatas.addAll(applyRecords);
                    }

                    adapter.setNodifyData();
                }
            }
        });
    }

    private void initView() {
        recyclerView.setRefreshingColorResources(android.R.color.holo_orange_light, android.R.color.holo_blue_light,
                android.R.color.holo_green_light, android.R.color.holo_blue_dark);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        showView.setText(getResources().getInteger(R.integer.min_speed) + "");
        int[] intArray = getResources().getIntArray(R.array.bits);


        TypedArray typedArray = getResources().obtainTypedArray(R.array.colors);

        Drawable drawable = typedArray.getDrawable(0);

        int color = typedArray.getColor(0, 0);

        showView.setTextColor(color);
        imageType.setBackground(drawable);

    }


    @Override
    public void error(String des) {
        Toast.makeText(MainActivity.this, des, Toast.LENGTH_LONG).show();

    }

    @Override
    public void loading() {

    }

    @Override
    public void resetRefresh() {
        recyclerView.setRefreshing(false);
        recyclerView.hideMoreProgress();
    }

    @Override
    public void success() {

    }

    @OnClick({R.id.buttonType, R.id.imageType, R.id.button_animation,R.id.button_bind,R.id.view_stub_bind})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonType:
                Intent intent = new Intent(this, DrawableActivity.class);
                startActivity(intent);
                Toast.makeText(this, getResources().getString(R.string.button_click), Toast.LENGTH_LONG).show();
                break;
            case R.id.imageType:
                Toast.makeText(this, getResources().getString(R.string.image_click), Toast.LENGTH_LONG).show();
                break;
            case R.id.button_animation:
                Intent animationIntent = new Intent(this, AnimationActivity.class);
                startActivity(animationIntent);
                Toast.makeText(this, getResources().getString(R.string.image_click), Toast.LENGTH_LONG).show();
                break;
            case R.id.button_bind:
                Intent bindIntent = new Intent(this, DataBindingActivity.class);
                startActivity(bindIntent);
                break;
            case R.id.view_stub_bind:
                Intent viewStubIntent = new Intent(this, ViewStubActivity.class);
                startActivity(viewStubIntent);
                break;
        }
    }
}
