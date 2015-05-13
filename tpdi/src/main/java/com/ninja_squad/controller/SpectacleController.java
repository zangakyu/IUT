package com.ninja_squad.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ninja_squad.dao.SpectacleDAO;

public class SpectacleController {

	SpectacleDAO dao = new SpectacleDAO();

	public List<String> findSpectacle(String spectacleName) throws IOException {
		spectacleName = getSpectacle(spectacleName);
		List<String> spectacles = dao.getSpectacles();
		List<String> spectaclesFound = new ArrayList<String>();

		for (String spectacle : spectacles) {
			if (spectacle.contains(spectacleName)) {
				spectaclesFound.add(spectacle);
			}
		}
		return spectaclesFound;
	}

	public boolean createSpectale(String spectacleName) throws IOException {
		spectacleName = getSpectacle(spectacleName);
		if (!(dao.getSpectacles().contains(spectacleName))) {
			dao.writeFile(spectacleName);
			return true;
		} else {
			return false;
		}
	}

	public static String getSpectacle(String s) {
		String spectacle = "";
		if (s.contains(" ")) {
			spectacle = s.substring(s.indexOf(" ") + 1);
		}
		return spectacle;
	}

}
