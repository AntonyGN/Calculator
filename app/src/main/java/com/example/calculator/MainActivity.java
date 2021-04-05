package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Screen;
    private Button AC,Power,Back,Div,Mul,Add,Min,One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Zero,Equal,Point;
    private String input,Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen = findViewById(R.id.screen);
        AC = findViewById(R.id.ac);
        Power = findViewById(R.id.power);
        Back = findViewById(R.id.back);
        Div = findViewById(R.id.div);
        Mul = findViewById(R.id.mul);
        Add = findViewById(R.id.add);
        Min = findViewById(R.id.min);
        One = findViewById(R.id.one);
        Two = findViewById(R.id.two);
        Three = findViewById(R.id.three);
        Four = findViewById(R.id.four);
        Five = findViewById(R.id.five);
        Six = findViewById(R.id.six);
        Seven = findViewById(R.id.seven);
        Eight = findViewById(R.id.eight);
        Nine = findViewById(R.id.nine);
        Zero = findViewById(R.id.zero);
        Equal = findViewById(R.id.equal);
        Point = findViewById(R.id.point);
    }
    //add onClick listener for each button
    public void ButtonClick(View view){
        Button button=(Button) view;
        String data=button.getText().toString();
        switch (data){
            case"AC":
                input="";
                break;
            case "x":
                input+="*";
                break;
            case "^":
                Solve();
                input+="^";
                break;
            case "=":
                Solve();
                Answer=input;
                break;
            case "DEL":
                String newText=input.substring(0,input.length()-1);
                input=newText;
                break;
            default:
                if (input==null){
                    input="";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/")){
                    Solve();
                }
                input+=data;

        }
        Screen.setText(input);
    }
    private void Solve(){
        if (input.split("\\*").length==2){
            String number[]=input.split("\\*");
            try{
            double mul=Double.parseDouble(number[0])*Double.parseDouble(number[1]);
            input = mul+"";
        }
            catch (Exception e){
                //Toggle error
            }

            }

        else if (input.split("/").length==2){
            String number[]=input.split("/");
            try{
                double div=Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                input = div+"";
            }
            catch (Exception e){
                //Toggle error
            }

        }

        else if (input.split("\\^").length==2){
            String number[]=input.split("\\^");
            try{
                double pow = Math.pow (Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                input =pow+"";
            }
            catch (Exception e){
                //Toggle error
            }

        }

        else if (input.split("\\+").length==2){
            String number[]=input.split("\\+");
            try{
                double sum = (Double.parseDouble(number[0]) + Double.parseDouble(number[1]));
                input =sum+"";
            }
            catch (Exception e){
                //Toggle error
            }

        }

        else if (input.split("-").length>1) {
            String number[] = input.split("-");
            //to subtract from negative number like -5-8
            if (number[0] == "" && number.length == 2) {
                number[0] = 0 + "";

            }
            try {
                double sub = 0;
                if (number.length == 2) {
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);

                } else if (number.length == 3) {
                    sub = -Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }
                input = sub + "";
            }
            catch (Exception e){
                //toggle error
            }



        }
        //to remove the last digit.0 from integer result like 9 instead of 9.0
        String n[]=input.split("\\.");
        if (n.length>1){
            if (n[1].equals("0")){
                input=n[0];

            }
        }
        Screen.setText(input);
    }
}
