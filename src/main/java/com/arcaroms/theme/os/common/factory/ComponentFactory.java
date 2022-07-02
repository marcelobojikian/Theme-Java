package com.arcaroms.theme.os.common.factory;

import java.util.List;
import java.util.Map;

import com.arcaroms.theme.os.common.builder.CommonBuilder;
import com.arcaroms.theme.os.common.provider.CommonProvider;
import com.arcaroms.theme.os.common.xml.element.CommonElement;
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

public class ComponentFactory {
	
	private CommonProvider provider;

	public ComponentFactory(CommonBuilder builder) {
		provider = new CommonProvider(builder);
	}

	public ComponentFactory(CommonProvider provider) {
		this.provider = provider;
	}

	/**
	 * 
	 * @return Theme
	 */	

	protected <T extends AbstractTheme> T createTheme(Class<T> clazz, Integer version) {
		return provider.createTheme(clazz, version);
	}
	
	protected <T extends AbstractTheme> T createTheme(Class<T> clazz, Integer version, String... includes) {
		return provider.createTheme(clazz, version, includes);
	}

	/**
	 * 
	 * @return View
	 */	
	public View createView(String name) {
		return provider.createView(View.class, name);
	}

	public View createView(String name, CommonElement... elements) {
		return provider.createView(View.class, name, elements);
	}

	public View createView(String name, List<CommonElement> elements) {
		return provider.createView(View.class, name, elements);
	}
	
	/**
	 * 
	 * @return TextList
	 */	
	public TextList createTextList(String name) {
		return provider.createElement(TextList.class, name);
	}
	
	public TextList createTextList(String name, boolean extra) {
		return provider.createElement(TextList.class, name, extra);
	}
	
	public TextList createTextList(String name, Map<String, String> attributes) {
		return provider.createElement(TextList.class, name, attributes);
	}
	
	public TextList createTextList(String name, boolean extra, Map<String, String> attributes) {
		return provider.createElement(TextList.class, name, attributes);
	}
	
	/**
	 * 
	 * @return Ninepatch
	 */	
	public Ninepatch createNinepatch(String name) {
		return provider.createElement(Ninepatch.class, name);
	}
	
	public Ninepatch createNinepatch(String name, boolean extra) {
		return provider.createElement(Ninepatch.class, name, extra);
	}
	
	public Ninepatch createNinepatch(String name, Map<String, String> attributes) {
		return provider.createElement(Ninepatch.class, name, attributes);
	}
	
	public Ninepatch createNinepatch(String name, boolean extra, Map<String, String> attributes) {
		return provider.createElement(Ninepatch.class, name, attributes);
	}
	
	/**
	 * 
	 * @return HelpSystem
	 */	
	public HelpSystem createHelpSystem(String name) {
		return provider.createElement(HelpSystem.class, name);
	}
	
	public HelpSystem createHelpSystem(String name, boolean extra) {
		return provider.createElement(HelpSystem.class, name, extra);
	}
	
	public HelpSystem createHelpSystem(String name, Map<String, String> attributes) {
		return provider.createElement(HelpSystem.class, name, attributes);
	}
	
	public HelpSystem createHelpSystem(String name, boolean extra, Map<String, String> attributes) {
		return provider.createElement(HelpSystem.class, name, extra, attributes);
	}
	
	/**
	 * 
	 * @return Text
	 */
	public Text createText(String name) {
		return provider.createElement(Text.class, name);
	}
	
	public Text createText(String name, boolean extra) {
		return provider.createElement(Text.class, name, extra);
	}
	
	public Text createText(String name, Map<String, String> attributes) {
		return provider.createElement(Text.class, name, attributes);
	}
	
	public Text createText(String name, boolean extra, Map<String, String> attributes) {
		return provider.createElement(Text.class, name, extra, attributes);
	}
	
	/**
	 * 
	 * @return Rating
	 */
	public Rating createRating(String name) {
		return provider.createElement(Rating.class, name);
	}
	
	public Rating createRating(String name, boolean extra) {
		return provider.createElement(Rating.class, name, extra);
	}
	
	public Rating createRating(String name, Map<String, String> attributes) {
		return provider.createElement(Rating.class, name, attributes);
	}
	
	public Rating createRating(String name, boolean extra, Map<String, String> attributes) {
		return provider.createElement(Rating.class, name, extra, attributes);
	}
	
	/**
	 * 
	 * @return Datetime
	 */
	public Datetime createDatetime(String name) {
		return provider.createElement(Datetime.class, name);
	}
	
	public Datetime createDatetime(String name, boolean extra) {
		return provider.createElement(Datetime.class, name, extra);
	}
	
	public Datetime createDatetime(String name, Map<String, String> attributes) {
		return provider.createElement(Datetime.class, name, attributes);
	}
	
	public Datetime createDatetime(String name, boolean extra, Map<String, String> attributes) {
		return provider.createElement(Datetime.class, name, extra, attributes);
	}
	
	/**
	 * 
	 * @return Image
	 */
	public Image createImage(String name) {
		return provider.createElement(Image.class, name);
	}
	
	public Image createImage(String name, boolean extra) {
		return provider.createElement(Image.class, name, extra);
	}
	
	public Image createImage(String name, Map<String, String> attributes) {
		return provider.createElement(Image.class, name, attributes);
	}
	
	public Image createImage(String name, boolean extra, Map<String, String> attributes) {
		return provider.createElement(Image.class, name, extra, attributes);
	}
	
	/**
	 * 
	 * @return Sound
	 */
	public Sound createSound(String name) {
		return provider.createElement(Sound.class, name);
	}
	
	public Sound createSound(String name, boolean extra) {
		return provider.createElement(Sound.class, name, extra);
	}
	
	public Sound createSound(String name, Map<String, String> attributes) {
		return provider.createElement(Sound.class, name, attributes);
	}
	
	public Sound createSound(String name, boolean extra, Map<String, String> attributes) {
		return provider.createElement(Sound.class, name, extra, attributes);
	}
	
	/**
	 * 
	 * @return Video
	 */
	public Video createVideo(String name) {
		return provider.createElement(Video.class, name);
	}
	
	public Video createVideo(String name, boolean extra) {
		return provider.createElement(Video.class, name, extra);
	}
	
	public Video createVideo(String name, Map<String, String> attributes) {
		return provider.createElement(Video.class, name, attributes);
	}
	
	public Video createVideo(String name, boolean extra, Map<String, String> attributes) {
		return provider.createElement(Video.class, name, extra, attributes);
	}

}
