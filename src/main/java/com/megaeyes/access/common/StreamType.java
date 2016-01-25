package com.megaeyes.access.common;

/**
 * 摄像头码流类型定义类
 * @author si_tianqiang
 */
public class StreamType {

    public static final int Normal = 0;//自定义编码方式
    public static final int CDMA1x = 1;
    public static final int EVDO = 2;
    public static final int WIFI = 3;
    
    public static String getStreamType(int nType)
    {
        String sRet = "";
        switch(nType)
        {
            case Normal:    sRet = "Normal";break;
            case CDMA1x:    sRet = "CDMA1x";break;
            case EVDO:      sRet = "EVDO";break;
            case WIFI:      sRet = "WIFI";
            default:
                sRet = "Normal";
        }
        return sRet;
    }
}
