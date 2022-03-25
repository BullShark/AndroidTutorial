package ch.expectusafterlun.androidtutorial;import android.app.ListActivity;import android.content.ComponentName;import android.content.Intent;import android.os.Bundle;import android.view.KeyEvent;import android.view.MenuInflater;import android.view.MenuItem;import android.view.SubMenu;import android.view.View;import android.widget.ArrayAdapter;import android.widget.ListView;public class Menu extends ListActivity implements android.view.Menu {	public Menu() {		super();	}	String[] activities = { "Count", "TextPlay", "Email", "Camera", "Data",			"FullScreen", "GFX", "GFXSurface", "SoundStuff", "Slider", "Tabs",			"SimpleBrowser", "Flipper", "SharedPrefs", "InternalData", "ExternalData",			"SQLiteExample", "Accelerate", "HttpExample", "WeatherXmlParsing",			"GLExample", "GLCubeEx", "Voice", "TextVoice", "StatusBar", "SeekBarVolume",			"ActivityState", "SignIn", "Allison", "GridLayoutExample", "SmartButton",			"Swiper", "MemeCreator", "WebpageDetailHostActivity", "Overflow", "Tranny",			"Apples", "SendBroadcast", "ThreadsExample", "BoundService"	};	@Override	protected void onCreate(Bundle savedInstanceState) {		super.onCreate(savedInstanceState);		setListAdapter(new ArrayAdapter<String>(Menu.this,				android.R.layout.simple_expandable_list_item_1, activities));	}	@Override	protected void onListItemClick(ListView l, View v, int position, long id) {		super.onListItemClick(l, v, position, id);		String activity = activities[position];		try {			Class<?> myClass = Class					.forName("ch.expectusafterlun.androidtutorial." + activity);			/* Different way to start an activity using a class variable */			Intent myIntent = new Intent(Menu.this, myClass);			startActivity(myIntent);		} catch (ClassNotFoundException e) {			e.printStackTrace();		}	}	@Override	public boolean onCreateOptionsMenu(android.view.Menu menu) {		super.onCreateOptionsMenu(menu);		MenuInflater blowUp = getMenuInflater();		blowUp.inflate(R.menu.cool_menu, menu);		return true;	}	@Override	public boolean onOptionsItemSelected(MenuItem item) {		// return super.onOptionsItemSelected(item);		switch (item.getItemId()) {		case R.id.mi_about_us:			Intent i = new Intent("ch.expectusafterlun.androidtutorial.ABOUT");			startActivity(i);			break;		case R.id.mi_preferences:			Intent p = new Intent("ch.expectusafterlun.androidtutorial.PREFS");			startActivity(p);			break;		case R.id.mi_exit:			finish();			break;		}		return false;	}	@Override	public MenuItem add(CharSequence title) {		return null;	}	@Override	public MenuItem add(int titleRes) {		return null;	}	@Override	public MenuItem add(int groupId, int itemId, int order, CharSequence title) {		return null;	}	@Override	public MenuItem add(int groupId, int itemId, int order, int titleRes) {		return null;	}	@Override	public SubMenu addSubMenu(CharSequence title) {		return null;	}	@Override	public SubMenu addSubMenu(int titleRes) {		return null;	}	@Override	public SubMenu addSubMenu(int groupId, int itemId, int order, CharSequence title) {		return null;	}	@Override	public SubMenu addSubMenu(int groupId, int itemId, int order, int titleRes) {		return null;	}	@Override	public int addIntentOptions(int groupId, int itemId, int order, ComponentName caller, Intent[] specifics, Intent intent, int flags, MenuItem[] outSpecificItems) {		return 0;	}	@Override	public void removeItem(int id) {	}	@Override	public void removeGroup(int groupId) {	}	@Override	public void clear() {	}	@Override	public void setGroupCheckable(int group, boolean checkable, boolean exclusive) {	}	@Override	public void setGroupVisible(int group, boolean visible) {	}	@Override	public void setGroupEnabled(int group, boolean enabled) {	}	@Override	public boolean hasVisibleItems() {		return false;	}	@Override	public MenuItem findItem(int id) {		return null;	}	@Override	public int size() {		return 0;	}	@Override	public MenuItem getItem(int index) {		return null;	}	@Override	public void close() {	}	@Override	public boolean performShortcut(int keyCode, KeyEvent event, int flags) {		return false;	}	@Override	public boolean isShortcutKey(int keyCode, KeyEvent event) {		return false;	}	@Override	public boolean performIdentifierAction(int id, int flags) {		return false;	}	@Override	public void setQwertyMode(boolean isQwerty) {	}}