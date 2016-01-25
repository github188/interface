package com.megaeyes.access.common;

import org.jdom.Document;
import org.jdom.Element;

public class CommonReturnDoc {
	static public Document getReturnDoc(int nSuccess) {

		Element rootElement = new Element("Message");
		Element successElement = new Element("Success");
		successElement.setText(Integer.toString(nSuccess));
		rootElement.addContent(successElement);
		Document doc = new Document(rootElement);

		return doc;
	}
}
