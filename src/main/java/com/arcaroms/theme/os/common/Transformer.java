package com.arcaroms.theme.os.common;

import com.thoughtworks.xstream.XStream;

public abstract class Transformer<T> {

	private static final XStream XSTREAM_INSTANCE = null;

	private XStream getInstance() {
		if (XSTREAM_INSTANCE == null) {
			return getXStream();
		} else {
			return XSTREAM_INSTANCE;
		}
	}
	
	public abstract XStream getXStream();
	
	public abstract T createTheme();

	public T fromXml(String xml) {
		return (T) getInstance().fromXML(xml);
	}

	public String toXML(T t) {
		return getInstance().toXML(t);
	}

}
