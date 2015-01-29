package ar.com.symsys.mobile.android.triplogger.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.Time;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hsuyama on 28/01/2015.
 */
public class LogsDataSource {
    private TripsSQLiteHelper logsSQLiteHelper;
    private SQLiteDatabase   database;
    private Context          context;

    public LogsDataSource( Context context ){
        this.context = context;
        logsSQLiteHelper = new TripsSQLiteHelper(context);
    }

    public void openDataBase(){ database = logsSQLiteHelper.getWritableDatabase(); }

    public void closeDataBase(){
        if(database != null && database.isOpen()){
            database.close();
        }
    }

    public void addLog( LogElement logElement){
        synchronized (this){
            try{
                openDataBase();

                ContentValues values = new ContentValues();

                values.put(LogsTableSchema.LOGID,       logElement.get_LogId());
                values.put(LogsTableSchema.TRIPID,      logElement.get_TripId());
                values.put(LogsTableSchema.ODOMETER,    logElement.get_Odometer());
                values.put(LogsTableSchema.GAS,         logElement.get_Gas());
                values.put(LogsTableSchema.PRICE,       logElement.get_Price());
                values.put(LogsTableSchema.DESCRIPTION, logElement.get_Description());
                values.put(LogsTableSchema.TIMESTAMP,   logElement.get_TimeStamp().toMillis(true));
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

    public List<LogElement> getAllLogs( int tripId  ){
        ArrayList<LogElement> logElement = new ArrayList<LogElement>();
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
                            logElement.add(readCursor(cursor));
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
        return logElement;
    }

    private LogElement readCursor(Cursor cursor) {
        LogElement logElement = new LogElement();
        Time            time = new Time();

        logElement.set_LogId(              cursor.getInt(          LogsTableSchema.colLOGID));
        logElement.set_TripId(cursor.getInt(LogsTableSchema.colTRIPID));
        logElement.set_Odometer(cursor.getInt(LogsTableSchema.colODOMETER));
        logElement.set_Gas(cursor.getFloat(LogsTableSchema.colGAS));
        logElement.set_Price(cursor.getFloat(LogsTableSchema.colPRICE));
        logElement.set_Description(cursor.getString(LogsTableSchema.colDESCRIPTION));
        time.set(cursor.getInt(LogsTableSchema.colTIMESTAMP));
        logElement.set_TimeStamp( time );
        return logElement;
    }
}
