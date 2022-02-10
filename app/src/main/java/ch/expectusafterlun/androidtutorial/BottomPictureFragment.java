package ch.expectusafterlun.androidtutorial;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/*
 * Rules for a Fragment:
 * 1) Inherits/extends Fragment
 * 2) Needs to override onCreateView(...)
 */
public class BottomPictureFragment extends Fragment {

    private static TextView topMemeText;
    private static TextView bottomMemeText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_picture_fragment, container, false);

        topMemeText = (TextView) view.findViewById(R.id.tv_top_meme_text);
        bottomMemeText = (TextView) view.findViewById(R.id.tv_bottom_meme_text);

        return view;
    }

    public void setMemeText(String top, String bottom) {
        topMemeText.setText(top);
        bottomMemeText.setText(bottom);
    }
}
