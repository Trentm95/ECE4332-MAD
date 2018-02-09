package codes.trent.colorchangeapp;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Pipe for main_layout
        mainLayout = findViewById(R.id.main_layout);

    }

    public void changeColor(View view){

        // Set background based on button pressed.
        switch (view.getId()) {
            case R.id.blue_button:
                mainLayout.setBackgroundColor(getResources().getColor(R.color.BLUE));
                break;
            case R.id.green_button:
                mainLayout.setBackgroundColor(getResources().getColor(R.color.GREEN));
                break;
            case R.id.red_button:
                mainLayout.setBackgroundColor(getResources().getColor(R.color.RED));
                break;
            case R.id.yellow_button:
                mainLayout.setBackgroundColor(getResources().getColor(R.color.YELLOW));
                break;
        }

    }

}
