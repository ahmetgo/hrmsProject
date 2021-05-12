package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer>{
	//jparepository ne yapar? 
	//jparepository verdiğin veri tipi için yani entity anatasyonu ile süslenmiş
	//veri tipi için(JobTitle) birçok sorgu yazmaktan kurtarır.
	
	//kısacası hangi tabloya hangi id veri tipiyle sorguların hazırlanması 
	//gerektiğini repository e söylemiş oluyoruz
}
