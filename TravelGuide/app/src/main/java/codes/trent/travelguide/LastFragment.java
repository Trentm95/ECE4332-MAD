package codes.trent.travelguide;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LastFragment extends Fragment {

    FrameLayout frameLayout;
    TextView textView;

    public LastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_last, container, false);
        textView = (TextView) frameLayout.findViewById(R.id.last_place);
        textView.setText("View a place to travel!");
        return frameLayout;
    }

    // Set msg as place
    public void onMsgFromMainToFragment(String strValue){
        textView.setText("Previously chosen travel place was " + strValue + ".");
    }

}
