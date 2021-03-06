package edu.kvcc.cis298.cis298assignment2;
//Marty Russon & special thanks to Dawn Pantaleo for her weekend help
//Temperature Converter : Assignment 2
//CIS298 M-W 2:00PM
//Instructor: Dave Barnes
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class TemperatureConverter extends AppCompatActivity {

///*************INPUT VARIABLES**************//
    EditText enterTempText;
    RadioGroup radioGroup_Left;
    RadioGroup radioGroup_Right;

    public TextView mResult;


    Button convert_Button;

    //********Instance State Save Variables & Output**********//

    private String answerString;
    public String outputFormula;
    private TextView mOutputFormula;

//*******Formula Scale identifiers*************//
    public String outID;
    public String inID;

    private static final String TAG = "TemperatureConverter";

    //**********Create Class************//
    Converter ConvertedTempInstance = new Converter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "OnCreate() called");
        setContentView(R.layout.activity_temperature_converter);

        //*******Entered value to convert***********//
        enterTempText = (EditText) findViewById(R.id.EnterTempText);

        //Initialize Radio Groups and attach click handler
        radioGroup_Left = (RadioGroup) findViewById(R.id.radioGroup_Left);
        radioGroup_Left.clearCheck();
        radioGroup_Right = (RadioGroup) findViewById(R.id.radioGroup_Right);
        radioGroup_Right.clearCheck();

        mResult = (TextView) findViewById(R.id.tempOutputLabel);
        //mOutputFormula =  findViewById(R.id.formula_Output);
        mOutputFormula = (TextView) findViewById(R.id.formula_Output);
        //********Instance State for rotation************//
        if (savedInstanceState != null){
            answerString = savedInstanceState.getString("theKey", "");
            mResult.setText(answerString);

            outputFormula = savedInstanceState.getString("secondKey", "");
            mOutputFormula.setText(outputFormula);
            Log.d(TAG, "Oops Rotation Error");
        }



        //*********OnClick Listener***********************//
        convert_Button = (Button) findViewById(R.id.convert_Button);
        convert_Button.setOnClickListener(new View.OnClickListener() {

            //*********************OnClick Event********************//
            @Override
            public void onClick(View v) {

                EditText EnterTemp = (EditText) findViewById(R.id.EnterTempText); //Assign text field ID to EnterText text field
                if (EnterTemp.getText().toString().trim().length() == 0)  {   ///Check for empty text field

                    Toast.makeText(TemperatureConverter.this, "Enter A  Valid Number", Toast.LENGTH_SHORT).show(); //Toast empty text field

                }
                else
                {
                    String stringInputTemp = EnterTemp.getText().toString();  //Assign entered text value and cast as string to variable

                            //Assign id value from both radio groups selected button id
                    final String mFromString = ((RadioButton) findViewById(radioGroup_Left.getCheckedRadioButtonId())).getText().toString();
                    final String mToString = ((RadioButton) findViewById(radioGroup_Right.getCheckedRadioButtonId())).getText().toString();

                    if (mFromString == mToString){  //Test to see if conversions radio groups are equal. If they are give toast and halt
                        Toast.makeText(TemperatureConverter.this, "No Conversion", Toast.LENGTH_SHORT).show(); //Toast no conversion
                    }
                    else {

                        double mInputTemp = Double.parseDouble(stringInputTemp);  //parse string input temp to a double for math

                        /*
                        The following decision statement will determine what each radio group values are assigned dependent upon radio buttons
                        selected. It then compares strings in the decision tree ultimately instantiating the converter class and sending arguments
                        to the class returning the calculation
                         */
                        if (mFromString.equals("Celsius")) {        //Check if left radio group value is Celsius
                            inID = "\u2103";        //Unicode Variable for input scale identifier for Celsius
                            switch (mToString) {    //Test 2nd radio group values
                                case "Fahrenheit":
                                    ConvertedTempInstance = new Converter("c2f", mInputTemp); //calls converter class with arguments
                                    outID = "\u2109";  //Unicode Variable for output scale identifier for Fahrenheit
                                    break;
                                case "Kelvin":
                                    ConvertedTempInstance = new Converter("c2k", mInputTemp);  //calls converter class with arguments
                                    outID = "°K"; //Variable for output scale identifier for Kelvin
                                    break;
                                case "Rankine":
                                    ConvertedTempInstance = new Converter("c2r", mInputTemp);  //calls converter class with arguments
                                    outID = "°R"; //Variable for output scale identifier for Rankin
                                    break;

                            }

                        } else {
                            if (mFromString.equals("Fahrenheit")) {
                                inID = "\u2109";   //Unicode Variable for output scale identifier for Fahrenheit
                                switch (mToString) {  //Test 2nd radio group values
                                    case "Celsius":
                                        ConvertedTempInstance = new Converter("f2c", mInputTemp);  //calls converter class with arguments
                                        outID = "\u2103"; //Unicode Variable for output scale identifier for Celsius
                                        break;
                                    case "Kelvin":
                                        ConvertedTempInstance = new Converter("f2k", mInputTemp);  //calls converter class with arguments
                                        outID = "°K"; //Variable for output scale identifier for Kelvin
                                        break;
                                    case "Rankine":
                                        ConvertedTempInstance = new Converter("f2r", mInputTemp);  //calls converter class with arguments
                                        outID = "°R";  //Variable for output scale identifier for Rankin
                                        break;
                                }
                            } else {
                                if (mFromString.equals("Kelvin")) {
                                    inID = "°K";  //Variable for input scale identifier for Kelvin
                                    switch (mToString) {  //Test 2nd radio group values
                                        case "Celsius":
                                            ConvertedTempInstance = new Converter("k2c", mInputTemp);
                                            outID = "\u2103";  //Unicode Variable for output scale identifier for Celsius
                                            break;
                                        case "Fahrenheit":
                                            ConvertedTempInstance = new Converter("k2f", mInputTemp);
                                            outID = "\u2109";  //Unicode Variable for output scale identifier for Fahrenheit
                                            break;
                                        case "Rankine":
                                            ConvertedTempInstance = new Converter("k2r", mInputTemp);
                                            outID = "°R";  //Variable for output scale identifier for Rankin
                                            break;
                                    }
                                } else {

                                    inID = "°R"; //Variable for input scale identifier for Rankin
                                    switch (mToString) {  //Test 2nd radio group values
                                        case "Celsius":
                                            ConvertedTempInstance = new Converter("r2c", mInputTemp);
                                            outID = "\u2103"; //Unicode Variable for input scale identifier for Celsius
                                            break;
                                        case "Fahrenheit":
                                            ConvertedTempInstance = new Converter("r2f", mInputTemp);
                                            outID = "\u2109"; //Unicode Variable for input scale identifier for Fahrenheit
                                            break;
                                        case "Kelvin":
                                            ConvertedTempInstance = new Converter("r2k", mInputTemp);
                                            outID = "°R"; //Variable for input scale identifier for Celsius
                                            break;

                                    }

                                }
                            }
                        }

                        Double outputConvertedTemp = ConvertedTempInstance.getAnswer();    // ConvertedTempInstance.getCalc()
                        outputFormula = ConvertedTempInstance.getCalc();     //casting to string the returned formula
                        DecimalFormat decimalFormat = new DecimalFormat("#0.0");    //Casts and formats the returned calculated value

                        String outputTemp = decimalFormat.format(outputConvertedTemp); //Assigns converted temp to outputTemp variable

                        TextView formula = (TextView) findViewById(R.id.formula_Output);  //gets TextView id info for output of formula
                        answerString = mInputTemp + inID + " = " + outputTemp + outID;
                        mResult.setText(answerString); //outputs input number and answer with scale formatting values

                        formula.setText(outputFormula);  //outputs formula used for calculation
                    }
                }
            }

        });

    }

    @Override
    protected  void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


        outState.putString("theKey", answerString);
        outState.putString("secondKey", outputFormula);
       Log.d(TAG, "onSaveInstanceState");
    }


}
