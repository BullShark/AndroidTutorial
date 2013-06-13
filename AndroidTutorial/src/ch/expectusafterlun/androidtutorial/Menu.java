package ch.expectusafterlun.androidtutorial;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String activities[] = {"Count", "TextPlay",
			"Email", "Camera", "Data", "example5", "example6"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_expandable_list_item_1, activities));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		String activity = activities[position];
		try {
			Class<?> myClass = Class.forName("expectusafterlun.ch.androidtutorial." + activity);
			/* Different way to start an activity using a class variable */
			Intent myIntent = new Intent(Menu.this, myClass);
			startActivity(myIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}