package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})
public class Employer extends User{
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="web_addres")
	private String web_addres;
	
	@Column(name="phone_number")
	private String phone_number;
	
	@Column(name="is_activated")
	private boolean is_activated;

	@OneToMany(mappedBy = "employer",  fetch = FetchType.LAZY)
	private List<JobAdvertisement> jobAdvertisement;
	
}
