package ch.expectusafterlun.androidtutorial;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Binder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService2 extends Service {

    private final IBinder binder = new MyLocalBinder();

    public MyService2() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return sdf.format(new Date());
    }

    public class MyLocalBinder extends Binder {
        MyService2 getService() {
            return MyService2.this;
        }
    }
}