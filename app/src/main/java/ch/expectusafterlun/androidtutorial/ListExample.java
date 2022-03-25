package ch.expectusafterlun.androidtutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListExample extends Activity {


    // new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_example);

        String[] foods = {"Bacon", "Ham", "Tuna", "Candy", "Meatball", "Potato"};
        ListAdapter adapter =
                new CustomAdapter(this, foods);
        ListView listView = findViewById(R.id.chrisListView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
            new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String food = String.valueOf(parent.getItemAtPosition(position));
                    Toast.makeText(ListExample.this, food, Toast.LENGTH_LONG).show();
                }
            }
        );
    }
}