package com.arcaroms.theme.os.common;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.arcaroms.theme.os.common.builder.CommonBuilder;
import com.arcaroms.theme.os.common.builder.ComponentBuilderDefault;
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
import com.arcaroms.theme.os.emulationstation.xml.theme.EmulationStationTheme;
import com.arcaroms.theme.os.util.xml.AbstractElementTester;
import com.arcaroms.theme.os.util.xml.AbstractThemeTester;
import com.arcaroms.theme.os.util.xml.AbstractViewTester;

public class ProviderTest {
	
	private CommonProvider provider;

	@BeforeEach
	public void init() {

		CommonBuilder creator = new ComponentBuilderDefault();
		provider = new CommonProvider(creator);
		
	}

	@Test
	void sucessWhenCreateTheme() {
		
		AbstractThemeTester tester = new AbstractThemeTester(provider); 
		
		tester.testTheme(EmulationStationTheme.class);
	}

	@Test
	void sucessWhenCreateView() {
		
		AbstractViewTester tester = new AbstractViewTester(provider);
		
		tester.testView(View.class);
	}

	@Test
	void sucessWhenCreateElement() {
		
		AbstractElementTester tester = new AbstractElementTester(provider);

		tester.testElement(Text.class);
		tester.testElement(Image.class);
		tester.testElement(Sound.class);
		tester.testElement(Rating.class);
		tester.testElement(Video.class);
		tester.testElement(TextList.class);
		tester.testElement(Ninepatch.class);
		tester.testElement(HelpSystem.class);
		tester.testElement(Datetime.class);
	}

}
