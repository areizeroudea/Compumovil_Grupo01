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
    private String[] allColumns = { SQLiteHelper.COLUMN_ID, SQLiteHelper.COLUMN_RACE_NAME, SQLiteHelper.COLUMN_RACE_DATE, SQLiteHelper.COLUMN_RACE_DESC,
            SQLiteHelper.COLUMN_RACE_DIST, SQLiteHelper.COLUMN_RACE_PLACE, SQLiteHelper.COLUMN_RACE_CPHONE, SQLiteHelper.COLUMN_RACE_CEMAIL};

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

    public Race insertRace(Race race)
    {
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_RACE_NAME, race.getName());
        values.put(SQLiteHelper.COLUMN_RACE_DATE, race.getDate());
        values.put(SQLiteHelper.COLUMN_RACE_DESC, race.getDescripion());
        values.put(SQLiteHelper.COLUMN_RACE_DIST, race.getDistance());
        values.put(SQLiteHelper.COLUMN_RACE_PLACE, race.getPlace());
        values.put(SQLiteHelper.COLUMN_RACE_CPHONE, race.getContactPhone());
        values.put(SQLiteHelper.COLUMN_RACE_CEMAIL, race.getContactEmail());
        long insertId = database.insert(SQLiteHelper.TABLE_RACE, null, values);
        Cursor cursor = database.query(SQLiteHelper.TABLE_RACE,
                allColumns, SQLiteHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Race newRace = cursorToRace(cursor);
        cursor.close();
        return newRace;
    }

    public Race getRaceById(long id)
    {
        Cursor cursor = database.query(SQLiteHelper.TABLE_RACE,
                allColumns, SQLiteHelper.COLUMN_ID + " = " + id, null, null, null, null);
        cursor.moveToFirst();
        Race newRace = cursorToRace(cursor);
        cursor.close();
        return newRace;
    }

    public List<Race> getAllRaces()
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
        race.setName(cursor.getString(1));
        race.setDate(cursor.getString(2));
        race.setDescripion(cursor.getString(3));
        race.setDistance(cursor.getString(4));
        race.setPlace(cursor.getString(5));
        race.setContactPhone(cursor.getString(6));
        race.setContactEmail(cursor.getString(7));
        return race;
    }

}
