package com.arcaroms.theme.os.emulationstation.xml;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.arcaroms.theme.os.common.converter.ElementConverter;
import com.arcaroms.theme.os.emulationstation.factory.EmulationStationFactory;
import com.arcaroms.theme.os.emulationstation.xml.theme.EmulationStationTheme;
import com.arcaroms.theme.os.util.XStreamUtil;
import com.thoughtworks.xstream.XStream;

@SpringBootTest
public class ThemeTest {

	XStream xstream;
	
	@Autowired
	ElementConverter elementConverter;

	@Autowired
	EmulationStationFactory factory;

	@BeforeEach
	public void init() {
		xstream = XStreamUtil.createForElements(elementConverter);
	}
	
	public void generalTest() {
		
		Map<String, String> attributes = new HashMap<>();
		attributes.put("TESTE_123", "true");
		
		EmulationStationTheme theme = factory.createTheme(4)
				.addViews(
					factory.createView("system, basic, detailed, video")
						.addElements(
								factory.createImage("background_all", true)//,
//								factory.createHelpSystem()
						),
					factory.createView("basic, detailed, video")
						.addElements(
								factory.createImage("logo"),
								factory.createText("logoText"),
								factory.createImage("logo_seperator", true),
								factory.createImage("help_seperator", true)
						),						
					factory.createView("basic")
						.addElements(
//								factory.createTextList()
						),
					factory.createView("detailed")
						.addElements(
								factory.createImage("md_image")
						),
					factory.createView("detailed, video")
						.addElements(
//								factory.createTextList(),
								factory.createImage("bezel", true),
								factory.createText("md_description, md_developer, md_favorite, md_genre, md_hidden, md_kidgame, md_lastplayed, md_playcount, md_players, md_publisher, md_releasedate, md_lbl_developer, md_lbl_genre, md_lbl_lastplayed, md_lbl_playcount, md_lbl_players, md_lbl_publisher, md_lbl_rating, md_lbl_releasedate"),
								// <!-- left side metadata -->
								factory.createText("md_lbl_rating"),
								factory.createRating("md_rating"),
								factory.createText("md_lbl_players"),
								factory.createText("md_players"),
								factory.createText("md_lbl_genre"),
								factory.createText("md_genre"),
								factory.createText("md_lbl_releasedate"),
								factory.createDatetime("md_releasedate"),
								// <!-- right side metadata -->
								factory.createText("md_lbl_developer"),
								factory.createText("md_developer"),
								factory.createText("md_lbl_publisher"),
								factory.createText("md_publisher"),
								factory.createText("md_lbl_playcount"),
								factory.createText("md_playcount"),
								factory.createText("md_lbl_lastplayed"),
								factory.createDatetime("md_lastplayed"),
								factory.createText("md_description")
						)
				);
		
	}

}
