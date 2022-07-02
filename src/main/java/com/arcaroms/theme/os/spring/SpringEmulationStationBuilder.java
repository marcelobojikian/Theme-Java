package com.arcaroms.theme.os.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.arcaroms.theme.os.common.xml.theme.AbstractTheme;
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

@Component
public class SpringEmulationStationBuilder extends SpringCommonBuilder {
	
	public SpringEmulationStationBuilder(ApplicationContext context) {
		super(context);
	}

	@Override
	public <T extends AbstractTheme> T createTheme(Class<T> clazz) {
		return context.getBean("emulationStation", clazz);
	}
	
	@Bean("emulationStation")
	public EmulationStationTheme getEmulationStationTheme() {
		return new EmulationStationTheme();
	}
	
	@Bean("view")
	public View getView() {
		return new View();
	}
	
	@Bean("datetime")
	public Datetime getDatetime() {
		return new Datetime();
	}

	@Bean("helpsystem")
	public HelpSystem getHelpSystem() {
		return new HelpSystem();
	}
	
	@Bean("image")
	public Image getImage() {
		return new Image();
	}
	
	@Bean("ninepatch")
	public Ninepatch getNinepatch() {
		return new Ninepatch();
	}
	
	@Bean("rating")
	public Rating getRating() {
		return new Rating();
	}
	
	@Bean("sound")
	public Sound getSound() {
		return new Sound();
	}
	
	@Bean("text")
	public Text getText() {
		return new Text();
	}
	
	@Bean("textlist")
	public TextList getTextList() {
		return new TextList();
	}
	
	@Bean("video")
	public Video getVideo() {
		return new Video();
	}

}
