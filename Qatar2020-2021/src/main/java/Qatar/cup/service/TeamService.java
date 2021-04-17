package Qatar.cup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Qatar.cup.models.Team;
import Qatar.cup.repositories.TeamRepository;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepo ;

    public List<Team> getAllTeams(){

            return teamRepo.findAll();

    }

    public Team saveTeam(Team team) {

        return teamRepo.save(team);

    }

    public Optional<Team> getTeam(Long id) {

        return teamRepo.findById(id);
    }

    public Optional<Team> deleteTeam(Long id) {
        // TODO Auto-generated method stub
        Optional<Team> team = teamRepo.findById(id);
        teamRepo.deleteById(id);
        return team;
    }

    public void deleteTeams() {

    	teamRepo.deleteAll();

    }

    public Team updateTeam(Team team) {

        return teamRepo.save(team);
    }



}