package ice_pbru.junamonduangsang.ice_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ice on 29/4/2559.
 */
public class MySQLite {
    //Explicit
    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public static final String User_table = "userTABLE";
    public static final String colum_id = "_id";
    public static final String colum_Name = "Name";
    public static final String colum_Surname = "Surname";
    public static final String colum_User = "User";
    public static final String colum_Password = "Password";
    public static final String colum_Email = "Email";

    public MySQLite(Context context) {
        myOpenHelper = new MyOpenHelper(context);
        sqLiteDatabase = myOpenHelper.getWritableDatabase();

    }

    public long addNewUser(String strName,
                           String strSurname,
                           String strUser,
                           String strPassword,
                           String strEmail) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(colum_Name, strName);
        contentValues.put(colum_Surname, strSurname);
        contentValues.put(colum_User, strUser);
        contentValues.put(colum_Password, strPassword);
        contentValues.put(colum_Email, strEmail);
        return sqLiteDatabase.insert(User_table, null, contentValues);
    }
}
