package viewmodel.wondersgroup.com.util;

import android.content.Context;

/**
 * Created by zhangwentao on 16/10/31.
 * Description :
 * Version :
 */
public class ScreenUtils {

    public static float dp2px(final Context context, final float dpValue) {
        return dpValue * context.getResources().getDisplayMetrics().density;
    }
}
