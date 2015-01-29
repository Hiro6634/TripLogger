package ar.com.symsys.mobile.android.triplogger.storage;

/**
 * Created by hsuyama on 28/01/2015.
 */
public class TripsTableSchema {
    public static final String 		TABLE_NAME 		= "Trips";
    public static final String		TRIPID  		= "TripId";
    public static final String		TRIPNAME        = "TripName";
    public static final String		STARTTRIP   	= "StartTrip";
    public static final String		ENDTRIP			= "EndTrip";
    public static final String		TOTALGAS		= "TotalGas";
    public static final String		AMOUNT  		= "Amount";
    public static final String		TIMESTAMP		= "TimeStamp";

    public static final String[]	columns			= { TRIPID, TRIPNAME, STARTTRIP, ENDTRIP, TOTALGAS, AMOUNT, TIMESTAMP};

    public static final int			colTRIPID		= 0;
    public static final int			colTRIPNAME		= 1;
    public static final int			colSTARTTRIP	= 2;
    public static final int			colENDTRIP		= 3;
    public static final int			colTOTALGAS		= 4;
    public static final int			colAMOUNT	    = 5;
    public static final int			colTIMESTAMP	= 6;
}
