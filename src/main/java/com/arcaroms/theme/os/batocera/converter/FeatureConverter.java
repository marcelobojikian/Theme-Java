package com.arcaroms.theme.os.batocera.converter;

import com.arcaroms.theme.os.batocera.xml.feature.BatoceraFeature;
import com.arcaroms.theme.os.emulationstation.xml.View;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class FeatureConverter implements Converter {
	
	private FeatureTagConverter tagConverter;

	public FeatureConverter(FeatureTagConverter tagConverter) {
		this.tagConverter = tagConverter;
	}
	
	@Override
	public boolean canConvert(Class clazz) {
		return BatoceraFeature.class.isAssignableFrom(clazz);
	}
	
	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		
		String supported = reader.getAttribute("supported");
		BatoceraFeature feature = tagConverter.createFeature(supported);

		View view = (View) context.convertAnother(feature, View.class);
		feature.setView(view);

		return feature;
	}
	
	@Override
	public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
		BatoceraFeature feature = (BatoceraFeature) value;
		writer.addAttribute("supported", feature.getSupported());
		
		if(feature.getView() != null) {
			writer.startNode("view");
			context.convertAnother(feature.getView());
			writer.endNode();
		}
	}

}
