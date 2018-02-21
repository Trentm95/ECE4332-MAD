package codes.trent.travelguide;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    PlaceFragment placeFragment;
    LastFragment lastFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);

        // Store fragment reference in variable when it is attached.
        if (fragment.getClass() == PlaceFragment.class ){
            placeFragment = (PlaceFragment) fragment;
        }
        if (fragment.getClass() == LastFragment.class ){
            lastFragment = (LastFragment) fragment;
        }
    }

}
