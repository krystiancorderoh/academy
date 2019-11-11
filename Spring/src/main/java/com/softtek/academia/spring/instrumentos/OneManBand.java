package com.softtek.academia.spring.instrumentos;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OneManBand {
	private List<Instruments> instrumentos;
	private Map<String, Instruments> instrumentosMap;
	private double songNumber;
	
	public void playSong() {
		System.out.println("Playing song number "+songNumber);
		for(Instruments i: instrumentos) {
			i.play();
		}
		
		System.out.println("Now on map");
		for(Instruments i: instrumentosMap.values()) {
			i.play();
		}
	}

	public void setInstrumentos(List<Instruments> instrumentos) {
		this.instrumentos = instrumentos;
	}

	public void setInstrumentosMap(Map<String, Instruments> instrumentosMap) {
		this.instrumentosMap = instrumentosMap;
	}

	public void setSongNumber(double songNumber) {
		this.songNumber = songNumber;
	}
}
