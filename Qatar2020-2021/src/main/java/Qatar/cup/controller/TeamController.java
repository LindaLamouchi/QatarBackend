package Qatar.cup.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Qatar.cup.models.Team;
import Qatar.cup.service.TeamService;



@RestController
public class TeamController {

        @Autowired
       TeamService teamServ ;




        @GetMapping("/getTeams")
        public List<Team> getAllTeams(){
                return teamServ.getAllTeams();

        }

        @PostMapping("/addTeam")
        public Team addTeam(@RequestBody Team team) {

                return teamServ.saveTeam(team);
        }


        @GetMapping("/getTeam/{id}")
        public Optional<Team> getAllTeams(@PathVariable Long id){
                return teamServ.getTeam(id);

        }

        @DeleteMapping("/deleteTeam/{id}")
        public Optional<Team> deleteTeam(@PathVariable Long id){
            return teamServ.deleteTeam(id);

    }

        @DeleteMapping("/deleteAllTeams")
        public String deleteAllTeams() {

        	teamServ.deleteTeams();

            return "All Teams are deleted";
        }

        @PutMapping("/updateTeam")
        public Team updateTeam(@RequestBody Team team) {

            return teamServ.updateTeam(team);
        }



}