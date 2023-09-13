package kr.co.kmarket.db;


public class Utils {
  
import java.text.DecimalFormat;

public class Utils {

	public static String comma(String number) {
		int parsedNumber = Integer.parseInt(number);
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(parsedNumber);
	}
	
	public static String comma(int number) {
		DecimalFormat df = new DecimalFormat("###,###");
		return df.format(number);
	}
	
	public static String ellipsis(String str, int length) {
		return str.substring(0, length)+"...";
	}
}