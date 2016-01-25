package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * 
 * @Title: HttpClientTest.java
 * @Package test
 * @Description:AccessSupport测试类
 * @author zhuanqi@megaeyes.com
 * @date 2012-9-4 上午07:04:13
 * @version V1.0
 */
public class HttpClientTest {
	private static String url = "http://localhost:8080/megaeyes_access_support/main";

	public static void main(String args[]) throws IOException {
		//test_1026();
		//test_2020();
		//test_2002();
		//test_3002();
		//test_4002();
		//test_4012();
		//test_4016();
		//test_6000();
		//test_1028();
		//test_1030();
		//test_5014();
		//test_5210();
		//test_5004();
		//test_5072();
		//compare();
		test_1002();
	}

	public static void test_1002() throws HttpException, IOException{
		Map<String,String> param = new HashMap<String,String>();
		param.put("messageId", "1002");
		param.put("accessId", "192.168.50.13");
		StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"); 
		sb.append("<Certification UserSessionId=\"0000000000200090240000000000742\" ResourceId=\"0000000000200000000000009200003\" ResourceType=\"5\" OperationKey=\"5006\" Naming=\"0000000000200000000000009200003:0000000000200000000000009400002:192.168.50.16:010001\"/>");
		param.put("xml", sb.toString());
		// 返回
		sendPost(url, param);
	}
	
	public static void test_1028() throws HttpException, IOException{
		Map<String,String> param = new HashMap<String,String>();
		param.put("messageId", "1028");
		param.put("accessId", "192.168.50.13");
		StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"); 
		sb.append("<Message><SourceId>0000000000200000000000004600473</SourceId><SourceType>5</SourceType></Message>");
		param.put("xml", sb.toString());
		// 返回
		sendPost(url, param);
	}
	
	public static void test_1030() throws HttpException, IOException{
		Map<String,String> param = new HashMap<String,String>();
		param.put("messageId", "1030");
		param.put("accessId", "192.168.50.13");
		StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"); 
		sb.append("<Message><Plan></Plan><UserList></UserList><AlarmOutTime></AlarmOutTime>");
		sb.append("<KinescopeTime></KinescopeTime><AheadTime></AheadTime>");
		sb.append("<AlarmOutList><AlarmOut>0000000000200000000000000600100</AlarmOut><AlarmOut>0000000000200000000000000600093</AlarmOut><AlarmOut>0000000000200000000000000600072</AlarmOut></AlarmOutList>");
		sb.append("<CameraList><Camera>0000000000200000000000004600418</Camera><Camera>0000000000200000000000004600419</Camera><Camera>0000000000200000000000004600441</Camera></CameraList>");
		sb.append("</Message>");
		param.put("xml", sb.toString());
		// 返回
		sendPost(url, param);
	}
	
	public static void test_5014() throws HttpException, IOException{
		Map<String,String> param = new HashMap<String,String>();
		param.put("messageId", "5014");
		param.put("accessId", "192.168.50.13");
		StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"); 
		sb.append("<Message><Camera ID=\"0000000000200000000000004600441\"></Camera></Message>");
		param.put("xml", sb.toString());
		// 返回
		sendPost(url, param);
	}
	
	public static void test_5004() throws HttpException, IOException{
		Map<String,String> param = new HashMap<String,String>();
		param.put("messageId", "5004");
		param.put("accessId", "192.168.50.13");
		StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"); 
		sb.append("<Message><CameraID>0000000000200000000000004600473</CameraID></Message>");
		param.put("xml", sb.toString());
		// 返回
		sendPost(url, param);
	}
	
	public static void test_5072() throws HttpException, IOException{
		Map<String,String> param = new HashMap<String,String>();
		param.put("messageId", "5072");
		param.put("accessId", "192.168.50.13");
		StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"); 
		sb.append("<Message><CameraID>0000000000200000000000004600473</CameraID></Message>");
		param.put("xml", sb.toString());
		// 返回
		sendPost(url, param);
	}
	
	public static void test_5210() throws HttpException, IOException{
		Map<String,String> param = new HashMap<String,String>();
		param.put("messageId", "5210");
		param.put("accessId", "192.168.50.13");
		StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"); 
		sb.append("<Message><SchemeAssociateId>0000000000200000000000000800051</SchemeAssociateId></Message>");
		param.put("xml", sb.toString());
		// 返回
		sendPost(url, param);
	}
	
	public static void test_2002() throws UnsupportedEncodingException,	IOException {
		Map<String, String> param = new HashMap<String, String>();
		param.put("messageId", "2002");
		param.put("accessId", "192.168.50.113");
		StringBuilder xml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xml.append("<TermRegister DeviceID=\"100000000000000011\" DeviceLinkType=\"1\"  DeviceIP = \"192.168.50.119\"  NatIP = \"192.168.50.119\"  DeviceMaxConnect= \"16\" >")
			.append("<MsgPort>8000</MsgPort>")
			.append("<VideoPort>8003</VideoPort>")
			.append("<AudioPort>6009</AudioPort>")
			.append("<UpdatePort>7001</UpdatePort>")
			.append("<WebPort>80</WebPort>")
			.append("<Version>12.345.6</Version >")
			.append("<Protocol></Protocol>")
			.append("<Company>设备提供商</Company>")
			.append("<SchemeSupport>1</SchemeSupport>")
			.append("<PtzLockRet>1</PtzLockRet>")
			.append("<IsSupportNAT>true</IsSupportNAT>")
			.append("<Support NAT=\"true\" Scheme=\"true\"	PtzLockRet =\"true\" Video2= \"true\" Normal=\"true\" CDMA1x=\"true\" EVDO=\"true\" WIFI=\"true\" />")
			.append("</TermRegister>");

		param.put("xml", xml.toString());
		// 返回
		sendPost(url, param);
	}

	public static void test_4012() throws HttpException, IOException{
		Map<String,String> param = new HashMap<String,String>();
		param.put("messageId", "4012");
		param.put("accessId", "192.168.50.113");
		StringBuilder xml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xml.append("<Message><StoreDeviceID>0000000000200000000000003400380</StoreDeviceID></Message>");
		param.put("xml", xml.toString());
		sendPost(url,param);
	}
	
	public static void test_6000() throws HttpException, IOException{
		Map<String,String> param = new HashMap<String,String>();
		param.put("messageId", "6000");
		param.put("accessId", "192.168.50.113");
		StringBuilder xml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xml.append("<Message>")
			.append("<DeviceNumber>00000000000121</DeviceNumber>")
			.append("<DeviceIP>192.168.50.119</DeviceIP>")
			.append("<DeviceLinkType>1</DeviceLinkType>")
			.append("</Message>");

		param.put("xml", xml.toString());
		sendPost(url,param);
	}
	
	public static void test_4016() throws HttpException, IOException{
		Map<String,String> param = new HashMap<String,String>();
		param.put("messageId", "4016");
		param.put("accessId", "192.168.50.113");
		StringBuilder xml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xml.append("<Message><StoreDeviceID>0000000000200000000000003400380</StoreDeviceID><CameraIndex>0</CameraIndex></Message>");
		param.put("xml", xml.toString());
		sendPost(url,param);
	}
	
	public static void test_4002() throws HttpException, IOException{
		Map<String,String> param = new HashMap<String,String>();
		param.put("messageId", "4002");
		param.put("accessId", "192.168.50.113");
		StringBuilder xml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xml.append("<StoreRegister DeviceID= \"99999999999999\" DeviceLinkType= \"1\" VirtualIP= \"192.168.50.119\" DeviceIP= \"192.168.50.119\">")
			.append("<VideoPort>6060</VideoPort>")
			.append("<Support VOD= \"true\"/>")
			.append("</StoreRegister>");
		
		param.put("xml", xml.toString());
		sendPost(url,param);
	}
	
	public static void test_3002() throws HttpException, IOException{
		Map<String,String> param = new HashMap<String,String>();
		param.put("messageId", "3002");
		param.put("accessId", "192.168.50.113");
		StringBuilder xml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xml.append("<DisPatchRegister DeviceID= \"d0000000000001\" DeviceLinkType= \"2\" DeviceIP= \"192.168.50.117\">")
			.append("<VideoPort>6000</VideoPort>")
			.append("<MsgPort>6043</MsgPort>")
			.append("</DisPatchRegister>");
		param.put("xml", xml.toString());
		sendPost(url,param);
	}
	
	public static void test_2020() throws HttpException, IOException {
		Map<String, String> param = new HashMap<String, String>();
		param.put("messageId", "2020");
		param.put("accessId", "192.168.50.113");
		StringBuilder xml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xml.append("<TermRegister DeviceID = \"100000000000000011\" DeviceIP =\"192.168.50.110\" ")
				.append("NatIP = \"192.168.50.110\" DeviceLinkType= \"1\" ")
				.append("DeviceMaxConnect = \"32\"> ")
				.append("<VideoPort>5000</VideoPort>")
				.append("<AudioPort>6000</AudioPort>")
				.append("<MsgPort>6333</MsgPort>")
				.append("<Version>1.0</Version>")
				.append("<TotalCapacity>512</TotalCapacity>")
				.append("<UsedCapacity>256</UsedCapacity>")
				.append("<RemainCapacity>256</RemainCapacity>")
				.append("<DeviceType>ipc-200s</DeviceType>")
				.append("<SDSupport>1</SDSupport>")
				.append("<SchemeSupport>1</SchemeSupport>")
				.append("</TermRegister>");
		param.put("xml", xml.toString());
		// 返回
		sendPost(url, param);
	}

	public static void test_1026() throws UnsupportedEncodingException,	IOException {
		Map<String, String> param = new HashMap<String, String>();
		param.put("messageId", "1026");
		param.put("accessId", "192.168.50.113");
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><Message><DeviceIP>S</DeviceIP></Message>";
		param.put("xml", xml);
		// 返回
		sendPost(url, param);
	}

	private static void sendPost(String url, Map<String, String> param) throws HttpException, IOException {
		HttpClient http = new HttpClient();
		PostMethod method = new PostMethod(url);
		// 返回
		if (param != null) {
			for (String key : param.keySet()) {
				method.addParameter(key, param.get(key));
			}
		}
		int status = http.executeMethod(method);
		if (status == 200) {
			System.out.println(new String(method.getResponseBody(),"utf-8"));
		}
	}
	
	public static void compare(){
		Map<String,String> m1= new HashMap<String,String>();
	    m1.put("2008", "AlarmNotifyAction"); 
		m1.put("1012", "AlarmConfirmAction"); 
		m1.put("2010", "AlarmStopAction" );
		m1.put("5050", "AlarmInfoAction" );
		m1.put("1002", "AuthorizationAction");  
		m1.put("1018", "MonitorAuthAction" );
		m1.put("1014", "DeviceNotifyAction");
		m1.put("1100", "DeviceNewNotifyAction"); 
		m1.put("1024", "NoHeartBeatAction" );
		m1.put("2" ,   "HeartBeatAction" );
		m1.put("2004", "ProtocolDownloadAction"); 
		m1.put("5004", "HistoryVideoAction" );
		m1.put("2002", "TermRegisterAction" );
		m1.put("2020", "IpCameraRegisterAction"); 
		m1.put("3002", "DispatchRegisterAction" );
		m1.put("4002", "StorageRegisterAction" );
		m1.put("4016", "StorageQueryVicAction" );
		m1.put("4012", "StorageQueryCameraTotalAction"); 
		m1.put("6000", "DisplayRegisterAction" );
		m1.put("1026", "AccessRebootAction" );
		m1.put("5014", "StoreSchemaAction" );
		m1.put("5074", "VideoParamAction" );
		m1.put("5076", "GetVideoParamAction"); 
		m1.put("5078", "DefaulVideoParamAction"); 
		m1.put("1004", "UserOperationLogAction" );
		m1.put("5072", "UserVideoBillAction" );
		m1.put("1028", "FindDeviceNamingAction"); 
		m1.put("1030", "FindDeviceNamingListAction"); 
		m1.put("5208", "SetDeviceAlarmAction" );
		m1.put("5210", "DeleteDeviceAlarmAction"); 
		m1.put("5220", "CreateAlarmEventByManAction"); 
		m1.put("5214", "CreateAlarmEventAutoAction" );
		m1.put("1040", "IpCameraHeartBeatAction" );
		m1.put("1042", "SDLostReportAction" );
		m1.put("3000", "IpCameraAlarmNotifyAction"); 
		m1.put("20",   "EmptyAction" );
		m1.put("22",   "EmptyAction" );
		m1.put("1200", "StorageInfoQueryAction"); 
		
		Map<String,String> m2 = new HashMap<String,String>();
		m2.put("1012" ,"alarmConfirmAction") ;
		m2.put("2008" ,"alarmNotifyAction") ;
		m2.put("2010" ,"alarmStopAction");
		m2.put("5050" ,"alarmInfoAction");
		m2.put("1002" ,"authorizationAction");
		m2.put("1018" ,"monitorAuthAction");
		m2.put("1014" ,"deviceNotifyAction");
		m2.put("1100" ,"deviceNewNotifyAction");
		m2.put("1024" ,"noHeartBeatAction");
		m2.put("2"    ,"heartBeatAction");
		m2.put("2004" ,"protocolDownloadAction");
		m2.put("1026" ,"accessRebootAction");
		m2.put("2020" ,"ipCameraRegisterAction");
		m2.put("4012" ,"storageQueryCameraTotalAction");
		m2.put("6000" ,"displayRegisterAction");
		m2.put("4016" ,"storageQueryVicAction");
		m2.put("4002" ,"storageRegisterAction");
		m2.put("2002" ,"termRegisterAction");
		m2.put("3002" ,"dispatchRegisterAction");
		m2.put("1028" ,"findDeviceNamingAction");
		m2.put("1030" ,"findDeviceNamingListAction");
		m2.put("5014" ,"storeSchemaAction");
		m2.put("5210" ,"deleteDeviceAlarmAction");
		m2.put("1004" ,"userOperationLogAction");
		m2.put("5004" ,"historyVideoAction");
		m2.put("5072" ,"userVideoBillAction");
		m2.put("5208" ,"setDeviceAlarmAction");
		m2.put("1040" ,"ipCameraHeartBeatAction");
		m2.put("1042" ,"sDLostReportAction");
		m2.put("3000" ,"ipCameraAlarmNotifyAction");
		m2.put("20"   ,"emptyAction");
		m2.put("22"   ,"emptyAction");
		m2.put("1200" ,"storageInfoQueryAction");
		
		for(String key:m1.keySet()){
			if(m2.get(key) == null){
				String value = m1.get(key);
				System.out.println("messageId:"+key+"  action:"+value);
			}
	    }

	}

}
