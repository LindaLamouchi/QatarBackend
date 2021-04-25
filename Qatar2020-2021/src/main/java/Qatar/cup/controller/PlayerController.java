package Qatar.cup.controller;

import java.util.ArrayList;
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
import Qatar.cup.models.Team;
import Qatar.cup.repositories.TeamRepository;
import Qatar.cup.service.PlayerService;
import Qatar.cup.service.TeamService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PlayerController {

        @Autowired
        PlayerService playerServ ;
        
        @Autowired
        TeamService teams;
        @Autowired
        TeamRepository teamrep;


        @GetMapping("/getPlayers")
        public List<Player> getAllPlayers(){
                return playerServ.getAllPlayers();

        }

        @PostMapping("/addPlayer")
        public Player addPlayer(@RequestBody Player player) {
        	TeamRepository teamRepository;
        		
                return playerServ.savePlayer(player);
        }


        @GetMapping("/getPlayer/{id}")
        public Optional<Player> getAllPlayers(@PathVariable Long id){
                return playerServ.getPlayer(id);

        }
        @GetMapping("/getPlayerT/{id}")
        public List<Player> getPlayersT(@PathVariable Long id){
        	List<Player> list=  playerServ.getAllPlayers();
        	List<Player> listf =new ArrayList<Player>();
        	
        	for (Player player : list) {
				if(player.getTeam()!=null)
        		if(player.getTeam().getIdTeam()==id)
					listf.add(player);
			}
        	
        	return listf;
        	
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
        
        @PutMapping("/SetTeamPlayer/{id}")
        public Player updatePlayerT(@RequestBody Player player,@PathVariable Long id) {
           
          
            Optional<Team> t= teamrep.findById(id);
            Team team=t.get();
            player.setTeam(team);
            return playerServ.updatePlayer(player);
        }



}
