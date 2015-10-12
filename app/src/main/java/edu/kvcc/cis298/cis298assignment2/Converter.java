package edu.kvcc.cis298.cis298assignment2;

/**
 * Created by Marty on 10/8/2015.
 */
public class Converter {

    //Instance Fields
    private double mInputTemp;
    private String mCalc;
    private Double mAnswer;
    private Double answer;
        //Constructor
       public Converter(String calc, Double InputTemp) {
        mInputTemp = InputTemp;
        mCalc = calc;

        DoCalculations();  //Calculations Method
    }
    //Second converter call needed for some screwed up reason
    public Converter() {
    }

    public double getInputTemp() {
        return mInputTemp;
    }
        //A little confused by this. Generated Studio get & set ???
    public void setInputTemp(double inputTemp) {
        mInputTemp = inputTemp;
    }

    public String getCalc() {
        return mCalc;
    }

    public void setCalc(String calc) {
        mCalc = calc;
    }

    public Double getAnswer() {
        return mAnswer;
    }

    public void setAnswer(Double answer) {
        mAnswer = answer;
    }



    private void DoCalculations()  //Do calculations and assign formula string to mCalc
    {

        switch (mCalc) {  //Calculations
            case "c2f":
                mAnswer = (mInputTemp * 9/5) + 32;
                mCalc = "[°F] = ([°C] x 9/5) + 32";
                break;
            case "c2k":
                mAnswer = (mInputTemp + 273.15);
                mCalc = "[K°] = ([°C] + 273.15)";
                break;
            case "c2r":
                mAnswer = (mInputTemp * 1.8 + 32 + 459.67);
                mCalc = "[R°] = ([C°] x 1.8 + 32 + 459.67)";
                break;
            case "f2c":
                mAnswer = ((mInputTemp - 32) / (1.8));
                mCalc = "[C°] = ([F°] - 32) / 1.8";
                break;
            case "f2k":
                mAnswer = (( mInputTemp + 459.67) / (1.8));
                mCalc = "[K°] = ([F°] + 459.67) / 1.8)";
                break;
            case "f2r":
                mAnswer = (mInputTemp + 459.67);
                mCalc = "[R°] = ([F°] + 459.67)";
                break;
            case "k2c":
                mAnswer = (mInputTemp - 273.15);
                mCalc = "[C°] = ([K°] - 273.15)";
                break;
            case "k2f":
                mAnswer = (mInputTemp * 1.8 - 459.67);
                mCalc = "[F°] = ([K°] x 1.8 - 459.67)";
                break;
            case "k2r":
                mAnswer = (mInputTemp * 1.8);
                mCalc = "[R°] = ([K°] x 1.8)";
                break;
            case "r2c":
                mAnswer = (( mInputTemp - 32 - 459.67) / (1.8));
                mCalc = "[C°] = ([R°] - 32 - 459.67) / 1.8";
                break;
            case "r2f":
                mAnswer = (mInputTemp - 459.67);
                mCalc = "[F°] = ([R°] - 459.67)";
                break;
            case "r2k":
                mAnswer = (mInputTemp / 1.8);
                mCalc = "[K°] = ([R°] / 1.8)";
                break;
        }


    }

    }

