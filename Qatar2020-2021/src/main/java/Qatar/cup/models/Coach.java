package Qatar.cup.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="coaches")

public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCoach;

    @Column
    private String firstName;
	

    @Column
    private String lastName;
  

	@OneToOne
	@JoinColumn(name="team_id",nullable = false)
	private Team team;
	    
	public Coach() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Coach(Long idCoach, String firstName, String lastName,Team team) {
		super();
		this.idCoach = idCoach;
		this.firstName = firstName;
		this.lastName = lastName;
		this.team=team;
	
	}


	public Long getIdCoach() {
		return idCoach;
	}


	public void setIdCoach(Long idCoach) {
		this.idCoach = idCoach;
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





	public Team getTeam() {
		return team;
	}





	public void setTeam(Team team) {
		this.team = team;
	}

	
   
    

}
