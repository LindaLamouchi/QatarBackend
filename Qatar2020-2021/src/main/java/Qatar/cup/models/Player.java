package Qatar.cup.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@Entity
@Table(name="players")

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPlayer;

    @Column
    private String firstName;


    @Column
    private String lastName;

    @Column
    private int age;


    @Column
    private String playerRole;
    
    
  
    
  
   @ManyToOne(cascade=CascadeType.ALL) 
   private Team team;

	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Long getIdPlayer() {
		return idPlayer;
	}


	public void setIdPlayer(Long idPlayer) {
		this.idPlayer = idPlayer;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getPlayerRole() {
		return playerRole;
	}


	public void setPlayerRole(String playerRole) {
		this.playerRole = playerRole;
	}
	
	

	public Team getTeam() {
	return team;
}



	public void setTeam(Team team) {
		this.team = team;
	}


    

}
