package com.leaderboard.gamedashboard.util;

import java.util.Base64;

public class Encoder {

    private final String prefix = "poiulkjh";


    public String encode(String value, String mobileNumber) {

        String encodedString = Base64.getEncoder().encodeToString(prefix.getBytes()) + Base64.getEncoder().encodeToString(value.getBytes()) + Base64.getEncoder().encodeToString(mobileNumber.getBytes());
        System.out.println("encodeM   :" + encodedString);
        decode(encodedString);
        return encodedString;
    }

    public String decode(String encodedString) {
        String substring = encodedString.substring(12);
        byte[] decodedBytes = Base64.getDecoder().decode(substring);
        String decodedString1 = new String(decodedBytes);

        String[] array = decodedString1.split("\\$");

        System.out.println("decodeM  :" + array[0]);
        return array[0];
    }

    public String getMobileNumber(String encodedString){
        String substring = encodedString.substring(12);
        byte[] decodedBytes = Base64.getDecoder().decode(substring);
        String decodedString1 = new String(decodedBytes);

        String[] array = decodedString1.split("\\$");

        System.out.println("mobileNumber  :" + array[1]);
        return array[1];
    }
}
