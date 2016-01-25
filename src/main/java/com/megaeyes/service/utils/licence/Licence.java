/**   
* @Title: Licence.java 
* @Package com.megaeyes.service.utils.licence 
* @Description: TODO(用一句话描述该文件做什么) 
* @author liugaofeng liugaofeng@megaeyes.com   
* @date 2012-5-4 下午3:20:39 
* @version V1.0   
*/ 
package com.megaeyes.service.utils.licence;

/** 
 * @ClassName: Licence 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author liugaofeng liugaofeng@megaeyes.com 
 * @date 2012-5-4 下午3:20:39 
 *  
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;




public final class Licence {

   private Map featuresMap = new HashMap();
   private List featuresList = new ArrayList();
   private String signature ;
    public Licence() {
        super();
        // TODO Auto-generated constructor stub
    }
   public void addFeature(String key,String info){
       featuresMap.put(key,info);
       featuresList.add(key+"="+info);
   }
   public void setSignature(String signature){
       this.signature = signature;
   }
   public String getSignature(){
       return this.signature;
   }
   public List getFeaturesAsLsit(){
       return this.featuresList;
   }
   public Map getFeaturesAsMap(){
       return this.featuresMap;
   }
   public String getFeaturesAsString(boolean isEnter){
       String  features ="";
       Iterator iterator = featuresList.iterator();
       while(iterator.hasNext()){
           String feature = (String)iterator.next();
           if(isEnter) feature = feature+"\n";
           features = features + feature;
       }
       return features;
   }
}
