package viewmodel.wondersgroup.com.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import viewmodel.wondersgroup.com.R;
import viewmodel.wondersgroup.com.databinding.ActivityZhuJieBinding;
import viewmodel.wondersgroup.com.mode.UserBind;

/**
 * BindingAdapter 注解谁用
 */

public class ZhuJieActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityZhuJieBinding binding =  DataBindingUtil.setContentView(this,R.layout.activity_zhu_jie);

        UserBind userBind = new UserBind();
        userBind.setHeadUrl("http://smartcampus.eduincloud.net//phone/service/material_%20filing@3x.png");
        binding.setUser(userBind);

        binding.setPadding(100);

//        Glide.with(this).load("https://m.360buyimg.com/mobilecms/jfs/t15145/137/2502885754/3106/de5e0b14/5aa10cd2N46f18ce6.png").into(binding.imageview);
    }

    /**
     * 先自定义属性 然后xml 里面可以直接使用定义的属性
     * @param imageView
     * @param url
     * @param placeHolder
     * @param error
     */
    @BindingAdapter(value = {"android:imageUrl", "android:placeHolder", "android:error"},requireAll = false)
    public static void setImageLoad(ImageView imageView,String url,Drawable placeHolder, Drawable error){
        Glide.with(imageView.getContext()).load(url).placeholder(placeHolder).error(error).into(imageView);


        Log.e("url","url=" + url);
    }
    @BindingAdapter("android:src")
    public static void setBackground(ImageView imageView, String url){

        Glide.with(imageView.getContext()).load(url).into(imageView);
        Log.e("url","url=" + url);
    }
    @BindingAdapter("android:padd")
    public static void setValue(TextView view, int padding){
        view.setPadding(padding,10,10,10);

    }


}
