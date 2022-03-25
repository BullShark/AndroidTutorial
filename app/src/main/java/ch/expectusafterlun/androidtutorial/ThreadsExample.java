package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThreadsExample extends Activity {

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
        TextView tv = findViewById(R.id.buckys_text2);
        tv.setText(R.string.nice_work);
    }
}