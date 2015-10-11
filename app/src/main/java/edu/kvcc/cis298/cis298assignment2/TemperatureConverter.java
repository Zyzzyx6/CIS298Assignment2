package edu.kvcc.cis298.cis298assignment2;
//Marty Russon & special thanks to Dawn Pantaleo
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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


    EditText enterTempText;
    RadioGroup radioGroup_Left;
    RadioGroup radioGroup_Right;
    public RadioButton rb_l;
    public RadioButton rb_r;
    Button convert_Button;
    public double answer;
    TextView mAnswerTextView;
    private String OutputTemp;
    private int mInputType;
    public String outID;
    public String inID;
    Converter ConvertedTempInstance = new Converter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);
        enterTempText = (EditText) findViewById(R.id.EnterTempText);

        //Initialize Radio Groups and attach click handler
        radioGroup_Left = (RadioGroup) findViewById(R.id.radioGroup_Left);
        radioGroup_Left.clearCheck();
        radioGroup_Right = (RadioGroup) findViewById(R.id.radioGroup_Right);
        radioGroup_Right.clearCheck();

        convert_Button = (Button) findViewById(R.id.convert_Button);
        convert_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText EnterTemp = (EditText) findViewById(R.id.EnterTempText);
                String stringInputTemp = EnterTemp.getText().toString();


                final String mFromString = ((RadioButton) findViewById(radioGroup_Left.getCheckedRadioButtonId())).getText().toString();
                final String mToString = ((RadioButton) findViewById(radioGroup_Right.getCheckedRadioButtonId())).getText().toString();

                double mInputTemp = Double.parseDouble(stringInputTemp);
                //
//                if (mFromString == mToString ) //Check if both sides are equal
//                {
//                    Toast.makeText(TemperatureConverter.this, "No Conversion", Toast.LENGTH_SHORT).show();
//                }


                if (mFromString.equals("Celsius")) {
                    inID = "\u2103";
                    switch (mToString) {
                        case "Fahrenheit":
                            ConvertedTempInstance = new Converter("c2f", mInputTemp);
                            outID = "\u2109";
                            break;
                        case "Kelvin":
                            ConvertedTempInstance = new Converter("c2k", mInputTemp);
                            outID = "°K";
                            break;
                        case "Rankin":
                            ConvertedTempInstance = new Converter("c2r", mInputTemp);
                            outID = "°R";
                            break;
                    }

                } else {
                    if (mFromString.equals("Fahrenheit")) {
                        inID = "\u2109";
                        switch (mToString) {
                            case "Celsius":
                                ConvertedTempInstance = new Converter("f2c", mInputTemp);
                                outID = "\u2103";
                                break;
                            case "Kelvin":
                                ConvertedTempInstance = new Converter("f2k", mInputTemp);
                                outID = "°K";
                                break;
                            case "Rankin":
                                ConvertedTempInstance = new Converter("f2r", mInputTemp);
                                outID = "°R";
                                break;
                        }
                    } else {
                        if (mFromString.equals("Kelvin")) {
                            inID = "°K";
                            switch (mToString) {
                                case "Celsius":
                                    ConvertedTempInstance = new Converter("k2c", mInputTemp);
                                    outID = "\u2103";
                                    break;
                                case "Fahrenheit":
                                    ConvertedTempInstance = new Converter("k2f", mInputTemp);
                                    outID = "\u2109";
                                    break;
                                case "Rankin":
                                    ConvertedTempInstance = new Converter("k2r", mInputTemp);
                                    outID = "°R";
                                    break;
                            }
                        } else {

//                            if (mFromString.equals("Rankin")){
//
//                            }
//                            else
//                            {
//                                TextView result = (TextView) findViewById(R.id.formula_Output);
//                                result.setText("Got Here");
//                            }

                                switch (mToString) {
                                    case "Celsius":
                                        ConvertedTempInstance = new Converter("r2c", mInputTemp);
                                        break;
                                    case "Fahrenheit":
                                        ConvertedTempInstance = new Converter("r2f", mInputTemp);
                                        break;
                                    case "Kelvin":
                                        ConvertedTempInstance = new Converter("r2k", mInputTemp);
                                        break;

                                }
                            TextView result = (TextView) findViewById(R.id.formula_Output);
//                                result.setText(mFromString);
                        }
                    }
                }
//                if (mToString.equals("Fahrenheit")){
//                    String Chr =  "\u2109";
//
//                }
//                else if (mToString.equals("Celsius")){
//                    String Chr = "\u2103";
//
//                }
//                else if (mToString.equals("Kelvin")){
//                    String Chr = "\u212a";
//                }
//                else if (mToString.equals("Rankin")){
//                    String Chr = "°R";
//                }
                Double outputConvertedTemp = ConvertedTempInstance.getAnswer();    // + ConvertedTempInstance.getCalc()
                String outputFormula = ConvertedTempInstance.getCalc();
                DecimalFormat decimalFormat = new DecimalFormat("#0.0");

                String outputTemp = decimalFormat.format(outputConvertedTemp);

                TextView result = (TextView) findViewById(R.id.tempOutputLabel);
                TextView formula = (TextView) findViewById(R.id.formula_Output);

                result.setText(mInputTemp + inID +" = " + outputTemp + outID);
                formula.setText(outputFormula);
            }

        });

    }


}
