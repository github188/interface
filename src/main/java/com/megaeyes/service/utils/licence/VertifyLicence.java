/**   
* @Title: VertifyLicence.java 
* @Package com.megaeyes.service.utils.licence 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-5-4 下午3:23:28 
* @version V1.0   
*/ 
package com.megaeyes.service.utils.licence;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/** 
 * @ClassName: VertifyLicence 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-5-4 下午3:23:28 
 *  
 */
public class VertifyLicence {

    //公钥
    private final static String pubKeyString =
            "308201B83082012C06072A8648CE3804013082011F02818100FD7F53811D751229" +
            "52DF4A9C2EECE4E7F611B7523CEF4400C31E3F80B6512669455D402251FB593D8D" +
            "58FABFC5F5BA30F6CB9B556CD7813B801D346FF26660B76B9950A5A49F9FE8047B" +
            "1022C24FBBA9D7FEB7C61BF83B57E7C6A8A6150F04FB83F6D3C51EC3023554135A" +
            "169132F675F3AE2B61D72AEFF22203199DD14801C70215009760508F15230BCCB2" +
            "92B982A2EB840BF0581CF502818100F7E1A085D69B3DDECBBCAB5C36B857B97994" +
            "AFBBFA3AEA82F9574C0B3D0782675159578EBAD4594FE67107108180B449167123" +
            "E84C281613B7CF09328CC8A6E13C167A8B547C8D28E0A3AE1E2BB3A675916EA37F" +
            "0BFA213562F1FB627A01243BCCA4F1BEA8519089A883DFE15AE59F06928B665E80" +
            "7B552564014C3BFECF492A0381850002818100BCBDC16D4C2F53897376EE06BA98" +
            "6EC3C0049B77DC8FEC03D80DF097DA84AE68819E7473AEED52DA9280BE6CB7C530" +
            "6ABADA670E90AABDBDF01E73F33E268C4348FCB30E1A17693D3A8BA3F94290B182" +
            "D7AA855DEE774FCDF96145FEBE0BE9C95C14C8336C3AA954D204C9A4F8F0AFA1A4" +
            "56122239DE5414FF54879C83BF503E";

    private VertifyLicence() {
    }

    public static Map getInfo(String path) throws LicenceNotFoundException, SignatureNotRightException {
        Map map = new HashMap();
        boolean isRight;
        
        InputStream inputStream = VertifyLicence.class.getClassLoader().getResourceAsStream(path);
        if (inputStream == null) {
            throw new LicenceNotFoundException("License file not found" + " filePath = " + path);
        }
        Licence licence;
        try {
            licence = LicenceUtil.readLicence(inputStream);
        } catch (IOException e) {

            throw new LicenceNotFoundException("License file read error!");
        }        
        isRight = LicenceUtil.verify(licence, pubKeyString);

        if (isRight) {
            //System.out.println("验证成功");
            map = licence.getFeaturesAsMap();
           
        } else {
            throw new SignatureNotRightException();
        }
        
        return map;
    }
//
    public static void main(String[] s) {
        try {
            //System.out.println(System.getProperty("java.class.path"));
            Map map = VertifyLicence.getInfo("megaeyes.licence");
            Iterator iterator = map.keySet().iterator();
            
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                String value = (String) map.get(key);
               // System.out.println(key + "=" + value);

            }
        } catch (LicenceNotFoundException e) {
            e.printStackTrace();
        } catch (SignatureNotRightException e) {
            e.printStackTrace();
        }
    }
}

