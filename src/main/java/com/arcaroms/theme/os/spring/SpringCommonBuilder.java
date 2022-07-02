package com.arcaroms.theme.os.spring;

import org.springframework.context.ApplicationContext;

import com.arcaroms.theme.os.common.builder.CommonBuilder;
import com.arcaroms.theme.os.common.xml.element.AbstractElement;
import com.arcaroms.theme.os.common.xml.view.AbstractViewElement;

public abstract class SpringCommonBuilder implements CommonBuilder {
	
	protected ApplicationContext context;

	public SpringCommonBuilder(ApplicationContext context) {
		this.context = context;
	}

	@Override
	public <T extends AbstractViewElement> T createView(Class<T> clazz) {
		return context.getBean(clazz);
	}

	@Override
	public <T extends AbstractElement> T createElement(Class<T> clazz) {
		return context.getBean(clazz);
	}

}
