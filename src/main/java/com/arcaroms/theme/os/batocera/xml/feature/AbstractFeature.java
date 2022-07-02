package com.arcaroms.theme.os.batocera.xml.feature;

import java.util.ArrayList;
import java.util.Arrays;

import com.arcaroms.theme.os.common.xml.element.CommonElement;
import com.arcaroms.theme.os.emulationstation.xml.View;

public abstract class AbstractFeature implements BatoceraFeature {

	private View view;

	@Override
	public View getView() {
		return view;
	}

	@Override
	public void setView(View view) {
		this.view = view;
	}

	public AbstractFeature addElements(CommonElement... elements) {
		view.getElements().addAll(new ArrayList<>(Arrays.asList(elements)));
		return this;
	}

	public void addElement(CommonElement element) {
		view.getElements().add(element);
	}

}
