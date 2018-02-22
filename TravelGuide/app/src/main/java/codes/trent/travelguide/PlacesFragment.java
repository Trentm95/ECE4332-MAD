package codes.trent.travelguide;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlacesFragment extends Fragment {

    private Place[] items = {
            new Place(R.drawable.ic_launcher_background,"Place 1", "Description 1"),
            new Place(R.drawable.ic_launcher_background,"Place 2", "Description 2"),
            new Place(R.drawable.ic_launcher_background,"Place 3", "Description 3"),
            new Place(R.drawable.ic_launcher_background,"Place 4", "Description 4"),
            new Place(R.drawable.ic_launcher_background,"Place 5", "Description 5")};

    public PlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout places_layout = (FrameLayout) inflater.inflate(R.layout.fragment_places, container, false);
        ListView listView = (ListView) places_layout.findViewById(R.id.places_list);

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), items);
        listView.setAdapter(adapter);

        return places_layout;
    }


}
