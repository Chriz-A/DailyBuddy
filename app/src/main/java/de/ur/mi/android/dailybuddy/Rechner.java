package de.ur.mi.android.dailybuddy;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chris on 23.08.2016.
 */
public class Rechner extends AppCompatActivity {

    private TextView output;

    private Button button_0;
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;

    private Button button_divided;
    private Button button_multiplied;
    private Button button_minus;
    private Button button_plus;
    private Button button_point;
    private Button button_equals;
    private Button button_allClear;

    private double num1;
    private double num2;

    private boolean plus;
    private boolean minus;
    private boolean divided;
    private boolean multiplied;

    private ArrayList<Object> input = new ArrayList<Object>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rechner);
        output = (TextView) findViewById(R.id.output);
        setButtons();
        clickButtons();
        ActionBar ab = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#381938"));
        ab.setBackgroundDrawable(colorDrawable);


    }

    private void clickButtons() {
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
               output.setText(output.getText()+"0");
                input.add(0);
            }
        });
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"1");
                input.add(1);
            }
        });
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"2");
                input.add(2);
            }
        });
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"3");
                input.add(3);
            }
        });
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"4");
                input.add(4);
            }
        });
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"5");
                input.add(5);
            }
        });
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"6");
                input.add(6);
            }
        });
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"7");
                input.add(7);
            }
        });
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"8");
                input.add(8);
            }
        });
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"9");
                input.add(9);
            }
        });
        button_divided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (output.getText() != "") {
                    output.setText(output.getText() + "/");
                    input.add("/");
                }
            }
        });
        button_multiplied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (output.getText() != "") {
                    output.setText(output.getText() + "x");
                    input.add("x");
                }
            }
        });
        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"-");
                input.add("-");
            }
        });
        button_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (output.getText() != "") {
                    output.setText(output.getText() + ".");
                    input.add(".");
                }
            }
        });
        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (output.getText() != "") {
                    output.setText(output.getText() + "+");
                    input.add("+");
                }
            }
        });
        button_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                calculate(output);

            }
        });

        button_allClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText("");
            }
        });

    }

    private void calculate(TextView output) {

      /**  for (int i = 0; i < input.size(); i++ ) {
            if (input.get(i).equals("/")){
                int result = (int) input.get(i-1) / (int) input.get(i+1);
                output.setText(String.valueOf(result));
            } //else if(calculator.charAt(i) == 'x'){

            //}
        }*/

         String calculator = output.getText().toString();
        String numberOne = "";
        String numberTwo = "";
        double firstNumber = 0;
        double secondNumber = 0;

         for (int i = 0; i < calculator.length(); i++ ) {
             if (calculator.charAt(i) == '/'){
                 for (int j = 0; j < i; j++){
                     char ch = calculator.charAt(j);

                     if (Character.isDigit(ch) || ch == '.'){
                          numberOne = numberOne + calculator.charAt(j);
                     }
                 }
                 firstNumber = Double.parseDouble(numberOne);
                 for (int k = i+1; k < calculator.length(); k++){
                     char ch2 = calculator.charAt(k);

                     if (Character.isDigit(ch2) || ch2 == '.'){
                         numberTwo = numberTwo + calculator.charAt(k);

                     }
                 }
                 secondNumber = Double.parseDouble(numberTwo);
                 double result = firstNumber/secondNumber;
                 if (result % 1 == 0) {
                     int resultInt = (int) result;
                     output.setText(String.valueOf(resultInt));
                 } else {
                     output.setText(String.valueOf(result));
                 }
               // int result = Character.getNumericValue(calculator.charAt(i-1)) / Character.getNumericValue(calculator.charAt(i+1));
                //int result = Integer.parseInt(Character.toString(calculator.charAt(i-1))) / Integer.parseInt(Character.toString(calculator.charAt(i+1)));
             } //else if(calculator.charAt(i) == 'x'){

             //}
             if (calculator.charAt(i) == 'x') {
                 for (int j = 0; j < i; j++) {
                     char ch = calculator.charAt(j);

                     if (Character.isDigit(ch) || ch == '.') {
                         numberOne = numberOne + calculator.charAt(j);
                     }
                 }
                 firstNumber = Double.parseDouble(numberOne);
                 for (int k = i + 1; k < calculator.length(); k++) {
                     char ch2 = calculator.charAt(k);

                     if (Character.isDigit(ch2) || ch2 == '.') {
                         numberTwo = numberTwo + calculator.charAt(k);

                     }
                 }
                 secondNumber = Double.parseDouble(numberTwo);
                 double result = firstNumber * secondNumber;
                 if (result % 1 == 0) {
                     int resultInt = (int) result;
                     output.setText(String.valueOf(resultInt));
                 } else {
                     output.setText(String.valueOf(result));
                 }
             }

             if (calculator.charAt(i) == '+') {
                 for (int j = 0; j < i; j++) {
                     char ch = calculator.charAt(j);

                     if (Character.isDigit(ch) || ch == '.') {
                         numberOne = numberOne + calculator.charAt(j);
                     }
                 }
                 firstNumber = Double.parseDouble(numberOne);
                 for (int k = i + 1; k < calculator.length(); k++) {
                     char ch2 = calculator.charAt(k);

                     if (Character.isDigit(ch2) || ch2 == '.') {
                         numberTwo = numberTwo + calculator.charAt(k);

                     }
                 }
                 secondNumber = Double.parseDouble(numberTwo);
                 double result = firstNumber + secondNumber;
                 if (result % 1 == 0) {
                     int resultInt = (int) result;
                     output.setText(String.valueOf(resultInt));
                 } else {
                     output.setText(String.valueOf(result));
                 }
             }

             if (calculator.charAt(i) == '-') {
                 for (int j = 0; j < i; j++) {
                     char ch = calculator.charAt(j);

                     if (Character.isDigit(ch) || ch == '.') {
                         numberOne = numberOne + calculator.charAt(j);
                     }
                 }
                 firstNumber = Double.parseDouble(numberOne);
                 for (int k = i + 1; k < calculator.length(); k++) {
                     char ch2 = calculator.charAt(k);

                     if (Character.isDigit(ch2) || ch2 == '.') {
                         numberTwo = numberTwo + calculator.charAt(k);

                     }
                 }
                 secondNumber = Double.parseDouble(numberTwo);
                 double result = firstNumber - secondNumber;
                 if (result % 1 == 0) {
                     int resultInt = (int) result;
                     output.setText(String.valueOf(resultInt));
                 } else {
                     output.setText(String.valueOf(result));
                 }
             }
         }


    }

    private void setButtons() {
        button_0 = (Button) findViewById(R.id.button_0);
        button_1 = (Button) findViewById(R.id.button_1);
        button_2 = (Button) findViewById(R.id.button_2);
        button_3 = (Button) findViewById(R.id.button_3);
        button_4 = (Button) findViewById(R.id.button_4);
        button_5 = (Button) findViewById(R.id.button_5);
        button_6 = (Button) findViewById(R.id.button_6);
        button_7 = (Button) findViewById(R.id.button_7);
        button_8 = (Button) findViewById(R.id.button_8);
        button_9 = (Button) findViewById(R.id.button_9);

        button_divided = (Button) findViewById(R.id.button_divided);
        button_multiplied = (Button) findViewById(R.id.button_multiplied);
        button_minus = (Button) findViewById(R.id.button_minus);
        button_plus = (Button) findViewById(R.id.button_plus);
        button_point = (Button) findViewById(R.id.button_point);
        button_equals = (Button) findViewById(R.id.button_equals);
        button_allClear =(Button) findViewById(R.id.button_allClear);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.home) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.kalenderansicht_abrufen) {
            Intent i = new Intent(this, Kalender.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.notizfunktion_aufrufen) {
            Intent i = new Intent(this, Notizen.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.wetterinformationen_abrufen) {
            Intent i = new Intent(this, Wetter.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.rechnerfunktion_aufrufen) {
            Intent i = new Intent(this, Rechner.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.stopwatch) {
            Intent i = new Intent(this, StopWatch.class);
            startActivity(i);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
