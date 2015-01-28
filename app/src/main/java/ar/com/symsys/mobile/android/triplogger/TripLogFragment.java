package ar.com.symsys.mobile.android.triplogger;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by hsuyama on 28/01/2015.
 */
public class TripLogFragment extends ListFragment {
    private ListView listview;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String tripName = ((TripLog)getActivity()).getTripName();

        String[] arrayLogs = new String[]{
                "Saladillo",
                "Olavarria",
                "Coronel Pringles",
                "Bahia Blanca",
                "Viedma"
        };

        ArrayList<String> tripLogs = new ArrayList<String>(Arrays.asList(arrayLogs));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                tripLogs
                );
        try {
            setListAdapter(adapter);
        }
        catch (Exception e){
            String str = e.getMessage();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trip_log, container, false);
        //listview = (ListView)view.findViewById(R.id.listView);
        return view;
    }
}
