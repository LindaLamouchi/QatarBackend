package Qatar.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Qatar.cup.models.Coach;


@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {


   

}
