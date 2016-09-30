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
    private Button button_back;

    private Button button_square;
    private Button button_root;
    private Button button_percent;

    private boolean setPoint = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rechner);
        output = (TextView) findViewById(R.id.output);
        setButtons();
        clickButtons();
        setActionBarColor();
    }

    private void setActionBarColor() {
        ActionBar ab = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor(getResources().getString(0+R.color.purple)));
        ab.setBackgroundDrawable(colorDrawable);
    }

    private void clickButtons() {
        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
               output.setText(output.getText()+"0");
            }
        });
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"1");
            }
        });
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"2");
            }
        });
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"3");
            }
        });
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"4");
            }
        });
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"5");
            }
        });
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"6");
            }
        });
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"7");
            }
        });
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"8");
            }
        });
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText(output.getText()+"9");
            }
        });
        button_divided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String textOutput = output.getText().toString();
                int counter = 0;
                if (output.getText() != "" ) {
                    for (int i = 0; i < textOutput.length(); i++) {
                        if (textOutput.charAt(i) == '-' || textOutput.charAt(i) == '+' || textOutput.charAt(i) == '/' || textOutput.charAt(i) == 'x') {
                            counter++;
                        }
                    }
                    if (counter == 0){
                        char ch = textOutput.charAt(textOutput.length() - 1);
                        if (Character.isDigit(ch)) {
                            output.setText(output.getText() + "/");
                            setPoint = false;
                        }
                    }

                }
            }
        });
        button_multiplied.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String textOutput = output.getText().toString();
                int counter = 0;
                if (output.getText() != "" ) {
                    for (int i = 0; i < textOutput.length(); i++) {
                        if (textOutput.charAt(i) == '-' || textOutput.charAt(i) == '+' || textOutput.charAt(i) == '/' || textOutput.charAt(i) == 'x') {
                            counter++;
                        }
                    }
                        if (counter == 0){
                            char ch = textOutput.charAt(textOutput.length() - 1);
                            if (Character.isDigit(ch)) {
                                output.setText(output.getText() + "x");
                                setPoint = false;
                            }
                        }

                }
            }
        });
        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String textOutput = output.getText().toString();
                int counter = 0;
                if (output.getText() != "" ) {
                    for (int i = 0; i < textOutput.length(); i++) {
                        if (textOutput.charAt(i) == '-' || textOutput.charAt(i) == '+' || textOutput.charAt(i) == '/' || textOutput.charAt(i) == 'x') {
                            counter++;
                        }
                    }
                    if (counter == 0){
                        char ch = textOutput.charAt(textOutput.length() - 1);
                        if (Character.isDigit(ch)) {
                            output.setText(output.getText() + "-");
                            setPoint = false;
                        }
                    }

                }
            }
        });
        button_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (output.getText() != "") {
                    String textOutput = output.getText().toString();
                    char ch =  textOutput.charAt(textOutput.length()-1);
                    if ( Character.isDigit(ch) && !setPoint) {
                        output.setText(output.getText() + ".");
                        setPoint = true;
                    }
                }
            }
        });
        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String textOutput = output.getText().toString();
                int counter = 0;
                if (output.getText() != "" ) {
                    for (int i = 0; i < textOutput.length(); i++) {
                        if (textOutput.charAt(i) == '-' || textOutput.charAt(i) == '+' || textOutput.charAt(i) == '/' || textOutput.charAt(i) == 'x') {
                            counter++;
                        }
                    }
                    if (counter == 0){
                        char ch = textOutput.charAt(textOutput.length() - 1);
                        if (Character.isDigit(ch)) {
                            output.setText(output.getText() + "+");
                            setPoint = false;
                        }
                    }

                }
            }
        });
        button_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String textOutput = output.getText().toString();
                int counter = 0;
                char ch = textOutput.charAt(textOutput.length() - 1);
                if (output.getText() != "" ) {
                    for (int i = 0; i < textOutput.length(); i++) {
                        if (textOutput.charAt(i) == '-' || textOutput.charAt(i) == '+' || textOutput.charAt(i) == '/' || textOutput.charAt(i) == 'x') {
                            counter++;
                        }
                    }
                }
                if (counter == 0 ) {
                    calcRoot();
                }
            }
        });
        button_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String textOutput = output.getText().toString();
                int counter = 0;
                char ch = textOutput.charAt(textOutput.length() - 1);
                if (output.getText() != "" ) {
                    for (int i = 0; i < textOutput.length(); i++) {
                        if (textOutput.charAt(i) == '-' || textOutput.charAt(i) == '+' || textOutput.charAt(i) == '/' || textOutput.charAt(i) == 'x') {
                            counter++;
                        }
                    }
                }
                if (counter == 0 ) {
                    calcPercent();
                }
            }
        });
        button_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String textOutput = output.getText().toString();
                int counter = 0;
                char ch = textOutput.charAt(textOutput.length() - 1);
                if (output.getText() != "" ) {
                    for (int i = 0; i < textOutput.length(); i++) {
                        if (textOutput.charAt(i) == '-' || textOutput.charAt(i) == '+' || textOutput.charAt(i) == '/' || textOutput.charAt(i) == 'x') {
                            counter++;
                        }
                    }
                }
                if (counter == 0 ) {
                    calcSquare();
                }
            }
        });
        button_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                calculate(output);
                setPoint = false;

            }
        });

        button_allClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                output.setText("");
                setPoint = false;
            }
        });

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
               String calc = output.getText().toString();
                if (calc.length() > 1) {
                    calc = calc.substring(0, calc.length() - 1);
                    output.setText(calc);
                } else {
                    output.setText("");
                }
            }
        });

    }

    private void calcPercent() {
        String calculator = output.getText().toString();
        double number = Double.parseDouble(calculator);
        double result = number/100;
        if (result % 1 == 0){
            int resultInt = (int) result;
            output.setText(String.valueOf(resultInt));
        } else {
            output.setText(String.valueOf(result));
        }
    }

    private void calcRoot() {
        String calculator = output.getText().toString();
        double number = Double.parseDouble(calculator);
        double result = Math.sqrt(number);
        if (result % 1 == 0){
            int resultInt = (int) result;
            output.setText(String.valueOf(resultInt));
        } else {
            output.setText(String.valueOf(result));
        }
    }

    private void calcSquare() {
        String calculator = output.getText().toString();
        double number = Double.parseDouble(calculator);
        double result = number*number;
        if (result % 1 == 0){
            int resultInt = (int) result;
            output.setText(String.valueOf(resultInt));
        } else {
            output.setText(String.valueOf(result));
        }
    }

    private void calculate(TextView output) {

         String calculator = output.getText().toString();
        String numberOne = "";
        String numberTwo = "";
        double firstNumber;
        double secondNumber;

         for (int i = 0; i < calculator.length(); i++ ) {
             if (calculator.charAt(i) == '/') {
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
                 double result = firstNumber / secondNumber;
                 if (result % 1 == 0) {
                     int resultInt = (int) result;
                     output.setText(String.valueOf(resultInt));
                 } else {
                     output.setText(String.valueOf(result));
                 }
             }


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
        button_back = (Button) findViewById(R.id.backButton);

        button_square = (Button) findViewById(R.id.squareButton);
        button_root = (Button) findViewById(R.id.rootButton);
        button_percent = (Button) findViewById(R.id.percentButton);
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


        switch (id){
            case R.id.home:
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                return true;

            case R.id.kalenderansicht_abrufen:
                i = new Intent(this, Kalender.class);
                startActivity(i);
                return true;

            case R.id.notizfunktion_aufrufen:
                i = new Intent(this, Notizen.class);
                startActivity(i);
                return true;

            case R.id.wetterinformationen_abrufen:
                i = new Intent(this, Wetter.class);
                startActivity(i);
                return true;

            case R.id.rechnerfunktion_aufrufen:
                i = new Intent(this, Rechner.class);
                startActivity(i);
                return true;

            case R.id.stopwatch:
                i = new Intent(this, StopWatch.class);
                startActivity(i);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
