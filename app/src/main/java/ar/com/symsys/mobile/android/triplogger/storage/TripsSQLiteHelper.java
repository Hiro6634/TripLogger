package ar.com.symsys.mobile.android.triplogger.storage;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.ResourceBundle;

/**
 * Created by hsuyama on 28/01/2015.
 */
public class TripsSQLiteHelper extends SQLiteOpenHelper{
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


    public TripsSQLiteHelper(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreateTripLogs);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TripsTableSchema.TABLE_NAME);
        db.execSQL(sqlCreateTripLogs);
    }

    protected String parseXml(Context context){
        try{
            StringBuilder   sb = new StringBuilder(500);
            sb.append("INSERT INTO " + TripsTableSchema.TABLE_NAME + " VALUES (");
            XmlPullParserFactory xppFactory = XmlPullParserFactory.newInstance();
            xppFactory.setNamespaceAware(true);
            XmlPullParser xpp = xppFactory.newPullParser();


            );

        }
        catch(Exception e){

        }
    }
}
