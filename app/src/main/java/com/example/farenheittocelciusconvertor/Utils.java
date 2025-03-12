package com.example.farenheittocelciusconvertor;

public class Utils {

    public static Double fToC(Double fahrenheit){
        return (fahrenheit - 32) / 1.8;
    }

    public static Double cToF(Double celsius){
        return (celsius * 1.8) + 32;
    }

}
