package com.arcaroms.theme.os.common.xml.element;

import java.io.Serializable;

import com.arcaroms.theme.os.common.xml.Content;

public interface CommonElement extends Serializable {

	public Content getContent();

	public String getName();

	public boolean isExtra();

}
