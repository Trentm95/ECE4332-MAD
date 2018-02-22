package codes.trent.travelguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = (ImageView) findViewById(R.id.large_place_image);

        // Retrieve Image from Intent and display it.
        Intent intent = getIntent();
        int image = intent.getIntExtra("Small_Image",0);
        imageView.setImageResource(image);
    }
}
