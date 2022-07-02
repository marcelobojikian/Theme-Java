package com.arcaroms.theme.os.common.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.arcaroms.theme.os.common.builder.CommonBuilder;
import com.arcaroms.theme.os.common.xml.Content;
import com.arcaroms.theme.os.common.xml.element.AbstractElement;
import com.arcaroms.theme.os.common.xml.element.CommonElement;
import com.arcaroms.theme.os.common.xml.theme.AbstractTheme;
import com.arcaroms.theme.os.common.xml.view.AbstractViewElement;

public class CommonProvider implements ThemeProvider, ViewProvider, ElementProvider {

	private CommonBuilder builder;
	
	public CommonProvider(CommonBuilder builder) {
		this.builder = builder;
	}

	@Override
	public <T extends AbstractTheme> T createTheme(Class<T> clazz, Integer version) {
		T theme = builder.createTheme(clazz);
		theme.setFormatVersion(version);
		theme.setViewElements(new ArrayList<>());
		theme.setIncludes(new ArrayList<>());
		return theme;
	}

	@Override
	public <T extends AbstractTheme> T createTheme(Class<T> clazz, Integer version, String... includes) {
		T theme = builder.createTheme(clazz);
		theme.setFormatVersion(version);
		theme.setViewElements(new ArrayList<>());
		theme.setIncludes(new ArrayList<>(Arrays.asList(includes)));
		return theme;
	}

	@Override
	public <T extends AbstractViewElement> T createView(Class<T> clazz, String name) {
		T view = builder.createView(clazz);
		view.setName(name);
		view.setElements(new ArrayList<>());
		return view;
	}

	@Override
	public <T extends AbstractViewElement> T createView(Class<T> clazz, String name, CommonElement... elements) {
		T view = builder.createView(clazz);
		view.setName(name);
		view.setElements(new ArrayList<>(Arrays.asList(elements)));
		return view;
	}

	@Override
	public <T extends AbstractViewElement> T createView(Class<T> clazz, String name, List<CommonElement> elements) {
		T view = builder.createView(clazz);
		view.setName(name);
		view.setElements(elements);
		return view;
	}

	@Override
	public <T extends AbstractElement> T createElement(Class<T> clazz, String name) {
		T element = builder.createElement(clazz);
		element.setName(name);
		element.setExtra(false);
		element.setContent(new Content());
		return element;
	}

	@Override
	public <T extends AbstractElement> T createElement(Class<T> clazz, String name, boolean extra) {
		T element = builder.createElement(clazz);
		element.setName(name);
		element.setExtra(extra);
		element.setContent(new Content());
		return element;
	}

	@Override
	public <T extends AbstractElement> T createElement(Class<T> clazz, String name, Map<String, String> content) {
		T element = builder.createElement(clazz);
		element.setName(name);
		element.setExtra(false);
		element.setContent(new Content(content));
		return element;
	}

	@Override
	public <T extends AbstractElement> T createElement(Class<T> clazz, String name, boolean extra,
			Map<String, String> content) {
		T element = createElement(clazz, name, content);
		element.setName(name);
		element.setExtra(extra);
		element.setContent(new Content(content));
		return (T) element;
	}

}
