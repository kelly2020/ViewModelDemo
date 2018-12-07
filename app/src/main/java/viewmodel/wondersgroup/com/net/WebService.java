package viewmodel.wondersgroup.com.net;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import viewmodel.wondersgroup.com.mode.ApplyRecordResultModel;
import viewmodel.wondersgroup.com.mode.ConsumableRequestModel;
import viewmodel.wondersgroup.com.mode.HomeData;
import viewmodel.wondersgroup.com.mode.User;
import viewmodel.wondersgroup.com.mode.UserParam;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public interface WebService {

    @POST("qualification/getSelfInformation")
    Call<User> getUsers(@Body UserParam userParam);


    //HomeData 返回的是服务器数据格式
    @POST("qualification/getIndexPermission")
    Call<HomeData> getHome();
    /**
     * 获取个人申请记录列表
     *
     * @param requestModel
     * @return
     */
    @POST("consumbles/apply/getApplyPageList")
    Call<ApplyRecordResultModel> studyingTeacherGetPointList(@Body ConsumableRequestModel requestModel);

}
