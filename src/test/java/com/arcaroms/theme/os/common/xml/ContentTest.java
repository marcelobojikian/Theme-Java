package com.arcaroms.theme.os.common.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.arcaroms.theme.os.common.converter.ContentConverter;
import com.arcaroms.theme.os.util.XStreamUtil;
import com.thoughtworks.xstream.XStream;

public class ContentTest {

	XStream xstream;

	@BeforeEach
	public void init() {

		xstream = XStreamUtil.create();

		xstream.registerConverter(new ContentConverter());
		xstream.allowTypes(new Class[] { Content.class });
		
		xstream.alias("element", Content.class);

	}

	@Test
	public void sucessWhenConvertToXml() {

		Map<String, String> map = new HashMap<>();
		map.put("key", "value");

		Content content = new Content();
		content.setAttributes(map);

		String contentXml = xstream.toXML(content);
		// @formatter:off
		String result = "<element>\n"
				      + "  <key>value</key>\n"
				      + "</element>";
		// @formatter:on

		assertEquals(contentXml, result);

	}

	@Test
	public void sucessWhenConvertToJava() {

		// @formatter:off
		String result = "<element>\n"
			      + "  <key>value</key>\n"
			      + "</element>";
		// @formatter:on

		Content contentObj = (Content) xstream.fromXML(result);

		assertNotNull(contentObj);
		assertEquals(contentObj.getAttributes().get("key"), "value");

	}

	@Test
	public void sucessWhenCloneContent() {

		Map<String, String> map = new HashMap<>();
		map.put("key", "value");

		Content content = new Content();
		content.setAttributes(map);

		Content clone = content.clone();

		assertNotSame(content, clone);

	}

}
