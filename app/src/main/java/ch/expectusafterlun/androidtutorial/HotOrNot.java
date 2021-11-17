package ch.expectusafterlun.androidtutorial;

public class HotOrNot {

    /*
     * Gives us the row id
     * Everytime we put something in the db,
     * it's going to create a row starting at
     * 1, the next time we enter something into the db,
     * row 2, row 3, and this is a way to reference that
     */
    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "persons_name";
    public static final String KEY_HOTNESS = "persons_hotness";

    private static final String DATABASE_NAME = "hotornotdb";
    /*
     * A table will hold rowid, name, hotness
     */
    private static final String DATABASE_TABLE = "people_table";
    private static final int DATABASE_VERSION = 1;

}
