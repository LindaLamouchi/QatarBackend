package Qatar.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Qatar.cup.models.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {


   

}
