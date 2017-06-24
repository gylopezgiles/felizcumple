package com.example.felizcumple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.felizcumple.entities.FriendEntity;

@Repository
public interface FriendsRepository extends JpaRepository<FriendEntity, Long>{

	FriendEntity findFriendEntityByNombre(String nombre);
}
