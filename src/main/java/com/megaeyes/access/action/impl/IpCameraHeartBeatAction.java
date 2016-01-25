package com.megaeyes.access.action.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jdom.Document;
import org.jdom.Element;

import com.megaeyes.access.RequestObject;
import com.megaeyes.access.action.Action;
import com.megaeyes.service.exception.BusinessException;

public class IpCameraHeartBeatAction extends BaseAction implements Action {
	
	@Override
	public Document proccess(RequestObject req) throws BusinessException {
	    Element rootElement = new Element("Message");
	    rootElement.setAttribute("CurrentDateTime",dataToStr(new Date()));    
	    Document doc = new Document(rootElement);
	    return doc;
	}
    private String dataToStr(Date date){
    	String timeStr = "";
    	SimpleDateFormat formatter = new SimpleDateFormat("MMddHHmmyyyy.ss");
    	timeStr = formatter.format(date);
    	return timeStr;
    }
}


