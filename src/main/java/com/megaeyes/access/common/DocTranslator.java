package com.megaeyes.access.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 * 
 * @Title: DocTranslator.java 
 * @Package com.megaeyes.access.common 
 * @Description: jdom工具类
 * @author zhuanqi@megaeyes.com   
 * @date 2012-9-21 上午03:17:05 
 * @version V1.0
 */
public class DocTranslator
{
	/**
	 * 直接将对应的xml转换为对应的UTF-8的编码
	 * @param xmlDoc
	 * @return
	 */
    public static String convertToString( org.jdom.Document xmlDoc )
	{
		XMLOutputter xmlOut = new XMLOutputter("  ", true, "UTF-8");
		StringWriter sw = new StringWriter();

		try
		{
			xmlOut.setIndent( "\t" );
			xmlOut.output( xmlDoc, sw );
			sw.flush();
		}
		catch( Exception e )
		{
			System.out.println( "Error converting JDOM Document to String: " + e.getMessage() );
		}
		finally
		{
			try{ sw.close(); } catch( Exception e ){}
		}
		return sw.getBuffer().toString();
	}
    
    /**
     * 根据需要转换编码
     * @param xmlDoc
     * @param lanague
     * @return
     */
    public static String convertToString( org.jdom.Document xmlDoc,String lanague)
	{
		XMLOutputter xmlOut = new XMLOutputter("  ", true, lanague);
		StringWriter sw = new StringWriter();

		try
		{
			xmlOut.setIndent( "\t" );
			xmlOut.output( xmlDoc, sw );
			sw.flush();
		}
		catch( Exception e )
		{
			System.out.println( "Error converting JDOM Document to String: " + e.getMessage() );
		}
		finally
		{
			try{ sw.close(); } catch( Exception e ){}
		}
		return sw.getBuffer().toString();
	}
    
    /**
     * string转换为Element
     * fixed by zyq: 对操作泄漏进行了修订
     * @param str
     * @return
     */
    public static Element stringToElement(String str)
    {
        InputStream inXMLStream = new ByteArrayInputStream(str.getBytes());
        SAXBuilder xmlBuilder = new SAXBuilder();
        Document xmlDoc = null;
        try
        {
            xmlDoc = xmlBuilder.build(inXMLStream);
        }
        catch (JDOMException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }finally{
        	try {
				inXMLStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        
        Element rootElement = xmlDoc.getRootElement();
        return rootElement;
    }  
    
    /**
     * Stream转换成string
     * @param inputStream
     * @return
     * @throws IOException
     */
    public final static String streamToString(final InputStream inputStream) throws IOException
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int read = 0;
        int length = 0;
        
        String retStr = null;
        
        try{
        	 while ((read = inputStream.read(buffer, 0, buffer.length)) != -1)
             {
                 baos.write(buffer, 0, read);
                 length += read;
             }
        	 
        	 baos.close();
        	 retStr = baos.toString();
        	 baos=null;
        	 
        }catch(IOException ex){
        	throw ex;
        }finally{
        	if(baos!=null){
        		baos.close();
        	}
        }
       
        return retStr;
    }
}
