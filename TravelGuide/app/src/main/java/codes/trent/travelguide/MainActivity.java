package codes.trent.travelguide;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    PlacesFragment placesFragment;
    LastFragment lastFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);

        // Store fragment reference in variable when it is attached.
        if (fragment.getClass() == PlacesFragment.class ){
            placesFragment = (PlacesFragment) fragment;
        }
        if (fragment.getClass() == LastFragment.class ){
            lastFragment = (LastFragment) fragment;
        }
    }

    // Forwards msg from PlacesFragment to LastFragment
    public void onMsgFromFragToMain(String sender, String strValue) {
        if(sender.equals("PlacesFragment")){
            lastFragment.onMsgFromMainToFragment(strValue);
        }
    }

}
