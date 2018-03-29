package codes.trent.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    public TextView display;
    private String equation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Plumbing for TextView
        display = findViewById(R.id.display);
    }

    public void buttonPress(View view){
        // Handle press based on button
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
                equation += "*";
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
                equation = solve(equation);
                break;
        }
        display.setText(equation);
    }

    public String solve(String eq){
        String postfix = postfix(eq);
        Stack<Double> stack = new Stack<>();
        String solution = "";

        for (Character ch: postfix.toCharArray()) {
            double temp1, temp2;
            switch (ch) {
                // If char is an operator pop stack twice and do operation
                case '+':
                    if(stack.size() >= 2){
                        temp1 = stack.pop();
                        temp2 = stack.pop();
                        stack.push(temp2 + temp1);
                    }
                    break;
                case '-':
                    if(stack.size() >= 2){
                        temp1 = stack.pop();
                        temp2 = stack.pop();
                        stack.push(temp2 - temp1);
                    }
                    break;
                case '/':
                    if(stack.size() >= 2){
                        temp1 = stack.pop();
                        temp2 = stack.pop();
                        stack.push(temp2 / temp1);
                    }
                    break;
                case '*':
                    if(stack.size() >= 2){
                        temp1 = stack.pop();
                        temp2 = stack.pop();
                        stack.push(temp2 * temp1);
                    }
                    break;
                default: // If stack is an operand push to stack
                    stack.push(Double.parseDouble(ch.toString()));
                    break;
            }
        }

        // Remaining char is answer
        if (!stack.empty()){
            solution = stack.pop().toString();
        }

        return solution;
    }

    public String postfix(String infix) {
        String out = "";
        Stack<Character> stack = new Stack<>();

        for (char ch: infix.toCharArray()) {
            if(ch == '/' || ch == '*' || ch == '+' || ch == '-'){
                while(!stack.empty() && priority(stack.peek()) > priority(ch) ){ // Pop until lower priority is found
                    out += stack.pop();
                }
                stack.push(ch); // Push current symbol
            }
            else if ( ch == '(') { // Left parenthesis is always pushed on stack
                stack.push(ch);
            }
            else if ( ch == ')') { // Pop until matching parenthesis is found (Don't output parenthesis)
                while(!stack.empty() && stack.peek() != '(' ){
                    out += stack.pop();
                }
                if(!stack.empty()){
                    stack.pop();
                }
            }
            else if (ch == '.') { // Decimals not supported clear input
                return "";
            }
            else {
                out += ch;
            }
        }
        // Pop remaining stack to output
        while (!stack.empty()){
            if(stack.peek() == '(' || stack.peek() == ')'){
                stack.pop();
            }
            else { // Don't output parenthesis
                out += stack.pop();
            }
        }
        return out;
    }

    public int priority(char sym){
        // Operator Priority
        int pr = 0;

        if(sym == '*' || sym == '/'){
            pr = 2;
        }
        else if(sym == '-' || sym == '+'){
            pr = 1;
        }
        else if(sym == '('){ // Lowest priority to prevent pop by anything but right parenthesis
            pr = -1;
        }

        return pr;
    }
}
