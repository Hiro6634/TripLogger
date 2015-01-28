package ar.com.symsys.mobile.android.triplogger.ar.com.symsys.mobile.android.triplogger.storage;

/**
 * Created by hsuyama on 28/01/2015.
 */
public class LogsTableSchema {
    public static final String 		TABLE_NAME 		= "Logs";
    public static final String		LOGID           = "LogId";
    public static final String		TRIPID  		= "TripId";
    public static final String		ODOMETER		= "Odometer";
    public static final String		GAS				= "Gas";
    public static final String		PRICE			= "Price";
    public static final String		DESCRIPTION		= "Description";
    public static final String		TIMESTAMP		= "TimeStamp";

    public static final String[]	columns			= { LOGID, TRIPID, ODOMETER, GAS, PRICE, DESCRIPTION, TIMESTAMP};

    public static final int			colLOGID 		= 0;
    public static final int			colTRIPID		= 1;
    public static final int			colODOMETER 	= 2;
    public static final int			colGAS			= 3;
    public static final int			colPRICE		= 4;
    public static final int			colDESCRIPTION	= 5;
    public static final int			colTIMESTAMP	= 6;
}
