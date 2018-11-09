package cn.mauth.issue.util;

/**
 * 常量工具类
 * 
 * @author mauth
 */
public final class Constants {

	public final static String ADMIN = "超级管理员";

	private Constants() {
	}
	
	/**
	 * 常量
	 * 
	 * @author mauth
	 */
	public interface BeanSuffix {
		public final static String CARD = "_card";
		public final static String TELEPHONE = "_telephone";
		public final static String FLOW = "_flow";
	}

	/**
	 * 常量
	 * 
	 * @author mauth
	 */
	public interface Session {
		public final static String USER_TYPE = "mauth_user_type";
		public final static String USER_ID = "mauth_user_info_id";
		public final static String USER = "mauth_user";
		public final static String MENU = "mauth_menu";
		public final static String PERMISSIONS = "mauth_Permissions";
		public final static String ROLE = "mauth_role";
		public final static String ACCOUNT = "account";
		public final static String SESSIONINDEX = "sessionIndex";
	}

}
