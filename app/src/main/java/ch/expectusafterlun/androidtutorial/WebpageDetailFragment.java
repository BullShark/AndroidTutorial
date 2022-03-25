package ch.expectusafterlun.androidtutorial;

import android.content.ClipData;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import ch.expectusafterlun.androidtutorial.placeholder.DummyContent;

/**
 * A fragment representing a single Webpage detail screen.
 * This fragment is either contained in a {@link WebpageListFragment}
 * in two-pane mode (on larger screen devices) or self-contained
 * on handsets.
 */
public class WebpageDetailFragment extends Fragment {

    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

    private CollapsingToolbarLayout mToolbarLayout;
    private TextView mTextView;

    private final View.OnDragListener dragListener = (v, event) -> {
        if (event.getAction() == DragEvent.ACTION_DROP) {
            ClipData.Item clipDataItem = event.getClipData().getItemAt(0);
            //mItem = PlaceholderContent.ITEM_MAP.get(clipDataItem.getText().toString());
            mItem = DummyContent.ITEM_MAP.get(clipDataItem.getText().toString());
            updateContent();
        }
        return true;
    };

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public WebpageDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null && getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the placeholder content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            //mItem = PlaceholderContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_webpage_detail, container, false);

        if(mItem != null) {
            ((WebView) rootView.findViewById(R.id.detail_area)).loadUrl(mItem.url);
        }

        return rootView;
    }

    private void updateContent() {
        if (mItem != null) {
            mTextView.setText(mItem.url);
            if (mToolbarLayout != null) {
                mToolbarLayout.setTitle(mItem.item_name);
            }
        }
    }
}