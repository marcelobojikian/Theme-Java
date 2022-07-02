package com.arcaroms.theme.os.common.converter;

import com.arcaroms.theme.os.common.xml.Content;
import com.arcaroms.theme.os.common.xml.element.AbstractElement;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ElementConverter implements Converter {
	
	private TagComponentConverter tagConverter;

	public ElementConverter(TagComponentConverter tagConverter) {
		this.tagConverter = tagConverter;
	}

	public boolean canConvert(Class clazz) {
		return AbstractElement.class.isAssignableFrom(clazz);
	}

	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {

		AbstractElement element = (AbstractElement) value;

		if (element.isExtra()) {
			writer.addAttribute("extra", "true");
		}

		writer.addAttribute("name", element.getName());

		context.convertAnother(element.getContent());

	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {

		AbstractElement element = tagConverter.createElement(reader.getNodeName());

		String name = reader.getAttribute("name");
		element.setName(name);

		String extra = reader.getAttribute("extra");
		element.setExtra(Boolean.valueOf(extra));

		Content content = (Content) context.convertAnother(element, Content.class);
		element.setContent(content);

		return element;
	}

}
