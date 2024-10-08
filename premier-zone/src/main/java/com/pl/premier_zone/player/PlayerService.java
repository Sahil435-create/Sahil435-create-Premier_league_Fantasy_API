package com.pl.premier_zone.player;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    //find all players

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    //get all players from the same team
    public List<Player> getPlayerFromTeam(String teamName){
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeamName()))
                .collect(Collectors.toList());
    }

    //get specific players by their name
    public List<Player> getPlayersByName(String searchtext){
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchtext.toLowerCase()))
                .collect(Collectors.toList());
    }

    //get players by position
    public List<Player> getPlayersByPosition(String position) {
    return playerRepository.findAll().stream()
            .filter(player -> player.getPosition() != null && player.getPosition().toLowerCase().contains(position.toLowerCase()))
            .collect(Collectors.toList());
}



    //get players by nationality
    public List<Player> getPlayersByNation(String nation){
        return playerRepository.findAll().stream()
                .filter(Player -> Player.getNation().toLowerCase().contains(nation.toLowerCase()))
                .collect(Collectors.toList());
    }

    //get players by both team and position
    public List<Player> getPlayersByPositionAndTeam(String Team, String position){
        return playerRepository.findAll().stream()
                .filter(Player -> (Player.getTeamName().equals(Team)) && (Player.getPosition().equals(position)))
                .collect(Collectors.toList());
    }

    //add player

    public Player addPlayer(Player player){
        return playerRepository.save(player);
    }


    //update player

        public Player updatePlayer( Player updatedPlayer){
            Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());

            if(existingPlayer.isPresent()){
                Player playerToUpdate = existingPlayer.get();
                //updating name, position, nation and team
                playerToUpdate.setName(updatedPlayer.getName());
                playerToUpdate.setPosition(updatedPlayer.getPosition());
                playerToUpdate.setNation(updatedPlayer.getNation());
                playerToUpdate.setTeamName(updatedPlayer.getTeamName());

                //save the updated player
                return playerRepository.save(playerToUpdate);

            }else{
                return null;
            }
        }

        @Transactional
        //delete a player
        public void deletePlayer(String playerName){
            playerRepository.deleteByName(playerName);
        }
}
