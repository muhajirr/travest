package com.mobile.travest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by haimax on 10/26/17.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "data.db";
    private static final String TABLE_USER_NAME = "users";

    public static final String KEY_ID_USER = "id";
    public static final String KEY_NAME_USER = "name";
    public static final String KEY_EMAIL_USER = "email";
    public static final String KEY_PASSWORD_USER = "password";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_QUERY = "create table " + TABLE_USER_NAME + " ("
                + KEY_ID_USER + " integer primary key, "
                + KEY_NAME_USER + " text, "
                + KEY_EMAIL_USER + " text, "
                + KEY_PASSWORD_USER + " text)";

        sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME_USER, user.getName());
        values.put(KEY_EMAIL_USER, user.getEmail());
        values.put(KEY_PASSWORD_USER, user.getPassword());

        db.insert(TABLE_USER_NAME, null, values);
        db.close();
    }

    public boolean verifyUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_USER_NAME + " WHERE "
                            + KEY_EMAIL_USER + "='" + user.getEmail() + "' AND "
                            + KEY_PASSWORD_USER + "='" + user.getPassword() + "'";

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.getCount() > 0 ) {
            cursor.close();
            db.close();

            return true;
        }

        cursor.close();
        db.close();
        return false;
    }

    public ArrayList<User> getAllUser() {
        SQLiteDatabase db = this.getWritableDatabase();

        ArrayList<User> userArrayList = new ArrayList<User>();

        String selectQuery = "SELECT * FROM " + TABLE_USER_NAME;

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setName(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setPassword(cursor.getString(3));

                userArrayList.add(user);
            } while (cursor.moveToNext());
        }

        return userArrayList;
    }

    public User getUserID(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_USER_NAME + " WHERE " + KEY_ID_USER + " = " + id;

        Cursor cursor = db.rawQuery(selectQuery, null);
        User user = new User();

        if (cursor.moveToFirst()) {
            user.setId(Integer.parseInt(cursor.getString(0)));
            user.setName(cursor.getString(1));
            user.setEmail(cursor.getString(2));
            user.setPassword(cursor.getString(3));
        }

        return user;
    }

    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

/*        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(TABLE_CONTACT_NAME, contact.getPhone());*/

        String updateQuery = "UPDATE " + TABLE_USER_NAME + " SET " + KEY_NAME_USER + "='" + user.getName()
                + "', " + KEY_EMAIL_USER + "='" + user.getEmail() + "', " + KEY_PASSWORD_USER + "='"
                + user.getPassword() + "' WHERE " + KEY_ID_USER + "=" + user.getId();

        db.execSQL(updateQuery);

        // return db.update(TABLE_CONTACT_NAME, values, KEY_ID + "=" + contact.getId(), null);
    }

    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER_NAME, KEY_ID_USER + "=" + user.getId(), null);

        db.close();
    }
}