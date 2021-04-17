package Qatar.cup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Qatar.cup.models.Player;
import Qatar.cup.repositories.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepo ;

    public List<Player> getAllPlayers(){

            return playerRepo.findAll();

    }

    public Player savePlayer(Player player) {

        return playerRepo.save(player);

    }

    public Optional<Player> getPlayer(Long id) {

        return playerRepo.findById(id);
    }

    public Optional<Player> deletePlayer(Long id) {
        // TODO Auto-generated method stub
        Optional<Player> player = playerRepo.findById(id);
        playerRepo.deleteById(id);
        return player;
    }

    public void deletePlayers() {

    	playerRepo.deleteAll();

    }

    public Player updatePlayer(Player player) {

        return playerRepo.save(player);
    }



}