package com.arcaroms.theme.os.spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.arcaroms.theme.os.batocera.provider.BatoceraProvider;
import com.arcaroms.theme.os.batocera.xml.feature.CarouselFeature;
import com.arcaroms.theme.os.batocera.xml.feature.VideoFeature;
import com.arcaroms.theme.os.batocera.xml.theme.BatoceraTheme;
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
import com.arcaroms.theme.os.util.xml.AbstractElementTester;
import com.arcaroms.theme.os.util.xml.AbstractFeatureTester;
import com.arcaroms.theme.os.util.xml.AbstractThemeTester;
import com.arcaroms.theme.os.util.xml.AbstractViewTester;

@SpringBootTest
public class BatoceraProviderTest {

	@Autowired
	private ApplicationContext context;
	
	private BatoceraProvider provider;

	@BeforeEach
	public void init() {

		SpringBatoceraBuilder builder = new SpringBatoceraBuilder(context);
		provider = new BatoceraProvider(builder);
		
	}

	@Test
	void sucessWhenCreateTheme() {
		
		AbstractThemeTester tester = new AbstractThemeTester(provider); 
		
		tester.testTheme(BatoceraTheme.class);
	}

	@Test
	void sucessWhenCreateFeature() {
		
		AbstractFeatureTester tester = new AbstractFeatureTester(provider);
		
		tester.testFeature(CarouselFeature.class, "carousel");
		tester.testFeature(VideoFeature.class, "video");
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
