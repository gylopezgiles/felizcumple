package com.example.felizcumple.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.felizcumple.entities.FriendEntity;
import com.example.felizcumple.repositories.FriendsRepository;
import org.springframework.stereotype.Service;

@Service
public class FriendServices {

	@Autowired
	FriendsRepository friendRepo;
	
	public String registerFriend(String name, String phone, String birthday) throws ParseException{
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = formatter.parse(birthday);
		FriendEntity friend = new FriendEntity(name, phone, date);
		friendRepo.save(friend);
		return "Cumple guardado correctamente";
	}
	
	public String deleteFriend(String name){
		return "Cumple borrado correctamente";
	}
	
	public String updatePhone(String name, String phone){
		FriendEntity friend;
		friend = friendRepo.findFriendEntityByNombre(name);
		friend.setTelefono(phone);
		friendRepo.save(friend);
		return "Telefono actualizado correctamente";
	}
}
