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

import Qatar.cup.models.Coach;
import Qatar.cup.models.Player;
import Qatar.cup.models.Team;
import Qatar.cup.repositories.TeamRepository;
import Qatar.cup.service.CoachService;
import Qatar.cup.service.TeamService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CoachController {

        @Autowired
       CoachService coachServ ;

        @Autowired
        TeamService teams;
        @Autowired
        TeamRepository teamrep;


        @GetMapping("/getCoaches")
        public List<Coach> getAllCoaches(){
                return coachServ.getAllCoaches();

        }

        @PostMapping("/addCoach")
        public Coach addCoach(@RequestBody Coach coach) {

                return coachServ.saveCoach(coach);
        }


        @GetMapping("/getCoach/{id}")
        public Optional<Coach> getAllCoaches(@PathVariable Long id){
                return coachServ.getCoach(id);

        }

        @DeleteMapping("/deleteCoach/{id}")
        public Optional<Coach> deleteCoach(@PathVariable Long id){
            return coachServ.deleteCoach(id);

    }

        @DeleteMapping("/deleteAllCoaches")
        public String deleteAllCoaches() {

        	coachServ.deleteCoaches();

            return "All Coaches are deleted";
        }

        @PutMapping("/updateCoach")
        public Coach updateCoach(@RequestBody Coach coach) {
        	
            return coachServ.updateCoach(coach);
        }
        
        @GetMapping("/getTeamCoach/{id}")
        public Coach getTeamCoach(@PathVariable Long id){
        	
        	List<Coach> listf =new ArrayList<Coach>();
        	listf=coachServ.getAllCoaches();
        	Coach c=new Coach();
        	for (Coach coach : listf) {
				if(coach.getTeam()!=null)
        		if(coach.getTeam().getIdTeam()==id)
					c=coach;
			}
        	
        	return c;
        	
        }
        
        @DeleteMapping("/deleteTeam/{id}")
        public Optional<Team> deleteTeam(@PathVariable Long id){
            List<Coach> c;
            c=coachServ.getAllCoaches();
            for (Coach coach : c) {
            	if(coach.getTeam()!=null)
            		if(coach.getTeam().getIdTeam()==id)
            			
            		{   
            			coach.setTeam(null);}
            	
				
			}
        	
			return teams.deleteTeam(id);

    }
        
        
        @PutMapping("/updateCoach/{idt}")
        public Coach CoachTeam(@RequestBody Coach coach,@PathVariable Long idt) {

        	List<Coach> s=new ArrayList<Coach>();
        	s=coachServ.getAllCoaches();
        	for(Coach c:s) {
        		if(c.getTeam()!=null)
        		if(c.getTeam().getIdTeam()==idt)
        			c.setTeam(null);}
        	
        	Optional<Team> t= teamrep.findById(idt);
            Team team=t.get();
            coach.setTeam(team);
            return coachServ.updateCoach(coach);
        }



}
