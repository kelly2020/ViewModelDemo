package viewmodel.wondersgroup.com.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import viewmodel.wondersgroup.com.R;

/**
 * Lifecycle 可以感知activity/fragment的生命周期  原理也就是对生命周期进行监听
 */
public class LifecyclesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycles);
        Lifecycle lifecycle = getLifecycle();

        lifecycle.addObserver(new MyLocationListener());
        lifecycle.removeObserver(new MyLocationListener());
    }

    /**
     * MyLocationListener 类可以感知当前activity的生命周期变化并做相应的处理 而不用在activity的每个生命周期方法里面在做相应的处理
     */
    class MyLocationListener implements LifecycleObserver{
        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public void onResume() {
            Log.e("LifecycleObserver","onResume");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        public void onPause() {
            Log.e("LifecycleObserver","onPause");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onStop(){
            Log.e("LifecycleObserver","onStop");
        }

    }
}
