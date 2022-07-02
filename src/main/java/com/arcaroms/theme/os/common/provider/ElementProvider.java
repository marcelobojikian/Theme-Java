package com.arcaroms.theme.os.common.provider;

import java.util.Map;

import com.arcaroms.theme.os.common.xml.element.AbstractElement;

public interface ElementProvider {
	
	public <T extends AbstractElement> T createElement(Class<T> clazz, String name);
	
	public <T extends AbstractElement> T createElement(Class<T> clazz, String name, boolean extra);
	
	public <T extends AbstractElement> T createElement(Class<T> clazz, String name, Map<String, String> content);
	
	public <T extends AbstractElement> T createElement(Class<T> clazz, String name, boolean extra, Map<String, String> content);

}
