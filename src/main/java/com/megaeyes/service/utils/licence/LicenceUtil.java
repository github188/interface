/**   
* @Title: LicenceUtil.java 
* @Package com.megaeyes.service.utils.licence 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-5-4 下午3:21:30 
* @version V1.0   
*/ 
package com.megaeyes.service.utils.licence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/** 
 * @ClassName: LicenceUtil 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-5-4 下午3:21:30 
 *  
 */
public final class LicenceUtil {

    /**
     * licence使用的方式
     * 		1>如果licenceMode是1的情况，使用licence文件来进行设置
     * 		2>如果licenceMode是2的情况，默认的最大的数量是50用户，50摄像头的授权
     *
     * 增加licence模式的变化，主要是为了防止拷贝licence文件的拷贝
     */
    private static int licenceMode = 1;
    private static KeyFactory keyFactory;
    private static LicenceUtil licenceUtil = new LicenceUtil();
    private Map map = null;
    private boolean developMode = true;
    private boolean inited = false;
    private static List<String> macs ;
    private static List<List<String>> macLists ;

    static {
        try {
            keyFactory = KeyFactory.getInstance("DSA");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        try {
        	//目前版本暂时不需要新的licence校验规则,等需要时放开下面的注释的代码
			macs = MacAddressUtil.getMacAddressList() ;
		} 
        catch (Exception e) {
        	System.out.println("读取主机网卡地址时发生异常:");
			e.printStackTrace();
		}
    }

    private LicenceUtil() {
    }

    public static LicenceUtil getInstance() throws LicenceNotFoundException, SignatureNotRightException {
        if (!licenceUtil.isInited()) {
            licenceUtil.init();
        }
        return licenceUtil;
    }

    private boolean isInited() {
        return inited;
    }

    public static KeyFactory getKeyFactory() {
        return keyFactory;
    }

    private static PublicKey getPublicKey(byte abyte0[])
            throws InvalidKeySpecException {
        return keyFactory.generatePublic(new X509EncodedKeySpec(abyte0));
    }

    public static boolean verify(Licence licence, String pubKeyString) {
        boolean isRight = false;
        try {
            byte[] pubKeyEncoded = Translate.translateStringToBytes(pubKeyString);
            //初始一个Signature对象,并用公钥和签名进行验证
            java.security.Signature signetcheck = Signature.getInstance("DSA");
            signetcheck.initVerify(getPublicKey(pubKeyEncoded));
            signetcheck.update(licence.getFeaturesAsString(false).getBytes());
            //System.out.println(getPublicKey(pubKeyEncoded));
            
            if (signetcheck.verify(Translate.translateStringToBytes(licence.getSignature()))) {
                isRight = true;
            }            
        } catch (Exception e) {
            e.printStackTrace();
        }


        return isRight;
    }

    public static Licence readLicence(InputStream inputstream) throws IOException {
        BufferedReader bufferedreader = new BufferedReader(
                new InputStreamReader(inputstream));
        Licence license = new Licence();
        String line;
        while ((line = bufferedreader.readLine()) != null) {
            if (!"".equals(line.trim())) {
                int i = line.indexOf('=');
                String key;
                String info;
                if (i > 0) {
                    key = line.substring(0, i).trim();
                    info = line.substring(i + 1).trim();
                } else {
                    key = line.trim();
                    info = "";
                }
                if ("signature".equals(key)) {
                    license.setSignature(info);
                } else {
                    license.addFeature(key, info);
                }
            }
        }

        return license;
    }

    private synchronized void init() throws LicenceNotFoundException, SignatureNotRightException {
        if (map == null) {
            if (licenceMode == 1) {
                map = VertifyLicence.getInfo("megaeyes.licence");
            } else if (licenceMode == 2) {
                map.put("videoCount", "50");
                map.put("userCount", "50");
                map.put("expireDate", "2013-01-01");
            }
        }
    }

    public boolean videoVertify(int videoCount) throws LicenceNotFoundException, SignatureNotRightException {
        String sVideoCount = (String) map.get("videoCount");        
        if (sVideoCount != null) {
            //查询用户的个数与map中的值进行比较
            int count = Integer.valueOf(sVideoCount).intValue();
            if (count <= videoCount) {
                return false;
            }
            return true;
        }
        return developMode;
    }

    //  licence验证
    public boolean userVertify(int userCount) throws LicenceNotFoundException, SignatureNotRightException {
    	String sUserCount = (String) map.get("userCount");
        if (sUserCount != null) {
            //查询用户的个数与map中的值进行比较
            int count = Integer.valueOf(sUserCount).intValue();
            if (count <= userCount) {
                return false;
            }
            return true;
        }
        return developMode;
    }

    public boolean logonVertify() throws LicenceNotFoundException, SignatureNotRightException {
        String expire = (String) map.get("expireDate");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        if (expire == null) {
            return developMode;
        }
        try {
            Date expireDate = format.parse(expire);
            Date currentDate = new Date();
            if (currentDate.compareTo(expireDate) >= 0) {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return developMode;
    }

    public boolean monitorVertify(String manufacturerCode, int verfiyCount) throws LicenceNotFoundException, SignatureNotRightException {
        String manufacturerCount =  (String)map.get(manufacturerCode);
        if (manufacturerCount != null && !"".equals(manufacturerCount)) {
            //查询指定监视器厂商的可创建监视器数量
            int count = Integer.valueOf(manufacturerCount).intValue();
            if (count <= verfiyCount) {
                return false;
            }
            return true;
        }
        return developMode;
    }

    /**
     * 校验主机是否合法(判断当前主机的网卡MAC地址是否是已经注册了的)
     * @return
     */
    public boolean targetHostVertify() {
    	//目前版本暂时不需要新的licence校验规则,等需要时放开下面的代码
    	if(true){
    		return true ;
    	}
        String macListAsString = (String)map.get("mac");
        if(macListAsString != null){
	        if(macs == null || macs.isEmpty()){
	        	return false ;
	        }
	        if(macLists == null) {
	        	macLists = parseString(macListAsString) ;
	        }
	        
	        boolean findList = false ;
	        for (List<String> macList : macLists) {
				for (String mac : macList) {
					for (String localMac : macs) {
						if(mac.equals(localMac)) {
							findList = true ;
							break ;
						}
					}
					if(findList) {
						break ;
					}
				}
				if(findList) {
					for (String mac : macList) {
						boolean find = false ;
						for (String localMac : macs) {
							if(mac.equals(localMac)) {
								find = true ;
								break ;
							}
						}
						if(!find){
							return false ;
						}
					}
					return true ;
				}
			}
	        return false ;
        }
        return developMode;
    }
    
    private List<List<String>> parseString(String macsParam) {
    	List<List<String>> macLists = new ArrayList<List<String>>() ;
    	macsParam = "," + macsParam.substring(1, macsParam.length() - 1) ;
    	String[] macStringArr = macsParam.split("}") ;
    	for (int i = 0; i < macStringArr.length; i++) {
    		List<String> macList = new ArrayList<String>() ;
    		String macString = macStringArr[i].substring(2,macStringArr[i].length()) ;
    		String[] macs = macString.split(",") ;
    		for (int j = 0; j < macs.length; j++) {
    			macList.add(macs[j]) ;
			}
    		macLists.add(macList) ;
        }
    	return macLists ;
    }
    
    public static void main(String[] args) throws Exception {
    	LicenceUtil licenceUtil = new LicenceUtil() ;
    	licenceUtil.init() ;
		System.out.println(licenceUtil.targetHostVertify()) ;
	}
    
}