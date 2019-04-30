package viewmodel.wondersgroup.com.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;
import viewmodel.wondersgroup.com.R;
import viewmodel.wondersgroup.com.activity.ViewStubActivity;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Intent foreIntent = new Intent(this, ViewStubActivity.class);
        PendingIntent service = PendingIntent.getActivity(this, 0, foreIntent, 0);

        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("前台服务")
                .setContentText("点击可以进入到详情页")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(service)
                .build();
        //将服务转化为前台服务
        startForeground(1,notification);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);

    }
}
