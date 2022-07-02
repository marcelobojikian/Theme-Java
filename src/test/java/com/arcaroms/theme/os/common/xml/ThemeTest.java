package com.arcaroms.theme.os.common.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.arcaroms.theme.os.common.builder.CommonBuilder;
import com.arcaroms.theme.os.common.builder.ComponentBuilderDefault;
import com.arcaroms.theme.os.common.converter.ElementConverter;
import com.arcaroms.theme.os.common.converter.TagComponentConverter;
import com.arcaroms.theme.os.common.factory.TagComponentFactory;
import com.arcaroms.theme.os.common.xml.theme.AbstractTheme;
import com.arcaroms.theme.os.emulationstation.xml.View;
import com.arcaroms.theme.os.util.XStreamUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;

public class ThemeTest {

	XStream xstream;

	@BeforeEach
	public void init() {
		CommonBuilder builder = new ComponentBuilderDefault();
		TagComponentConverter tagFactory = new TagComponentFactory(builder);
		ElementConverter elementConverter = new ElementConverter(tagFactory);
		xstream = XStreamUtil.createForElements(elementConverter);

		xstream.processAnnotations(Theme.class);
		xstream.allowTypes(new Class[] { Theme.class });
	}

	@Test
	public void whenCreateTheme_DefaultValues() {

		Theme theme = new Theme();

		assertNull(theme.getFormatVersion());
		assertTrue(theme.getViewElements().isEmpty());
		assertTrue(theme.getIncludes().isEmpty());

	}

	@Test
	public void sucessWhenCreateXml() {

		Theme theme = new Theme();

		String contentXml = xstream.toXML(theme);
		String result = "<theme/>";

		assertEquals(contentXml, result);

	}

	@Test
	public void sucessWhenCreateXml_ViewWithFormatVersion() {

		Theme theme = new Theme();
		theme.setFormatVersion(4);

		String contentXml = xstream.toXML(theme);
		// @formatter:off
		String result = "<theme>\n"
					  + "  <formatVersion>4</formatVersion>\n"
					  + "</theme>";
		// @formatter:on

		assertEquals(contentXml, result);

	}

	@Test
	public void sucessWhenCreateXml_ThemeWithOneView() {

		Theme theme = new Theme();

		View view = new View();
		view.setName("ViewElement");

		theme.getViewElements().add(view);

		String contentXml = xstream.toXML(theme);
		// @formatter:off
		String result = "<theme>\n"
					  + "  <view name=\"ViewElement\"/>\n"
					  + "</theme>";
		// @formatter:on

		assertEquals(contentXml, result);

	}

	@Test
	public void sucessWhenCreateXml_ThemeWithTwoView() {

		Theme theme = new Theme();

		View view = new View();
		view.setName("ViewElement");

		View viewSecond = new View();
		viewSecond.setName("SecondViewElement");

		theme.getViewElements().add(view);
		theme.getViewElements().add(viewSecond);

		String contentXml = xstream.toXML(theme);
		// @formatter:off
		String result = "<theme>\n"
					  + "  <view name=\"ViewElement\"/>\n"
					  + "  <view name=\"SecondViewElement\"/>\n"
					  + "</theme>";
		// @formatter:on

		assertEquals(contentXml, result);

	}

	@Test
	public void sucessWhenCreateXml_ThemeWithOneInclude() {

		Theme theme = new Theme();

		theme.getIncludes().add("IncludeName");

		String contentXml = xstream.toXML(theme);
		// @formatter:off
		String result = "<theme>\n"
					  + "  <include>IncludeName</include>\n"
					  + "</theme>";
		// @formatter:on

		assertEquals(contentXml, result);

	}

	@Test
	public void sucessWhenCreateXml_ThemeWithTwoInclude() {

		Theme theme = new Theme();

		theme.getIncludes().add("IncludeName");
		theme.getIncludes().add("SecondIncludeName");

		String contentXml = xstream.toXML(theme);
		// @formatter:off
		String result = "<theme>\n"
					  + "  <include>IncludeName</include>\n"
					  + "  <include>SecondIncludeName</include>\n"
					  + "</theme>";
		// @formatter:on

		assertEquals(contentXml, result);

	}

	@Test
	void sucessWhenConvertToJava_Theme() {

		// @formatter:off
		String result = "<theme>\n"
					  + "  <formatVersion>4</formatVersion>\n"
					  + "  <include>Include One</include>\n"
					  + "  <include>Include Two</include>\n"
					  + "  <view name=\"ViewOne\"/>\n"
					  + "  <view name=\"ViewTwo\"/>\n"
					  + "</theme>";
		// @formatter:on

		Theme themeObj = (Theme) xstream.fromXML(result);

		assertNotNull(themeObj);
		assertEquals(themeObj.getFormatVersion(), 4);

		View viewOne = themeObj.getViewElements().get(0);
		assertInstanceOf(View.class, viewOne);
		assertEquals(viewOne.getName(), "ViewOne");

		View viewTwo = themeObj.getViewElements().get(1);
		assertInstanceOf(View.class, viewTwo);
		assertEquals(viewTwo.getName(), "ViewTwo");

	}

}

@XStreamAlias("theme")
class Theme extends AbstractTheme {
	private static final long serialVersionUID = 1L;
}
