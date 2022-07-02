package com.arcaroms.theme.os.batocera.xml.feature;

import java.io.Serializable;

import com.arcaroms.theme.os.emulationstation.xml.View;

public interface BatoceraFeature extends Serializable {

	public View getView();

	public void setView(View view);

	public abstract String getSupported();

}
