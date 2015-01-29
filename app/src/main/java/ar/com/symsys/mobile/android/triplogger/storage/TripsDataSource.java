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
public class TripsDataSource {
    private TripsSQLiteHelper tripsSQLiteHelper;
    private SQLiteDatabase   database;
    private Context          context;

    public TripsDataSource(Context context){
        this.context = context;
        tripsSQLiteHelper = new TripsSQLiteHelper(context);
    }

    public void openDataBase(){ database = tripsSQLiteHelper.getWritableDatabase(); }

    public void closeDataBase(){
        if(database != null && database.isOpen()){
            database.close();
        }
    }

    public void addLog( TripElement tripElement){
        synchronized (this){
            try{
                openDataBase();

                ContentValues values = new ContentValues();

                values.put(TripsTableSchema.TRIPID,      tripElement.get_TripId());
                values.put(TripsTableSchema.TRIPNAME,    tripElement.get_TripName());
                values.put(TripsTableSchema.STARTTRIP,   tripElement.get_StartTrip().toMillis(true));
                values.put(TripsTableSchema.ENDTRIP,     tripElement.get_EndTrip().toMillis(true));
                values.put(TripsTableSchema.TOTALGAS,    tripElement.get_TotalGas());
                values.put(TripsTableSchema.AMOUNT,      tripElement.get_Amount());
                values.put(TripsTableSchema.TIMESTAMP,   tripElement.get_TimeStamp().toMillis(true));
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

    public List<TripElement> getAllTrips( int tripId  ){
        ArrayList<TripElement> tripElement = new ArrayList<TripElement>();
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
                            tripElement.add(readCursor(cursor));
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
        return tripElement;
    }

    private TripElement readCursor(Cursor cursor) {
        TripElement tripElement = new TripElement();
        Time        time        = new Time();

        tripElement.set_TripId(      cursor.getInt(          TripsTableSchema.colTRIPID));
        tripElement.set_TripName(    cursor.getString(       TripsTableSchema.colTRIPNAME));
        time.set(                    cursor.getInt(          TripsTableSchema.colSTARTTRIP));
        tripElement.set_StartTrip(time);
        time.set(                    cursor.getInt(          TripsTableSchema.colENDTRIP));
        tripElement.set_EndTrip(time);
        tripElement.set_TotalGas(    cursor.getFloat(        TripsTableSchema.colTOTALGAS));
        tripElement.set_Amount(      cursor.getFloat(        TripsTableSchema.colAMOUNT));
        time.set(cursor.getInt(                              TripsTableSchema.colTIMESTAMP));
        tripElement.set_TimeStamp( time  );
        return tripElement;
    }
}
