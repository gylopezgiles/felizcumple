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
		String respuesta = validateData(name, phone, birthday);
		if(respuesta == null){
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			Date date = formatter.parse(birthday);
			FriendEntity friend = new FriendEntity(name, phone, date);
			friendRepo.save(friend);
			respuesta = "Cumple guardado correctamente";
		}
		return respuesta;
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
	
	private String validateData(String name, String phone, String birthday){
		if (name.isEmpty()){
			return "No se puede guardar un cumpleaños con nombre vacio";
		}
		if (phone.isEmpty()){
			return "No se puede guardar un cumpleaños con telefono vacio";
		} else {
			if(!phone.matches("[0-9]+")){
				return "Numero de telefono inválido";
			}
		}
		if (birthday.isEmpty()){
			return "No se puede guardar un cumpleaños con fecha nacimiento vacio";
		} else {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			try {
				formatter.parse(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
				return "Formato de fecha incorrecto";
			}
		}
		return null;
	}
}
