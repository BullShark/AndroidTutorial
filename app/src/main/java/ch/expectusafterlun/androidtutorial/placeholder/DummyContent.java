package ch.expectusafterlun.androidtutorial.placeholder;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Android Tutorials", "https://www.thenewboston.com/videos.php?cat=278"));
        addItem(new DummyItem("2", "SQLite Tutorial", "https://www.vogella.com/tutorials/AndroidSQLite/article.html"));
        addItem(new DummyItem("3", "Developer Tutorials", "https://developer.android.com/training/index.html"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String item_name;
        public final String url;

        public DummyItem(String id, String item_name, String url) {
            this.id = id;
            this.item_name = item_name;
            this.url = url;
        }

        @NonNull
        @Override
        public String toString() {
            return item_name;
        }
    }
}