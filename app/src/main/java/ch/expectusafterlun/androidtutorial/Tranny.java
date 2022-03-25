package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.transition.TransitionManager;

public class Tranny extends Activity {

    private ViewGroup buckysLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tranny);

        buckysLayout = findViewById(R.id.buckys_layout);
        buckysLayout.setOnTouchListener(
            new RelativeLayout.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    moveButton();
                    return true;
                }
            }
        );
    }

    /*
     * Move button to bottom right corner
     * Grow in size
     */
    private void moveButton() {
        View buckysButton = findViewById(R.id.buckys_button);

        TransitionManager.beginDelayedTransition(buckysLayout);

        // Change position of the button
        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        buckysButton.setLayoutParams(positionRules);

        // Change the size of the button
        ViewGroup.LayoutParams sizeRules = buckysButton.getLayoutParams();
        sizeRules.width = 450;
        sizeRules.height = 300;
        buckysButton.setLayoutParams(sizeRules);
    }
}
