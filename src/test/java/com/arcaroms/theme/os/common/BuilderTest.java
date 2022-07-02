package com.arcaroms.theme.os.common;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.arcaroms.theme.os.common.builder.CommonBuilder;
import com.arcaroms.theme.os.common.builder.ComponentBuilderDefault;
import com.arcaroms.theme.os.common.xml.element.AbstractElement;
import com.arcaroms.theme.os.common.xml.theme.AbstractTheme;
import com.arcaroms.theme.os.common.xml.view.AbstractViewElement;

public class BuilderTest {

	CommonBuilder builder;

	@BeforeEach
	public void init() {
		builder = new ComponentBuilderDefault();
	}

	@Test
	void sucessWhenCreateTheme() {
		ThemeTest theme = builder.createTheme(ThemeTest.class);
		assertNotNull(theme);
	}

	@Test
	void failWhenCreateThemeWithNullParameter() {
		assertThrows(NullPointerException.class, () -> {
			builder.createTheme(null);
		});
	}

	@Test
	void failWhenCreateThemeWithInvalidParameter() {
		assertThrows(RuntimeException.class, () -> {
			builder.createTheme(AbstractTheme.class);
		});
	}

	@Test
	void sucessWhenCreateView() {
		ViewTest view = builder.createView(ViewTest.class);
		assertNotNull(view);
	}

	@Test
	void failWhenCreateViewWithNullParameter() {
		assertThrows(NullPointerException.class, () -> {
			builder.createView(null);
		});
	}

	@Test
	void failWhenCreateViewWithInvalidParameter() {
		assertThrows(RuntimeException.class, () -> {
			builder.createView(AbstractViewElement.class);
		});
	}

	@Test
	void sucessWhenCreateElement() {
		ElementTest element = builder.createElement(ElementTest.class);
		assertNotNull(element);
	}

	@Test
	void failWhenCreateElementWithNullParameter() {
		assertThrows(NullPointerException.class, () -> {
			builder.createElement(null);
		});
	}

	@Test
	void failWhenCreateElementWithInvalidParameter() {
		assertThrows(RuntimeException.class, () -> {
			builder.createElement(AbstractElement.class);
		});
	}

}

class ThemeTest extends AbstractTheme {
	private static final long serialVersionUID = 1L;
}

class ViewTest extends AbstractViewElement {
	private static final long serialVersionUID = 1L;
}

class ElementTest extends AbstractElement {
	private static final long serialVersionUID = 1L;
}
