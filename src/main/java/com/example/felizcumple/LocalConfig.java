package com.example.felizcumple;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.felizcumple.entities.FriendEntity;
import com.example.felizcumple.repositories.FriendsRepository;

@Configuration
@Profile("local")
@Component("LocalConfig")
public class LocalConfig implements EnvironmentConfig {
	
	@Autowired
	FriendsRepository friendRepo;
	    
	@Override
	public void generateInitialData() {
		loadInitialData();

	}

	private void loadInitialData() {
		
	    FriendEntity[] friends = new FriendEntity[]{
	    		new FriendEntity("Gigi", "20741016", new GregorianCalendar(1990,7,31).getTime()),
	            new FriendEntity("Agos", "29741116", new GregorianCalendar(1990,1,8).getTime()),
	            new FriendEntity("Fede", "450741016", new GregorianCalendar(1988,4,14).getTime()),
	            new FriendEntity("Norma", "48336750", new GregorianCalendar(1960,9,5).getTime())
	    };
	    for (FriendEntity friend : friends) {
	    	friendRepo.save(friend);
	    }

	}

}
