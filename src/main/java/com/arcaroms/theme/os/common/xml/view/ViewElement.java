package com.arcaroms.theme.os.common.xml.view;

import java.io.Serializable;
import java.util.List;

import com.arcaroms.theme.os.common.xml.element.CommonElement;

public interface ViewElement extends Serializable {
	
	public String getName();
	
	public List<CommonElement> getElements();

}
