package ar.com.symsys.mobile.android.triplogger.ar.com.symsys.mobile.android.triplogger.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hsuyama on 28/01/2015.
 */
public class LogsSQLiteHelper extends SQLiteOpenHelper{
    private static final String		dbName 		= "TripLogDB";
    private static final int		dbVersion 	= 1;

    private static final String		sqlCreateTripLogs	= "CREATE TABLE " + LogsTableSchema.TABLE_NAME + " ("
            + LogsTableSchema.LOGID	        + " INTEGER PRIMARY KEY, "
            + LogsTableSchema.TRIPID        + " INTEGER, "
            + LogsTableSchema.ODOMETER  	+ " INTEGER, "
            + LogsTableSchema.GAS           + " REAL, "
            + LogsTableSchema.PRICE         + " REAL, "
            + LogsTableSchema.DESCRIPTION   + " TEXT, "
            + LogsTableSchema.TIMESTAMP	    + " INTEGER )";


    public LogsSQLiteHelper(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreateTripLogs);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LogsTableSchema.TABLE_NAME);
        db.execSQL(sqlCreateTripLogs);
    }
}
