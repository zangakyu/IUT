package com.ninja_squad.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SpectacleDAO {
	String filePath = "./spectacles.txt";
	
	public void writeSpectacle(String toWrite) throws IOException {
		try (FileWriter fileWritter = new FileWriter(filePath, true)) {
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(toWrite + "\n");
			bufferWritter.close();
		}
	}

	public List<String> getSpectacles() throws IOException {
		try (FileInputStream fstream = new FileInputStream(filePath); BufferedReader br = new BufferedReader(new InputStreamReader(fstream))) {
			List<String> spectacles = new ArrayList<String>();
			String strLine;
			while ((strLine = br.readLine()) != null) {
				spectacles.add(strLine);
			}
			return spectacles;
		}
	}
}
