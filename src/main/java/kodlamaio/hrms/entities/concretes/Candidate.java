package kodlamaio.hrms.entities.concretes;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Candidate extends User{
	    
	    @Column(name="first_name")
		private String first_name;
	    
	    @Column(name="last_name")
		private String last_name;
	    
	    @Column(name="identity_number")
	    private String identity_number;
	    
	    @Column(name="birth_date")
		private Date birth_date;

		
	
}
