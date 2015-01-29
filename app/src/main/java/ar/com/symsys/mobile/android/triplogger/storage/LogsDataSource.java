package ar.com.symsys.mobile.android.triplogger.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.format.Time;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hsuyama on 28/01/2015.
 */
public class LogsDataSource {
    private LogsSQLiteHelper logsSQLiteHelper;
    private SQLiteDatabase   database;
    private Context          context;

    public LogsDataSource( Context context ){
        this.context = context;
        logsSQLiteHelper = new LogsSQLiteHelper(context);
    }

    public void openDataBase(){ database = logsSQLiteHelper.getWritableDatabase(); }

    public void closeDataBase(){
        if(database != null && database.isOpen()){
            database.close();
        }
    }

    public void addLog( TripLog tripLog ){
        synchronized (this){
            try{
                openDataBase();

                ContentValues values = new ContentValues();

                values.put(LogsTableSchema.LOGID,       tripLog.get_LogId());
                values.put(LogsTableSchema.TRIPID,      tripLog.get_TripId());
                values.put(LogsTableSchema.ODOMETER,    tripLog.get_Odometer());
                values.put(LogsTableSchema.GAS,         tripLog.get_Gas());
                values.put(LogsTableSchema.PRICE,       tripLog.get_Price());
                values.put(LogsTableSchema.DESCRIPTION, tripLog.get_Description());
                values.put(LogsTableSchema.TIMESTAMP,   tripLog.get_TimeStamp().toMillis(true));
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                try{
                    closeDataBase();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public List<TripLog> getAllLogs( int tripId  ){
        ArrayList<TripLog> tripLog = new ArrayList<TripLog>();
        synchronized (this){
            try{
                openDataBase();

                Cursor cursor = database.query(
                        LogsTableSchema.TABLE_NAME,
                        LogsTableSchema.columns,
                        null, null, null, null, null);

                if(cursor.moveToFirst()){
                    while(!cursor.isAfterLast()){
                        if( cursor.getInt(LogsTableSchema.colTRIPID) == tripId) {
                            tripLog.add(readCursor(cursor));
                        }
                        cursor.moveToNext();
                    }
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                try{
                    closeDataBase();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return tripLog;
    }

    private TripLog readCursor(Cursor cursor) {
        TripLog         tripLog = new TripLog();
        Time            time = new Time();

        tripLog.set_LogId(              cursor.getInt(          LogsTableSchema.colLOGID));
        tripLog.set_TripId(cursor.getInt(LogsTableSchema.colTRIPID));
        tripLog.set_Odometer(cursor.getInt(LogsTableSchema.colODOMETER));
        tripLog.set_Gas(cursor.getFloat(LogsTableSchema.colGAS));
        tripLog.set_Price(cursor.getFloat(LogsTableSchema.colPRICE));
        tripLog.set_Description(cursor.getString(LogsTableSchema.colDESCRIPTION));
        time.set(cursor.getInt(LogsTableSchema.colTIMESTAMP));
        tripLog.set_TimeStamp( time );
        return tripLog;
    }
}
