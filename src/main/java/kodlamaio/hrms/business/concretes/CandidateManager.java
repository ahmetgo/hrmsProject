package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(),"İş arayanlar listelendi.");
	}

	@Override
	public Result add(Candidate candidate) {

		if(candidate.getFirst_name().isEmpty()) {
			return new ErrorResult("Lütfen adınızı giriniz.");
		}if(candidate.getEmail().isEmpty()) {
			return new ErrorResult("Lütfen email giriniz.");
		}if(candidate.getLast_name().isEmpty()) {
			return new ErrorResult("Lütfen soyadınızı giriniz.");
		}if(candidate.getBirth_date()==null) {
			return new ErrorResult("Lütfen doğum tarihinizi giriniz.");
		}
		if(candidate.getIdentity_number()== null) {
			return new ErrorResult("Lütfen TC kimlik numaranızı giriniz.");
		}
		if(candidate.getPassword().isEmpty()) {
			return new ErrorResult("Lütfen şifrenizi giriniz.");
		}for (Candidate candidates : this.candidateDao.findAll()) {
			if(candidate.getEmail().equals(candidates.getEmail())) {
				return new ErrorResult("E posta alınmış!!!");
			}
			if(candidate.getIdentity_number().equals(candidates.getIdentity_number())) {
				return new ErrorResult("TC Kimlik Numarası Sisteme Kayıtlı!!!");
			}
		}
		
		return new SuccessResult(" İş arayan kullanıcı eklendi.");
		
		
	}
	

	
}
