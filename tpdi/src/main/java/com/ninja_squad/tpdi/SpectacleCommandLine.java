package com.ninja_squad.tpdi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

import com.ninja_squad.controller.SpectacleController;
import com.ninja_squad.dao.SpectacleDAO;

public class SpectacleCommandLine {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		boolean quit = false;
		Scanner in = new Scanner(System.in);
		SpectacleDAO dao = new SpectacleDAO();
		SpectacleController spectacleController = new SpectacleController(dao);

		while (!quit) {
			System.out.print(">");
			String command = in.nextLine();
			if (command != null) {
				if (command.startsWith("trouver")) {
					for(String s : spectacleController.findSpectacle(command)){
						System.out.println(s);
					}

				} else if (command.startsWith("créer")) {
					
					if(spectacleController.createSpectale(command)){
						System.out.println("Spectacle ajouté");
					}
					else{
						System.out.println("Spectacle déjà existant");
					}				
					
				} else if (command.equals("quitter")) {
					System.out.println("bye");
					quit = true;
				}
			}
		}
		in.close();
	}
}
