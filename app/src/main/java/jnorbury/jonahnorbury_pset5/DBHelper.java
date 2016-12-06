package jnorbury.jonahnorbury_pset5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jonah on 21-Nov-16.
 */

public class DBHelper extends SQLiteOpenHelper {

    // fields of db
    private static final String DATABASE_NAME = "myDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE = "lists";

    public static String name;

    // constructor
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //onCreate
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE + "( `_id` int(10) NOT NULL AUTO_INCREMENT, `name` varchar(50) NOT NULL, `completed` tinyint(1) NOT NULL DEFAULT '0', `due_date` date DEFAULT NULL, `rating` float DEFAULT NULL, `picture` int(11) DEFAULT NULL, `extra_description` varchar(144) DEFAULT NULL, `list_type` varchar(30) NOT NULL, PRIMARY KEY (`_id`), UNIQUE KEY `name` (`name`) ) ENGINE=InnoDB DEFAULT CHARSET=latin1; sqLiteDatabase.execSQL(CREATE_TABLE)";
    }

    //onUpgrade
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(sqLiteDatabase);

    }

    // CRUD methods
    // create
    public void create(TodoItem task) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("task_name", task.getName());

        db.insert(TABLE, null, values);
        db.close();
    }

    public ArrayList<ToDoList> readlists() {
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT listName FROM " + TABLE;
        ArrayList<ToDoList> dblist = new ArrayList<>();
        Cursor crs = db.rawQuery(query, null);
        if (crs.moveToFirst()) {
            do {
                MasterList listdata = new MasterList();
                String cs = crs.getString(crs.getColumnIndex("listName");
                for (int i = 0; i < listdata.size(); i++) {
                    if (cs.matches(listdata.get(i).getList_name()) {
                        break;
                    }
                }
                listdata.add(dblist);
                dblist.add(listdata);
            }
            while(crs.moveToNext());
        }
        crs.close();
        db.close();
        return dblist;

    }

    // read
    public ArrayList<HashMap<String, String>> read() {

        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT _id , task_name FROM " + TABLE;
        ArrayList<HashMap<String, String>> taskdb = new ArrayList<>();
        Cursor crs = db.rawQuery(query, null);
        if (crs.moveToFirst()) {

            do {
                HashMap<String, String> taskdata = new HashMap<>();
                taskdata.put("name", crs.getString(crs.getColumnIndex("_id")) + " - " + crs.getString(crs.getColumnIndex("task_name")));
                taskdb.add(taskdata);
            }
            while(crs.moveToNext());
        }
        crs.close();
        db.close();
        return taskdb;

    }

    // update task (for if I feel like it)
//    public void update(ToDoTask task) {
//
//        SQLiteDatabase db = getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("task_id", task."phone number");
//        values.put("task_name", task."person name");
//        db.update(TABLE, values, "_id = ?", new String[] {String.valueOf(task."task_id")});
//        db.close();
//
//    }

//    public void

    // delete
    public void delete(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE, "_id = ?", new String[] {String.valueOf(id)});
        db.close();
    }
}


