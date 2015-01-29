package ar.com.symsys.mobile.android.triplogger.storage;

import android.text.format.Time;

/**
 * Created by hsuyama on 28/01/2015.
 */
public class TripElement {
    private int     _TripId;
    private String  _TripName;
    private Time    _StartTrip;
    private Time    _EndTrip;
    private float   _TotalGas;
    private float   _Amount;
    private Time    _TimeStamp;

    public int get_TripId() {
        return _TripId;
    }

    public void set_TripId(int _TripId) {
        this._TripId = _TripId;
    }

    public String get_TripName() {
        return _TripName;
    }

    public void set_TripName(String _TripName) {
        this._TripName = _TripName;
    }

    public Time get_StartTrip() {
        return _StartTrip;
    }

    public void set_StartTrip(Time _StartTrip) {
        this._StartTrip = _StartTrip;
    }

    public Time get_EndTrip() {
        return _EndTrip;
    }

    public void set_EndTrip(Time _EndTrip) {
        this._EndTrip = _EndTrip;
    }

    public float get_TotalGas() {
        return _TotalGas;
    }

    public void set_TotalGas(float _TotalGas) {
        this._TotalGas = _TotalGas;
    }

    public float get_Amount() {
        return _Amount;
    }

    public void set_Amount(float _Amount) {
        this._Amount = _Amount;
    }

    public Time get_TimeStamp() {
        return _TimeStamp;
    }

    public void set_TimeStamp(Time _TimeStamp) {
        this._TimeStamp = _TimeStamp;
    }
}
