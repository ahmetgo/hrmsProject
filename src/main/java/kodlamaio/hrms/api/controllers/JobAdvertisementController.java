package kodlamaio.hrms.api.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementController {

	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
		
	}
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	@GetMapping("/getAllByActive")
	public DataResult<List<JobAdvertisement>> getByIsActive() {
		return this.jobAdvertisementService.getByIsActive();
	}
	
	@GetMapping("/getAllDescByDate")
	public DataResult<List<JobAdvertisement>>  getByIsActiveAndSortedByApplicationDeadline(){
		return this.jobAdvertisementService.getByIsActiveAndSortedByApplicationDeadline();
	}
	@PostMapping("/getAllByActive_CompanyName")
	public DataResult<List<JobAdvertisement>> getByactiveTrueAndEmployer_companyName(String companyName) {
		return this.jobAdvertisementService.getByactiveTrueAndEmployer_companyName(companyName);
	}
	@PostMapping("/getById")
	public DataResult<JobAdvertisement> getById(@RequestBody int id) {
		return this.jobAdvertisementService.getById(id);
	}
	
}
