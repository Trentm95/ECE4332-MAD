package codes.trent.travelguide;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

public class PlacesFragment extends Fragment {

    private Place[] items = {
            new Place(R.drawable.berlin_small, R.drawable.paris_large,"Paris", "France", "France's capital, home to the Eiffel Tower, Louvre, Notre-Dame, sidewalk cafes & high fashion."),
            new Place(R.drawable.london_small, R.drawable.london_large,"London", "United Kingdom", "England & U.K. capital, home to Buckingham Palace, St. Paul’s Cathedral, British Museum & Hyde Park."),
            new Place(R.drawable.rome_small, R.drawable.rome_large,"Rome", "Italy", "Italy's capital, home to the Vatican as well as world-class art & ancient ruins like the Colosseum."),
            new Place(R.drawable.berlin_small, R.drawable.berlin_large,"Berlin", "Germany", "Germany's capital, with the Reichstag, Brandenburg Gate, the Holocaust memorial & Berlin Wall."),
            new Place(R.drawable.madrid_small, R.drawable.madrid_large,"Madrid", "Spain", "Spain's capital, home to the Royal Palace & major art museums like the Prado & Reina Sofía.")};

    public PlacesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout places_layout = (FrameLayout) inflater.inflate(R.layout.fragment_places, container, false);
        ListView listView = (ListView) places_layout.findViewById(R.id.places_list);

        // Populate list view
        PlaceAdapter adapter = new PlaceAdapter(getActivity(), items);
        listView.setAdapter(adapter);

        return places_layout;
    }


}
