package codes.trent.travelguide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    public View getView(int position, View listItem, final ViewGroup parent) {
        // Inflate view if null
        if(listItem == null){
            listItem = LayoutInflater.from(context).inflate(R.layout.place,parent,false);
        }

        // Get current place by index and assign data
        final Place currentPlace = places[position];

        // Image setup
        ImageView image = (ImageView)listItem.findViewById(R.id.place_image);
        image.setImageResource(currentPlace.getSmallImage());
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            ((MainActivity)context).onMsgFromFragToMain("PlacesFragment",currentPlace.getName());
            Intent intent = new Intent(context, ImageActivity.class);
            intent.putExtra("Small_Image",currentPlace.getSmallImage());
            context.startActivity(intent);
            }
        });

        // Name setup
        TextView name = (TextView) listItem.findViewById(R.id.textView_name);
        name.setText(currentPlace.getName());

        // Description setup
        TextView description = (TextView) listItem.findViewById(R.id.textView_description);
        description.setText(currentPlace.getDescription());

        // Button setup
        Button button = (Button) listItem.findViewById(R.id.view_details);
        button.setText(R.string.view_details);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            ((MainActivity)context).onMsgFromFragToMain("PlacesFragment",currentPlace.getName());
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("Large_Image", currentPlace.getLargeImage());
            intent.putExtra("Name", currentPlace.getName());
            intent.putExtra("Details", currentPlace.getDetails());
            context.startActivity(intent);
            }
        });

        return listItem;
    }
}
