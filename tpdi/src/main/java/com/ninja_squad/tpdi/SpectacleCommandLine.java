package com.ninja_squad.tpdi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

public class SpectacleCommandLine {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		boolean quit = false;
		Scanner in = new Scanner(System.in);
		String command;
		String filePath = "./spectacles.txt";
		String logPath = "./spectaclesLog.txt";

		while (quit == false) {
			System.out.print("Enter une commande :\n>");
			command = in.nextLine();
			if (command != null) {
				if (command.startsWith("trouver")) {

					findSpectacle(getSpectacle(command), filePath);

				} else if (command.startsWith("créer")) {
					try (FileInputStream fstream = new FileInputStream(filePath);
							BufferedReader br = new BufferedReader(new InputStreamReader(fstream))) {

						String spectacle = getSpectacle(command);

						boolean exists = false;
						String strLine;

						while ((strLine = br.readLine()) != null) {
							if (strLine.equals(spectacle)) {
								exists = true;
							}
						}
						if (!exists) {
							writeFile(command, filePath);
							writeFile(command + " " + (new Date()).toString(), logPath);
						} else {
							System.out.println("Existe déjà");
						}
					}

				} else if (command.equals("quitter")) {
					System.out.println("bye");
					quit = true;
					in.close();
				}
			}
		}
	}

	private static void findSpectacle(String spectacle, String filePath) throws IOException {
		try (FileInputStream fstream = new FileInputStream(filePath); BufferedReader br = new BufferedReader(new InputStreamReader(fstream))) {

			String strLine;
			while ((strLine = br.readLine()) != null) {

				if (strLine.contains(spectacle)) {
					System.out.println(strLine);
				}
			}
		}

	}

	public static String getSpectacle(String s) {
		String spectacle = "";
		if (s.contains(" ")) {
			spectacle = s.substring(s.indexOf(" ") + 1);
		}
		return spectacle;
	}

	public static void writeFile(String toWrite, String filePath) throws IOException {
		FileWriter fileWritter = new FileWriter(filePath, true);
		BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
		bufferWritter.write(getSpectacle(toWrite) + "\n");
		bufferWritter.close();
	}
}
