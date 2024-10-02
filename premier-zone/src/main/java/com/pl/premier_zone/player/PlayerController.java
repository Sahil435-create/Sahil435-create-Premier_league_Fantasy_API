package com.pl.premier_zone.player;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    //For displaying players based on the parameters passed
    @GetMapping
    public List<Player> getPlayer(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String nation){
        if (team != null && position != null){
            return playerService.getPlayersByPositionAndTeam(team, position);
        }else if(team != null){
            return playerService.getPlayerFromTeam(team);
        }else if(nation != null){
            return playerService.getPlayersByNation(nation);
        }else if(name != null){
            return playerService.getPlayersByName(name);
        }else if(position != null){
            return playerService.getPlayersByPosition(position);
        }else{
            return playerService.getPlayers();
        }
    }

    //for adding a player to the Repository

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    //For updating the Player
    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        Player resultplayer = playerService.updatePlayer(player);

        if(resultplayer != null){
            return new ResponseEntity<>(resultplayer, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //For Deleting a Player by PlayerName
    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName){
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("Player deleted Successfully", HttpStatus.OK);
    }

}
