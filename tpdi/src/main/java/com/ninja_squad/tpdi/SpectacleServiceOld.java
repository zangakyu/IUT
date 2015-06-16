package com.ninja_squad.tpdi;

import java.io.IOException;
import java.util.List;

import com.ninja_squad.controller.ISpectacleService;
import com.ninja_squad.controller.SpectacleService;
import com.ninja_squad.dao.SpectacleDAO;

public class SpectacleServiceOld implements ISpectacleService {
	SpectacleDAO dao = new SpectacleDAO();
	SpectacleService spectacleController = new SpectacleService(dao);
	
	public List<String> findSpectacle(String spectacleName) throws IOException {
		System.out.println("début de transaction");
		try{
			List<String> result = spectacleController.findSpectacle(spectacleName);
			System.out.println("commit de transaction");
			return result;
		}catch(Exception ex){
			System.out.println("rollback de la transaction");
			throw ex;
		}
	}
	
	public boolean createSpectale(String spectacleName) throws IOException {
		System.out.println("début de transaction");
		if(spectacleController.createSpectale(spectacleName)){
			System.out.println("commit de transaction");
			return true;
		}
		else{
			System.out.println("rollback de la transaction");	
			return false;
		}
	}
}
