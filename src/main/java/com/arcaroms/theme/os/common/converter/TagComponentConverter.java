package com.arcaroms.theme.os.common.converter;

import com.arcaroms.theme.os.common.xml.element.AbstractElement;
import com.arcaroms.theme.os.common.xml.view.AbstractViewElement;

public interface TagComponentConverter {

	public AbstractViewElement createView(String tagName);
	
	public AbstractElement createElement(String tagName);

}
