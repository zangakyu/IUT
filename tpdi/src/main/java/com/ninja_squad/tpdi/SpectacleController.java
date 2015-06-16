package com.ninja_squad.tpdi;

import java.io.IOException;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ninja_squad.dao.SpectacleDAO;
import com.ninja_squad.service.ISpectacleService;
import com.ninja_squad.service.ServiceProxy;
import com.ninja_squad.service.SpectacleService;


public class SpectacleController {

	static ISpectacleService service;
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		boolean quit = false;
		Scanner in = new Scanner(System.in);
//		SpectacleService spectacleService = new SpectacleService(new SpectacleDAO());
		//service = new ServiceProxy(spectacleService);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        service = context.getBean(SpectacleService.class);
        
		while (!quit) {
			System.out.print(">");
			String command = in.nextLine();
			if (command != null) {
				if (command.startsWith("trouver")) {
					for(String s : service.findSpectacle(command)){
						System.out.println(s);
					}

				} else if (command.startsWith("créer")) {
					
					if(service.createSpectale(command)){
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
