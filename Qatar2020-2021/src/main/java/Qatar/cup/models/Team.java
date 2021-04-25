package Qatar.cup.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="teams")

public class Team {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTeam;
    
    @Column
    private String name;

  
     @OneToMany(mappedBy="team")
     @JsonIgnore
     private List<Player> players=new ArrayList<Player>();
    
   
    @OneToOne(mappedBy = "team", cascade = CascadeType.ALL)
    
    private Coach coach;

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(Long idTeam, String name, List<Player> players,Coach coach) {
		super();
		this.idTeam = idTeam;
		this.name = name;
		this.players = players;
		this.coach=coach;
	
	}

	public Long getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Long idTeam) {
		this.idTeam = idTeam;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	
	

}
