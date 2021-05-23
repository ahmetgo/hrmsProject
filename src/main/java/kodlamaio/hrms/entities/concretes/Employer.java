package kodlamaio.hrms.entities.concretes;

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
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Employer extends User{
	
	@Column(name="company_name")
	private String company_name;
	
	@Column(name="web_addres")
	private String web_addres;
	
	@Column(name="phone_number")
	private String phone_number;
	
	@Column(name="is_activated")
	private boolean is_activated;

	
}
