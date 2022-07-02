package com.arcaroms.theme.os.common.provider;

import java.util.List;

import com.arcaroms.theme.os.common.xml.element.CommonElement;
import com.arcaroms.theme.os.common.xml.view.AbstractViewElement;

public interface ViewProvider {
	
	public <T extends AbstractViewElement> T createView(Class<T> clazz, String name);
	
	public <T extends AbstractViewElement> T createView(Class<T> clazz, String name, CommonElement... elements);
	
	public <T extends AbstractViewElement> T createView(Class<T> clazz, String name, List<CommonElement> elements);

}
