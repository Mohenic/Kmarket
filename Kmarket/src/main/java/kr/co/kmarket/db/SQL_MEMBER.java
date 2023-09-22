package kr.co.kmarket.db;

public class SQL_MEMBER {
	
	public static final String SELECT_TEMRS = "SELECT `terms`,`privacy`,`location`,`finance` FROM `km_member_terms` ";
	public static final String SELECT_TAX = "SELECT `tax`,`privacy`,`finance` FROM `km_member_terms` ";
	public static final String SELECT_COUNT_UID="SELECT COUNT(*) FROM `km_member` WHERE `uid`=?";
	public static final String SELECT_COUNT_EMAIL="SELECT COUNT(*) FROM `km_member` WHERE `email`=?";
	public static final String SELECT_COUNT_HP="SELECT COUNT(*) FROM `km_member` WHERE `hp`=?";
	public static final String SELECT_USER="SELECT * FROM `km_member` WHERE `UID`=? AND `PASS`=SHA2(?,256)";
	//INSERT
		public static final String INSERT_MEMBER ="INSERT INTO `km_member` SET `uid`=?, `pass`=SHA2(?,256), name=?, gender=?"
												+ ", hp=? , email=?, type=?, zip=?, addr1=?, addr2=?, regip=?, rdate=NOW()";
		
		public static final String INSERT_MEMBER_SELLER ="INSERT INTO `km_member` SET `uid`=?, `pass`=SHA2(?,256),"
													+ "  email=?, type=?, zip=?, addr1=?, addr2=?,"
													+ " company=?, ceo=?, bizRegNum=?, comRegNum=? ,tel=?, manager=?, managerHp=?, fax=?, "
													+ "regip=?, rdate=NOW(),level=5";
		public static final String INSERT_MEMBER_POINT="INSERT INTO `km_member_point` SET `uid`=?,`ordNo`=?,`point`=? ,`pointDate`=NOW()";

		
		//DELETE
		
		//UPDATE
		public static final String UPDATE_MEMBER_POINT="UPDATE `km_member` SET `point`=`point`+?-? where `uid`=?";
		
		public static final String SELECT_MEMBER_POINT="SELECT a.`point` FROM `km_member` AS a WHERE `uid`=?";
}
