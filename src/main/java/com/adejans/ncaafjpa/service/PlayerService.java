package com.adejans.ncaafjpa.service;

import com.adejans.ncaafjpa.dao.PlayerRepository;
import com.adejans.ncaafjpa.model.Player;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public void save(Player player){
        playerRepository.save(player);
    }

    public Player getById(int id){
        Player byId = playerRepository.findById(id);
        if(byId == null) throw new IllegalStateException();
        return byId;
    }

    public List<Player> getBigBoys(){
        return playerRepository.getBigPlayers();
    }
}
