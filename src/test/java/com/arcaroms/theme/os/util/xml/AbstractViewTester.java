package com.arcaroms.theme.os.util.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.arcaroms.theme.os.common.provider.ViewProvider;
import com.arcaroms.theme.os.common.xml.element.CommonElement;
import com.arcaroms.theme.os.common.xml.view.AbstractViewElement;
import com.arcaroms.theme.os.common.xml.view.ViewElement;
import com.arcaroms.theme.os.emulationstation.xml.element.Image;
import com.arcaroms.theme.os.emulationstation.xml.element.Text;

public class AbstractViewTester {
	
	final ViewProvider provider;
	
	public AbstractViewTester(ViewProvider provider){
		this.provider = provider;
	}
	
	public <T extends AbstractViewElement> void testView(Class<T> clazz) {

		testView(clazz, "NameView");
		
		Text text = new Text();
		text.setName("FirstElement");
		
		testView(clazz, "NameElement", text);
		
		Image image = new Image();
		image.setName("SecondElement");
		
		List<CommonElement> asList = Arrays.asList(text, image);
		
		testView(clazz, "NameElement", asList);
		
	}
	
	<T extends AbstractViewElement> void testView(Class<T> clazz, String nameExpected) {
		AbstractViewElement view = provider.createView(clazz, nameExpected);
		assertInstanceOf(clazz, view);
		testViewContent(view, nameExpected);
	}
	
	<T extends AbstractViewElement> void testView(Class<T> clazz, String nameExpected, CommonElement... elementsExpected) {
		AbstractViewElement view = provider.createView(clazz, nameExpected, elementsExpected);
		assertInstanceOf(clazz, view);
		testViewContent(view, nameExpected, elementsExpected);
	}
	
	<T extends AbstractViewElement> void testView(Class<T> clazz, String nameExpected, List<CommonElement> elementsExpected) {
		AbstractViewElement view = provider.createView(clazz, nameExpected, elementsExpected);
		assertInstanceOf(clazz, view);
		testViewContent(view, nameExpected, elementsExpected);
	}
	
	public static <T extends ViewElement> void testViewContent(T view, String nameExpected, CommonElement... elementsExpected) {
		assertNotNull(view);
		assertEquals(nameExpected, view.getName());
		testViewElements(view, elementsExpected);
	}
	
	public static <T extends ViewElement> void testViewContent(T view, String nameExpected, List<CommonElement> elementsExpected) {
		assertNotNull(view);
		assertEquals(nameExpected, view.getName());
		testViewElements(view, elementsExpected);
	}
	
	private static <T extends ViewElement> void testViewElements(T view, CommonElement... elementsExpected) {
		assertNotNull(elementsExpected);
		List<CommonElement> viewElements = view.getElements();
		if(elementsExpected.length == 0) {
			assertTrue(viewElements.isEmpty());
		} else {
			for (int i = 0; i < elementsExpected.length; i++) {
				assertTrue(viewElements.contains(elementsExpected[i]));
			}
		}
	}
	
	private static <T extends ViewElement> void testViewElements(T view, List<CommonElement> elementsExpected) {
		assertNotNull(elementsExpected);
		List<CommonElement> viewElements = view.getElements();
		if(elementsExpected.isEmpty()) {
			assertTrue(viewElements.isEmpty());
		} else {
			Iterator<CommonElement> iterator = elementsExpected.iterator();
			while (iterator.hasNext()) {
				assertTrue(viewElements.contains(iterator.next()));	
			}
		}
	}

}
