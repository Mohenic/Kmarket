package kr.co.kmarket.db;

import java.text.DecimalFormat;

public class Util {

	public String maskUserId(String userId) {
        if (userId != null && userId.length() > 2) {
            String maskedUserId = userId.substring(0, 2) + "**";
            return maskedUserId;
        }
        return userId;
    }
	
	public static String comma(String number) {
		int parsedNumber = Integer.parseInt(number);
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(parsedNumber);
	}
	
	public static String comma(int number) {
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(number);
	}
	
}
