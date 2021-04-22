package Qatar.cup.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Qatar.cup.models.Player;
import Qatar.cup.service.PlayerService;


@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class PlayerController {

        @Autowired
        PlayerService playerServ ;




        @GetMapping("/getPlayers")
        public List<Player> getAllPlayers(){
                return playerServ.getAllPlayers();

        }

        @PostMapping("/addPlayer")
        public Player addPlayer(@RequestBody Player player) {

                return playerServ.savePlayer(player);
        }


        @GetMapping("/getPlayer/{id}")
        public Optional<Player> getAllPlayers(@PathVariable Long id){
                return playerServ.getPlayer(id);

        }

        @DeleteMapping("/deletePlayer/{id}")
        public Optional<Player> deletePlayer(@PathVariable Long id){
            return playerServ.deletePlayer(id);

    }

        @DeleteMapping("/deleteAllPlayers")
        public String deleteAllPlayers() {

        	playerServ.deletePlayers();

            return "All players are deleted";
        }

        @PutMapping("/updatePlayer")
        public Player updatePlayer(@RequestBody Player player) {

            return playerServ.updatePlayer(player);
        }



}
