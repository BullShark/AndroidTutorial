package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

public class ThreadsExample extends Activity {

    /*
     * Interface updates should not be done from a different thread
     * Then use a handler to solve that
     */
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            TextView tv = findViewById(R.id.buckys_text2);
            tv.setText(R.string.nice_work);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.threads_example);
    }

    /*
     * Wait 10 seconds
     * Simulating some kind of calculation or background process
     */
    public void clickBuckysButton(View view) {

        Runnable run = new Runnable() {
            @Override
            public void run() {
                long futureTime = System.currentTimeMillis() + 10000;
                while(System.currentTimeMillis() < futureTime) {
                    synchronized (this) {
                        try {
                            wait(futureTime - System.currentTimeMillis());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                handler.sendEmptyMessage(0);
            }
        };
        Thread thread = new Thread(run);
        thread.start();
    }
}