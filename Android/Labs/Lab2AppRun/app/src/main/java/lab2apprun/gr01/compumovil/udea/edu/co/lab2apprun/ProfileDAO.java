package lab2apprun.gr01.compumovil.udea.edu.co.lab2apprun;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by areizero on 24/03/2016.
 */
public class ProfileDAO
{
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;  //clase propia que ayuda a establecer nuestra BD
    private String[] allColumns = { SQLiteHelper.COLUMN_ID, SQLiteHelper.COLUMN_PR_USERNAME, SQLiteHelper.COLUMN_PR_EMAIL, SQLiteHelper.COLUMN_PR_PASS};

    public ProfileDAO(Context context)
    {
        dbHelper = new SQLiteHelper(context);
    }

    public void open() throws SQLException
    {
        database = dbHelper.getWritableDatabase();
    }

    public void close()
    {
        dbHelper.close();
    }

    public Profile insertProfile(Profile prof)
    {
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_PR_USERNAME, prof.getUserName());
        values.put(SQLiteHelper.COLUMN_PR_EMAIL, prof.getEmail());
        values.put(SQLiteHelper.COLUMN_PR_PASS, prof.getPassword());
        long insertId = database.insert(SQLiteHelper.TABLE_PROFILE, null, values);
        Cursor cursor = database.query(SQLiteHelper.TABLE_PROFILE,
                allColumns, SQLiteHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Profile newProfile = cursorToProfile(cursor);
        cursor.close();
        return newProfile;
    }

    public Profile getProfileById(long id)
    {
        Cursor cursor = database.query(SQLiteHelper.TABLE_PROFILE,
                allColumns, SQLiteHelper.COLUMN_ID + " = " + id, null, null, null, null);
        cursor.moveToFirst();
        Profile newProfile = cursorToProfile(cursor);
        cursor.close();
        return newProfile;
    }

public List<Profile> getAllProfiles()
    {
        List<Profile> profs = new ArrayList<Profile>();
        Cursor cursor = database.query(SQLiteHelper.TABLE_PROFILE, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            Profile raceGet = cursorToProfile(cursor);
            profs.add(raceGet);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return profs;
    }


    public Profile getProfileByUserName(String username)
    {
        String query = "SELECT * FROM " + SQLiteHelper.TABLE_PROFILE + " WHERE " + SQLiteHelper.COLUMN_PR_USERNAME + " = " + "areiza";
        Cursor cursor = database.rawQuery(query, null);
        /*Cursor cursor = database.query(SQLiteHelper.TABLE_PROFILE,
                allColumns, SQLiteHelper.COLUMN_PR_USERNAME + " = " + username, null, null, null, null);*/
        if(cursor.moveToFirst())
        {
            Log.v("ProfileDao", "Cursor is " + cursor.toString());
            Profile newProfile = cursorToProfile(cursor);
            return newProfile;
        }
        else
        {
            Log.v("ProfileDao", "No Results");
        }
        cursor.close();

        return null;
    }

    private Profile cursorToProfile(Cursor cursor)
    {
        Profile profile = new Profile();
        profile.setId(cursor.getLong(0));
        profile.setUserName(cursor.getString(1));
        profile.setEmail(cursor.getString(2));
        profile.setPassword(cursor.getString(3));
        return profile;
    }
}
