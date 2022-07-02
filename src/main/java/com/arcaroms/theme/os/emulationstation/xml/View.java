package com.arcaroms.theme.os.emulationstation.xml;

import java.util.ArrayList;
import java.util.Arrays;

import com.arcaroms.theme.os.common.xml.element.CommonElement;
import com.arcaroms.theme.os.common.xml.view.AbstractViewElement;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("view")
public class View extends AbstractViewElement {

	private static final long serialVersionUID = 1L;
	
	public View addElements(CommonElement... elements) {
		getElements().addAll(new ArrayList<>(Arrays.asList(elements)));
		return this;
	}
	
	public void addElement(CommonElement element) {
		getElements().add(element);
	}

}
