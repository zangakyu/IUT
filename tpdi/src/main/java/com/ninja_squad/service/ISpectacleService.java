package com.ninja_squad.service;

import java.io.IOException;
import java.util.List;

public interface ISpectacleService {

	public List<String> findSpectacle(String spectacleName) throws IOException;
	public boolean createSpectale(String spectacleName) throws IOException;
}
