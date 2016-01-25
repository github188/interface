package com.megaeyes.access.common;

/**
 * @author Administrator
 */
public class NamingUtil
{
    public static final String NAMING_SPLIT = ":";
    
    /**
     * 获取接入服务器ip
     */
    public static String getAccessServerIp(String naming)
    {
        int end = naming.lastIndexOf(":");
        
        String temp = naming.substring(0,naming.lastIndexOf(":"));
        
        int start = temp.lastIndexOf(":");
        
        return naming.substring(start+1,end);
    }
}
