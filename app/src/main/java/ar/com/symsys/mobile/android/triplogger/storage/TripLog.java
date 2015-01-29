package ar.com.symsys.mobile.android.triplogger.storage;

import android.text.format.Time;

/**
 * Created by hsuyama on 28/01/2015.
 */
public class TripLog {
    private int     _LogId;
    private int     _TripId;
    private int     _Odometer;
    private float   _Gas;
    private float   _Price;
    private String  _Description;
    private Time    _TimeStamp;

    public int get_LogId() {
        return _LogId;
    }

    public void set_LogId(int _LogId) {
        this._LogId = _LogId;
    }

    public int get_TripId() {
        return _TripId;
    }

    public void set_TripId(int _TripId) {
        this._TripId = _TripId;
    }

    public int get_Odometer() {
        return _Odometer;
    }

    public void set_Odometer(int _Odometer) {
        this._Odometer = _Odometer;
    }

    public float get_Gas() {
        return _Gas;
    }

    public void set_Gas(float _Gas) {
        this._Gas = _Gas;
    }

    public float get_Price() {
        return _Price;
    }

    public void set_Price(float _Price) {
        this._Price = _Price;
    }

    public String get_Description() {
        return _Description;
    }

    public void set_Description(String _Description) {
        this._Description = _Description;
    }

    public Time get_TimeStamp() {
        return _TimeStamp;
    }

    public void set_TimeStamp(Time _TimeStamp) {
        this._TimeStamp = _TimeStamp;
    }
}
