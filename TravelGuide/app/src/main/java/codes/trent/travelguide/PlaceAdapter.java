package codes.trent.travelguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceAdapter extends ArrayAdapter<Place> {

    private Context context;
    private Place[] places;

    // Constructor
    public PlaceAdapter(Context context, Place[] places) {
        super(context, 0 , places);
        this.context = context;
        this.places = places;
    }

    @Override
    public View getView(int position, View listItem, ViewGroup parent) {
        // Inflate view if null
        if(listItem == null){
            listItem = LayoutInflater.from(context).inflate(R.layout.place,parent,false);
        }

        // Get current place by index and assign data
        Place currentPlace = places[position];

        ImageView image = (ImageView)listItem.findViewById(R.id.place_image);
        image.setImageResource(currentPlace.getImage());

        TextView name = (TextView) listItem.findViewById(R.id.textView_name);
        name.setText(currentPlace.getName());

        TextView release = (TextView) listItem.findViewById(R.id.textView_description);
        release.setText(currentPlace.getDescription());

        return listItem;
    }
}
