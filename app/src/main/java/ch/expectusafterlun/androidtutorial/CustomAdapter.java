package ch.expectusafterlun.androidtutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class CustomAdapter extends ArrayAdapter<String> {

    public CustomAdapter(@NonNull Context context, String[] foods) {
        super(context, R.layout.custom_row, foods);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // the goal is to recycle the already existing view in that list,
        // not to init it each time you display it when scrolling the list for example.
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View customView = inflater.inflate(R.layout.custom_row, parent, false);

            String singleFoodItem = getItem(position);
            TextView tv = customView.findViewById(R.id.bucksText);
            ImageView iv = customView.findViewById(R.id.bucksImage);

            tv.setText(singleFoodItem);
            iv.setImageResource(R.drawable.jennifer_lopez);

            return customView;
        } else {
            // [...] some changes that must be done at refresh
            return convertView;
        }
    }
}
