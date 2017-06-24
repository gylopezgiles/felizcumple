package com.example.felizcumple.controllers;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.felizcumple.entities.FriendEntity;
import com.example.felizcumple.entities.RespuestaEntity;
import com.example.felizcumple.repositories.FriendsRepository;
import com.example.felizcumple.services.FriendServices;

@Controller
public class FriendsController {

    @Autowired
    FriendsRepository friendRepo;

    @Autowired
    private FriendServices friendServices;
    
    @RequestMapping(value = "/api/cumple", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaEntity> registrarCumple(@RequestParam String nombre,
                                                           @RequestParam String fechaNacimiento,
                                                           @RequestParam String telefono) throws ParseException {
        RespuestaEntity respuesta = new RespuestaEntity();
        respuesta.setMensaje(friendServices.registerFriend(nombre, telefono, fechaNacimiento));
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/api/cumple", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaEntity> actualizarTelefono(@RequestParam String nombre,
                                                              @RequestParam String telefono) {
        RespuestaEntity respuesta = new RespuestaEntity();
        respuesta.setMensaje(friendServices.updatePhone(nombre, telefono));
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @RequestMapping(value = "/api/cumples", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<FriendEntity>> obtenerAmigos() {
        return new ResponseEntity<Collection<FriendEntity>>(friendRepo.findAll(), HttpStatus.OK);
    }


    @RequestMapping(value = "/api/cumple", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FriendEntity> obtenerCumplePorAmigo(@RequestParam String nombre) {
        return new ResponseEntity<>(friendRepo.findFriendEntityByNombre(nombre), HttpStatus.OK);
    }



    @RequestMapping(value = "/api/cumple", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaEntity> borrarAmigo(@RequestParam String nombre) {
        RespuestaEntity respuesta = new RespuestaEntity();
        respuesta.setMensaje(friendServices.deleteFriend(nombre));
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}
