package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    // Save the user's login info
    public void saveInfo(View view) {
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", usernameInput.getText().toString());
        editor.putString("password", passwordInput.getText().toString());
        editor.apply();

        usernameInput.setText("");
        passwordInput.setText("");

        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
    }

    // Print out the saved data
    public void displayData(View view) {
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        String name = sharedPref.getString("username", "");
        String password = sharedPref.getString("password", "");

        buckysText.setText(name + " " + password);
    }
}