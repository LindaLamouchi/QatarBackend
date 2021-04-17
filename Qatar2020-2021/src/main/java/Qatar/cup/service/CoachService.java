package Qatar.cup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Qatar.cup.models.Coach;
import Qatar.cup.repositories.CoachRepository;

@Service
public class CoachService {

    @Autowired
    CoachRepository coachRepo ;

    public List<Coach> getAllCoaches(){

            return coachRepo.findAll();

    }

    public Coach saveCoach(Coach coach) {

        return coachRepo.save(coach);

    }

    public Optional<Coach> getCoach(Long id) {

        return coachRepo.findById(id);
    }

    public Optional<Coach> deleteCoach(Long id) {
        // TODO Auto-generated method stub
        Optional<Coach> coach = coachRepo.findById(id);
        coachRepo.deleteById(id);
        return coach;
    }

    public void deleteCoaches() {

    	coachRepo.deleteAll();

    }

    public Coach updateCoach(Coach coach) {

        return coachRepo.save(coach);
    }



}