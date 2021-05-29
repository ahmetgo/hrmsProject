package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
		
	    DataResult<List<JobAdvertisement>> getAll();
	    DataResult<List<JobAdvertisement>> getAllActiveSorted();
	    Result add(JobAdvertisement jobAbvertisement);
	  
	    DataResult<List<JobAdvertisement>>  getByIsActiveAndSortedByApplicationDeadline();
	    DataResult<JobAdvertisement> getById(int id);
	    
	    DataResult<List<JobAdvertisement>> getByIsActive();
	    DataResult<List<JobAdvertisement>> getByactiveTrueAndEmployer_companyName(String companyName);
}
