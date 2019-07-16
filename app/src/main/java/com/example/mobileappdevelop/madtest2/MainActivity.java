package com.example.mobileappdevelop.madtest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView questionNoTV, rangeTV, randomTV;
    EditText inputEt;
    Button submitBth;
    int count;
    int correctAns;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionNoTV = findViewById(R.id.questionNoId);
        rangeTV = findViewById(R.id.rangeId);
        inputEt = findViewById(R.id.inputNumberId);
        randomTV = findViewById(R.id.randomNoTVId);
        submitBth = findViewById(R.id.submitBtnId);

        count = 1;
        correctAns = 0;

        /*Random random = new Random();
        int quesNo = 1;
        int number = random.nextInt(101);

        int minRange = (number/10) * 10;

        String stringCount = Integer.toString(count);

        questionNoTV.setText("Question Number : "+ stringCount + "/ 10");
        randomTV.setText(Integer.toString(number));
        rangeTV.setText(Integer.toString(minRange)+ " - " +Integer.toString(minRange+ 10));

        *//*startExam();*/

        startExam();

        submitBth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(count > 0 ){

                    String strInput = inputEt.getText().toString();
                    if(strInput.isEmpty()){
                        inputEt.setError("Enter number");
                    }else {
                        count++;
                        int input = Integer.parseInt(strInput);
                        Log.e("Number = ",String.valueOf(number) +" Input ="+ String.valueOf(input));
                        //Log.e("Input",String.valueOf(input));
                        if(number == input){
                            correctAns++;
                        }
                        inputEt.setText("");
                        startExam();
                        if(count > 10) {
                            Toast.makeText(MainActivity.this, "Correct Answer = "
                                    + correctAns, Toast.LENGTH_SHORT).show();
                            count = 0;
                        }
                    }
                }



            }
        });





    }

    private void startExam(){

        Random random = new Random();
        int quesNo = 1;
        number = random.nextInt(101);

        int minRange = (number/10) * 10;

        String stringCount = Integer.toString(count);
        if (count > 10 ){
            stringCount = "1";
        }

        questionNoTV.setText("Question Number : "+ stringCount + "/ 10");
        randomTV.setText(Integer.toString(number));
        rangeTV.setText(Integer.toString(minRange)+ " - " +Integer.toString(minRange+ 10));

       /* String strInput = inputEt.getText().toString();
        if(strInput.isEmpty()){
            inputEt.setError("Enter number");
        }else {
            int input = Integer.parseInt(strInput);
            Log.e("Number",String.valueOf(number));
            Log.e("Input",String.valueOf(input));
            if(number == input){
                correctAns++;
            }
            inputEt.setText("");
        }*/






    }
}
