package codes.trent.travelguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView nameView;
    TextView detailsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        imageView = (ImageView) findViewById(R.id.imageView);
        nameView = (TextView) findViewById(R.id.name);
        detailsView = (TextView) findViewById(R.id.details);


        // Get intent data
        Intent intent = getIntent();
        int image = intent.getIntExtra("Large_Image",0);
        String name = intent.getStringExtra("Name");
        String details = intent.getStringExtra("Details");

        // Set data in view
        imageView.setImageResource(image);
        nameView.setText(name);
        detailsView.setText(details);
    }
}
