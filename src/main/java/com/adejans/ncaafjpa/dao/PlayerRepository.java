package com.adejans.ncaafjpa.dao;

import com.adejans.ncaafjpa.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {
    Player findById(int id);

    @Query("SELECT new Player(p.id, p.name, p.weight) FROM Player p WHERE p.weight>250")
    List<Player> getBigPlayers();
}
