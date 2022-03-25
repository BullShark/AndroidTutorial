package ch.expectusafterlun.androidtutorial;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.view.Menu;

public class Allison extends Activity implements Menu {

    @SuppressLint({"ResourceType", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Layout
        RelativeLayout rl = new RelativeLayout(this);
        Button redButton = new Button(this);
        EditText etUserName = new EditText(this);

        // Set the IDs before calling View.getId()
        redButton.setId(1);
        etUserName.setId(2);

        // Rules
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

        RelativeLayout.LayoutParams userNameDetails = new RelativeLayout.LayoutParams(
                //RelativeLayout.LayoutParams.FILL_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        userNameDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
        userNameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        userNameDetails.setMargins(0,0,0, 50);

        // Convert density pixels (dp) to pixels
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                200,
                r.getDisplayMetrics());

        // Attributes
        etUserName.setWidth(px);
        redButton.setText("Log In");
        rl.setBackgroundColor(Color.GREEN);
        redButton.setBackgroundColor(Color.RED);

        // Add widget to layout
        rl.addView(redButton, buttonDetails);
        rl.addView(etUserName, userNameDetails);

        // Set this Activities content(display) to this View
        setContentView(rl);
    }

    //@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cool_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public MenuItem add(CharSequence title) {
        return null;
    }

    @Override
    public MenuItem add(int titleRes) {
        return null;
    }

    @Override
    public MenuItem add(int groupId, int itemId, int order, CharSequence title) {
        return null;
    }

    @Override
    public MenuItem add(int groupId, int itemId, int order, int titleRes) {
        return null;
    }

    @Override
    public SubMenu addSubMenu(CharSequence title) {
        return null;
    }

    @Override
    public SubMenu addSubMenu(int titleRes) {
        return null;
    }

    @Override
    public SubMenu addSubMenu(int groupId, int itemId, int order, CharSequence title) {
        return null;
    }

    @Override
    public SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes) {
        return null;
    }

    @Override
    public int addIntentOptions(int groupId, int itemId, int order, ComponentName caller, Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {
        return 0;
    }

    @Override
    public void removeItem(int id) {

    }

    @Override
    public void removeGroup(int groupId) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {

    }

    @Override
    public void setGroupVisible(int group, boolean visible) {

    }

    @Override
    public void setGroupEnabled(int group, boolean enabled) {

    }

    @Override
    public boolean hasVisibleItems() {
        return false;
    }

    @Override
    public MenuItem findItem(int id) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public MenuItem getItem(int index) {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public boolean performShortcut(int keyCode, KeyEvent event, int flags) {
        return false;
    }

    @Override
    public boolean isShortcutKey(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean performIdentifierAction(int id, int flags) {
        return false;
    }

    @Override
    public void setQwertyMode(boolean isQwerty) {

    }
}