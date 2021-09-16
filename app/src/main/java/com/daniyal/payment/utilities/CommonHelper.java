package com.daniyal.payment.utilities;

public class CommonHelper {

    public static String changeCharColor (String str, String textToBeColored, String color){

        return str.replace(textToBeColored,"<font color='"+color+"'>"+ textToBeColored +"</font>");
    }
}
