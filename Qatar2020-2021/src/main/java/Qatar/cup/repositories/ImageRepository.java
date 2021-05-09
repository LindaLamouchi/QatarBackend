package Qatar.cup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Qatar.cup.models.ImageModel;
import Qatar.cup.models.Team;
import java.util.List;

public interface ImageRepository extends JpaRepository<ImageModel, Long>{
	Optional<ImageModel> findByName(String name);

	boolean existsByName(String name);
	ImageModel findByTeam(Team team); 
	
}
