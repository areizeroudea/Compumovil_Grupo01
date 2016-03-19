package lab2apprun.gr01.compumovil.udea.edu.co.lab2apprun;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by areizero on 19/03/2016.
 */
/*Define los accesos a la base de datos*/
public class SQLiteHelper extends SQLiteOpenHelper
{
    /*Database*/
    private static final String DATABASE_NAME = "races.db";
    private static final int DATABASE_VERSION = 2;

    /*Tabla RACE*/
    public static final String TABLE_RACE = "race";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_RACE_NAME = "race_name";
    public static final String COLUMN_RACE_DATE = "race_date";
    public static final String COLUMN_RACE_DESC = "race_description";
    public static final String COLUMN_RACE_DIST = "race_distance";
    public static final String COLUMN_RACE_PLACE = "race_place";
    public static final String COLUMN_RACE_CPHONE = "race_conphone";
    public static final String COLUMN_RACE_CEMAIL = "race_conemail";

    /*Tabla PROFILE*/
    public static final String TABLE_PROFILE = "profile";
    public static final String COLUMN_PR_USERNAME = "pr_username";
    public static final String COLUMN_PR_PASS = "pr_password";
    public static final String COLUMN_PR_EMAIL = "pr_email";

    // Database creation sql statement
    private static final String DATABASE_CREATE =
            "create table " + TABLE_RACE +
                    "(" + COLUMN_ID + " integer primary key autoincrement, " + COLUMN_RACE_NAME + " text not null," +
                    COLUMN_RACE_DATE + " text not null," + COLUMN_RACE_DESC + " text not null," + COLUMN_RACE_DIST + " text not null," +
                    COLUMN_RACE_PLACE + " text not null," + COLUMN_RACE_CPHONE + " text not null," +
                    COLUMN_RACE_CEMAIL + " text not null" +");";

    public SQLiteHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        Log.w(SQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RACE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILE);
        onCreate(db);
    }
}
