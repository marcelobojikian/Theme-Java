package com.arcaroms.theme.os.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.arcaroms.theme.os.batocera.xml.theme.BatoceraTheme;
import com.arcaroms.theme.os.common.builder.CommonBuilder;
import com.arcaroms.theme.os.common.provider.CommonProvider;
import com.arcaroms.theme.os.emulationstation.xml.View;
import com.arcaroms.theme.os.emulationstation.xml.element.Datetime;
import com.arcaroms.theme.os.emulationstation.xml.element.HelpSystem;
import com.arcaroms.theme.os.emulationstation.xml.element.Image;
import com.arcaroms.theme.os.emulationstation.xml.element.Ninepatch;
import com.arcaroms.theme.os.emulationstation.xml.element.Rating;
import com.arcaroms.theme.os.emulationstation.xml.element.Sound;
import com.arcaroms.theme.os.emulationstation.xml.element.Text;
import com.arcaroms.theme.os.emulationstation.xml.element.TextList;
import com.arcaroms.theme.os.emulationstation.xml.element.Video;
import com.arcaroms.theme.os.spring.SpringBatoceraBuilder;

//@SpringBootTest
class EmulationEstationProviderTest {

//	@Autowired
//	private ApplicationContext context;
//	
//	private FactoryTestUtil tester;
//
//	@BeforeEach
//	public void init() {
//
//		CommonBuilder creator = new SpringBatoceraBuilder(context);
//		CommonProvider factory = new CommonProvider(creator);
//		tester = new FactoryTestUtil(factory);
//		
//	}
//
//	@Test
//	void sucessWhenCreateTheme() {
//		tester.testTheme(BatoceraTheme.class);
//	}
//
//	@Test
//	void sucessWhenCreateView() {
//		tester.testView(View.class);
//	}
//
//	@Test
//	void sucessWhenCreateElement() {
//
//		tester.testElement(Text.class);
//		tester.testElement(Image.class);
//		tester.testElement(Sound.class);
//		tester.testElement(Rating.class);
//		tester.testElement(Video.class);
//		tester.testElement(TextList.class);
//		tester.testElement(Ninepatch.class);
//		tester.testElement(HelpSystem.class);
//		tester.testElement(Datetime.class);
//		
//	}

}
