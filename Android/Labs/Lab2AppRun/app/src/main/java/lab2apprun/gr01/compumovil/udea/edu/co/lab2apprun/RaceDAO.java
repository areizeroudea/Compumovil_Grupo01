package lab2apprun.gr01.compumovil.udea.edu.co.lab2apprun;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by areizero on 19/03/2016.
 */
public class RaceDAO
{
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;  //clase propia que ayuda a establecer nuestra BD
    private String[] allColumns = { SQLiteHelper.COLUMN_ID, SQLiteHelper.COLUMN_RACE_NAME};

    public RaceDAO(Context context)
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

    public Race createRace(String race)
    {
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_RACE_NAME, race);
        long insertId = database.insert(SQLiteHelper.TABLE_RACE, null, values);
        Cursor cursor = database.query(SQLiteHelper.TABLE_RACE,
                allColumns, SQLiteHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Race newRace = cursorToRace(cursor);
        cursor.close();
        return newRace;
    }

    public List<Race> getAllComments()
    {
        List<Race> races = new ArrayList<Race>();
        Cursor cursor = database.query(SQLiteHelper.TABLE_RACE, allColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            Race raceGet = cursorToRace(cursor);
            races.add(raceGet);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();
        return races;
    }

    private Race cursorToRace(Cursor cursor)
    {
        Race race = new Race();
        race.setId(cursor.getLong(0));
        race.setName(cursor.getString(2));
        return race;
    }

}
