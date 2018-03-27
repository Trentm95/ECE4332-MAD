package codes.trent.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView display;
    private String equation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
    }

    public void buttonPress(View view){
        switch (view.getId()) {
            case R.id.button0:
                equation += "0";
                break;
            case R.id.button1:
                equation += "1";
                break;
            case R.id.button2:
                equation += "2";
                break;
            case R.id.button3:
                equation += "3";
                break;
            case R.id.button4:
                equation += "4";
                break;
            case R.id.button5:
                equation += "5";
                break;
            case R.id.button6:
                equation += "6";
                break;
            case R.id.button7:
                equation += "7";
                break;
            case R.id.button8:
                equation += "8";
                break;
            case R.id.button9:
                equation += "9";
                break;
            case R.id.buttonDiv:
                equation += "/";
                break;
            case R.id.buttonMul:
                equation += "x";
                break;
            case R.id.buttonSub:
                equation += "-";
                break;
            case R.id.buttonAdd:
                equation += "+";
                break;
            case R.id.buttonParL:
                equation += "(";
                break;
            case R.id.buttonParR:
                equation += ")";
                break;
            case R.id.buttonClear:
                equation = "";
                break;
            case R.id.buttonBack:
                if(equation.length() > 0){
                    equation = equation.substring(0, equation.length() - 1);
                }
                break;
            case R.id.buttonEq:
                break;
        }
        display.setText(equation);
    }
}
