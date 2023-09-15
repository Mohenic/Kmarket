package kr.co.kmarket.db;

public class Util {

	public String maskUserId(String userId) {
        if (userId != null && userId.length() > 2) {
            String maskedUserId = userId.substring(0, 2) + "**";
            return maskedUserId;
        }
        return userId;
    }
}
