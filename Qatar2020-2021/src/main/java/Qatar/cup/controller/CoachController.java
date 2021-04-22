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

import Qatar.cup.models.Coach;
import Qatar.cup.service.CoachService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CoachController {

        @Autowired
       CoachService coachServ ;




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



}
