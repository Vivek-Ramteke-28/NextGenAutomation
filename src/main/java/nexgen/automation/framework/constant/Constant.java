package nexgen.automation.framework.constant;

import nexgen.automation.framework.baseclass.BaseSuite;
import nexgen.automation.framework.config.ReadConfig;



public class Constant extends BaseSuite {

	private static ReadConfig readconfig = new ReadConfig();
	public static final long  PAGE_LOAD_TIMEOUT = Integer.parseInt(readconfig.pageLoadTimeout());
	public static final long IMPLICITWAIT = Integer.parseInt(readconfig.implicitWait());
	public static final  int SHORTWAIT = Integer.parseInt(readconfig.shortWait());
	public static final  int MEDIUMWAIT = Integer.parseInt(readconfig.mediumWait());
	public static  final int LONGWAIT = Integer.parseInt(readconfig.longWait());
	
	public static final  int SHOTW = Integer.parseInt(readconfig.shortW());
	public static  final int MEDIUMW= Integer.parseInt(readconfig.mediumW());
	public static  final int LONGW = Integer.parseInt(readconfig.longW());
	
	// count of test cases and taking suite name
		public static int failedTC;
		public static int passedTC;
		public static int testskip;
		public static int test;
		public static String suitename = "";
		public static String screenshotPath = "";

	public static final String EMAIL_SIGNATURE = readconfig.emailSignature();
					
	public static  final String EXCELPATH = readconfig.excelPath();
	
	public static  final String DBDETAILS = readconfig.dbDetails();
	
	public static  final  String LOGINDETAILS=readconfig.loginDetails();
	
	public static final String USERDETAILS = readconfig.UserDetails();
	
	//Issue key for all test cases will be stored here	
		public static String issueKey= "";
		
		public static String reportDocPath =null;
										
		public static String ExcelPath = readconfig.excelPath();
		
		public static String dbDetails = readconfig.dbDetails();
		
		public static String loginDetails=readconfig.loginDetails();
		
		public static String UserDetails=readconfig.UserDetails();
		
		public static int currentRowNum = 1;
		
		public static String components;
		
		public static String lables;
		
		public static boolean retryFlag;
		
		public static int retryFlagCount;
		
		public static int totalcount;
		
		public static int ruleWait = Integer.parseInt(readconfig.ruleWait());
	

	}
