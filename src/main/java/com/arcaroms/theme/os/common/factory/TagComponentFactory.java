package com.arcaroms.theme.os.common.factory;

import com.arcaroms.theme.os.common.builder.CommonBuilder;
import com.arcaroms.theme.os.common.converter.TagComponentConverter;
import com.arcaroms.theme.os.common.xml.element.AbstractElement;
import com.arcaroms.theme.os.common.xml.view.AbstractViewElement;
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

public class TagComponentFactory implements TagComponentConverter {
	
	private CommonBuilder builder;
	
	public TagComponentFactory(CommonBuilder builder) {
		this.builder = builder;
	}

	@Override
	public AbstractViewElement createView(String tagName) {
		switch (tagName) {
		case "view":
			return builder.createView(View.class);
		default:
			throw new RuntimeException("Fail to create view " + tagName);
		}
	}

	@Override
	public AbstractElement createElement(String tagName) {
		switch (tagName) {
		case "text":
			return builder.createElement(Text.class);
		case "image":
			return builder.createElement(Image.class);
		case "datetime":
			return builder.createElement(Datetime.class);
		case "helpsystem":
			return builder.createElement(HelpSystem.class);
		case "ninepatch":
			return builder.createElement(Ninepatch.class);
		case "rating":
			return builder.createElement(Rating.class);
		case "sound":
			return builder.createElement(Sound.class);
		case "textlist":
			return builder.createElement(TextList.class);
		case "video":
			return builder.createElement(Video.class);
		default:
			throw new RuntimeException("Fail to create element " + tagName);
		}
	}

}
