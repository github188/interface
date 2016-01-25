package test;


import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;

public class HttpClientUtil {
	
	/**
	 * @param method
	 * @return
	 * @throws IOException 
	 * @throws HttpException 
	 */
	public static String getRespnoseStr(final HttpClient o_client,final HttpMethod o_method) throws HttpException, IOException{
		o_client.executeMethod(o_method);
	//	String o_strIdHeader = new String( o_method.getResponseHeaders().toString().getBytes("ISO8859_1"),"GB2312");
		String o_strId =  o_method.getResponseBodyAsString();
		
		System.out.println("response Info: \n"+ o_method.getStatusLine());
		System.out.println(  o_strId );
		
		return o_strId;
	}
	
	/** 
	 * @param o_client
	 * @param o_method
	 * @throws HttpException
	 * @throws IOException
	 */
	public static void executeClient(final HttpClient o_client,final HttpMethod o_method) throws HttpException, IOException{
		o_client.executeMethod(o_method);
	}
	

}
