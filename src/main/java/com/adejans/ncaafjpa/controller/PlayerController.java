package com.adejans.ncaafjpa.controller;

import com.adejans.ncaafjpa.model.Player;
import com.adejans.ncaafjpa.service.PlayerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/v1/player")
public class PlayerController {
    private final PlayerService playerService;


    @PostMapping
    public void post(@RequestBody Player player){ // look in JSON request body for a player object
        log.info("Incoming player {}", player);
        playerService.save(player);
    }

    @GetMapping("{id}")
    public Player get(@PathVariable Integer id){
        log.info("Fetching player w/ id {}", id);
        return playerService.getById(id);
    }

    @GetMapping("/big")
    public List<Player> getBigBoys(){
        log.info("Fetching the big boys");
        return playerService.getBigBoys();
    }
}
