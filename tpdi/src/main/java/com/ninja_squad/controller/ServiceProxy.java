package com.ninja_squad.controller;

import java.io.IOException;
import java.util.List;

public class ServiceProxy implements ISpectacleService {

	
	public SpectacleService spectacleService;
	
	public ServiceProxy(SpectacleService spectacleService){
		this.spectacleService = spectacleService;
	}
	
	@Override
	public List<String> findSpectacle(String spectacleName) throws IOException {
		System.out.println("début de transaction");
		try{
			List<String> result = spectacleService.findSpectacle(spectacleName);
			System.out.println("commit de transaction");
			return result;
		}catch(Exception ex){
			System.out.println("rollback de la transaction");
			throw ex;
		}
	}

	@Override
	public boolean createSpectale(String spectacleName) throws IOException {
		System.out.println("début de transaction");
		if(spectacleService.createSpectale(spectacleName)){
			System.out.println("commit de transaction");
			return true;
		}
		else{
			System.out.println("rollback de la transaction");	
			return false;
		}
	}

}
