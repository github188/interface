package com.megaeyes.access.action.impl;

import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.access.common.StorePlan;
import com.megaeyes.access.common.StreamType;
import com.megaeyes.persistence.ibatis.model.VideoInputChannel;
import com.megaeyes.service.exception.BusinessException;
import com.megaeyes.service.iface.VICManager;

/**
 * 
 * @Title: StorageQueryVicAction.java 
 * @Package com.megaeyes.access.action.impl 
 * @Description: 中心存储获取摄像头信息-4016 
 * @author zhuanqi@megaeyes.com   
 * @date 2012-8-31 上午10:28:33 
 * @version V1.0
 */
public class StorageQueryVicAction extends BaseAction implements Action{

	@Autowired
	private VICManager vicManager;
	
	//分页参数，暂定为5，后面考虑配置文件
	private static final int PAGE_SIZE = 999;
	
	@Override
	public Document proccess(RequestObject req) throws BusinessException {
		Document doc = phaseXML(req);
		String[] param = XMLToObject(doc);
		int start = Integer.parseInt(param[1]);
		int end = start + PAGE_SIZE;
		List<VideoInputChannel> vicList = vicManager.getVicListByRemoteStorageIdWithPage(param[0],start,end);
		//返回
		Document rtn = ObjectToXML(vicList);
		return rtn;
	}

	/**
	 * 
	 * @Description: 解析XML 
	 * @author zhuanqi@megaeyes.com
	 * @param @param doc
	 * @param @return 
	 * @return String[] 
	 * @throws
	 */
	private String[] XMLToObject(Document doc) {
		String[] param = new String[2];
		Element rootElement = doc.getRootElement();
		Element storeDeviceElement = rootElement.getChild("StoreDeviceID");
		Element cameraIndexElement = rootElement.getChild("CameraIndex");
		String storeDeviceID = storeDeviceElement.getText();
		String cameraIndex = cameraIndexElement.getText();
		param[0] = storeDeviceID;
		param[1] = cameraIndex;
		return param;
	}

	/**
	 * 
	 * @Description: 返回XML 
	 * @author zhuanqi@megaeyes.com
	 * @param @param inObject
	 * @param @return 
	 * @return Document 
	 * @throws
	 */
	public Document ObjectToXML(List<VideoInputChannel> viclist) {
		Element rootElement = new Element("Message");
		Element successElement = new Element("Success");
		successElement.setText("0");
		rootElement.addContent(successElement);
		for (int i = 0; i < viclist.size(); i++) {
			VideoInputChannel cameraVO = (VideoInputChannel) viclist.get(i);
			Element cameraElement = new Element("Camera");
			cameraElement.setAttribute("ID", cameraVO.getId() == null ? "":cameraVO.getId());
			cameraElement.setAttribute("Naming", cameraVO.getNaming() == null ? "":cameraVO.getNaming());
			cameraElement.setAttribute("StoreCycle", String.valueOf(cameraVO.getStoreCycle()));
			cameraElement.setAttribute("StoreScheme", cameraVO.getRemoteStorePlanHourFlag() == null ? getStorePlan() : cameraVO.getRemoteStorePlanHourFlag().substring(0,168));
			cameraElement.setAttribute("PullMode", String.valueOf(cameraVO.getPullMode()));	
			/**
			 * 	<StoreScheme Type="remote" SchemeCycle="day/week/month" StreamType="码流类型" >
					<!--Item项数最多不超过32个(1.5K多)-->
					<Item Day=”DD-DD” Time="HH:MM-HH:MM" />
					<Item Day=”DD-DD” Time="HH:MM-HH:MM" />
					……
				</StoreScheme>

			 * 
			 */
			Element schemeElement = new Element("StoreScheme");
			schemeElement.setAttribute("Type","remote");
			schemeElement.setAttribute("SchemeCycle", cameraVO.getSchemeType() != StorePlan.DAY ? (cameraVO.getSchemeType() == StorePlan.WEEK ? "week":"month"):"day");
			schemeElement.setAttribute("StreamType", StreamType.getStreamType(cameraVO.getStreamType()));
			StorePlan storePlan = new StorePlan(cameraVO.getRemoteStorePlanHourFlag(),cameraVO.getSchemeType());
			List<String> planStrList = storePlan.getTimetable();
			for(String planStr:planStrList){
				//	00-23@00:00:00-01:59:59
				String[] itemStrArray = planStr.split("@");
				if(itemStrArray.length != 2){
					continue;
				}
				Element itemElement = new Element("Item");
				itemElement.setAttribute("Day",itemStrArray[0]);
				itemElement.setAttribute("Time",itemStrArray[1]);
				schemeElement.addContent(itemElement);
			}
			cameraElement.addContent(schemeElement);
			rootElement.addContent(cameraElement);
		}
		Document doc = new Document(rootElement);
		return doc;
	}
	
	private String getStorePlan()
    {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 7; i++)
        {
            buffer.append("000000000000000000000000");
        }
        return buffer.toString();
    }
}
