package com.toarabic;

import java.util.HashMap;

public class NotationConverter {

    public int toArabic(String romanNotation){
        if (!romanNotation.matches("[IVXLCDM]+") | romanNotation == null) {
            throw new InvalidValueException();
        }

        HashMap<Character, Integer> romNumbers = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int decimalNumber = 0, prev = 0, value = 0;

        for(int i = 0; i < romanNotation.length(); i++) {
            Integer current = romNumbers.get(romanNotation.charAt(i));
            if (current > prev) {
                decimalNumber -= 2*value;
            }
            if(current != prev) {
                value = 0;
            }
            value += current;
            decimalNumber += current;
            prev = current;
        }

    return decimalNumber;
    }

}
