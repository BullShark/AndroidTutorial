package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ShareBear extends Activity {

    private EditText usernameInput, passwordInput;
    private TextView buckysText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_bear);

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        buckysText = findViewById(R.id.buckysText);
    }

    public void saveInfo(View view) {
    }

    public void displayData(View view) {
    }
}