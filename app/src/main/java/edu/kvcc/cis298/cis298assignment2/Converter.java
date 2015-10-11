package edu.kvcc.cis298.cis298assignment2;

/**
 * Created by Marty on 10/8/2015.
 */
public class Converter {

    //Instance Field
    private double mInputTemp;
    private String mCalc;
    private Double mAnswer;
    private Double answer;
        //Constructor
       public Converter(String calc, Double InputTemp) {
        mInputTemp = InputTemp;
        mCalc = calc;

        DoCalculations();
    }

    public Converter() {
    }

    public double getInputTemp() {
        return mInputTemp;
    }

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



    private void DoCalculations()
    {

        switch (mCalc) {
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
    //public
   // public void calc(int InputTemp) {  //convert celsius to fahrenheit
    //    return (InputTemp - 32) * 5 / 9;

   // }

    //  public static double c2f(double cf){
     //       return (cf - 32) * 5/9;
      //  }

//    public static double c2k(double ck){  //convert celsius to kelvin
//        return ck+273.15;
//    }
//    public static double c2r(double cr){  //convert celsius to rankin
//        return (cr+273.15)*9/5;
//    }
//    public static double f2c(double fc){  //convert fahrenheit to celsius
//        return 32+fc*9/5;
//    }
//    public static double f2k(double fk){  //convert fahrenheit to kelvin
//        return (fk+273.15)*9/5;
//    }
//    public static double f2r(double fr){  //convert fahrenheit to rankin
//        return fr+459.67;
//    }
//    public static double k2c(double kc){  //convert kelvin to celsius
//        return kc-273.15;
//    }
//    public static double k2f(double kf){  //convert kelvin to fahrenheit
//        return 1.8*(kf-273.15)+32;
//    }
//    public static double k2r(double kr){  //convert kelvin to rankin
//        return kr*9/5;
//    }
//    public static double r2c(double rc){  //convert rankin to celsius
//        return (rc-491.67)*5/9;
//    }
//    public static double r2f(double rf){  //convert rankin to fahrenheit
//        return rf-459.67;
//    }
//    public static double r2k(double rk){  //convert rankin to kelvin
//        return rk*5/9;
//    }
//public static double  [°C] = ([R] − 491.67) × 5⁄9
    //[R] = ([°C] + 273.15) × 9⁄5
    //R = F+459.67 F = R -459.67
//}
