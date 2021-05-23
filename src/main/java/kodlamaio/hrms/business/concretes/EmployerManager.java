package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(),"İşveren listelendi");
	}

	@Override
	public Result add(Employer employer) {

		if(employer.getCompany_name().isEmpty()) {
			return new ErrorResult("Lütfen şirketinizin ismini giriniz.");
		}if(employer.getWeb_addres().isEmpty()) {
			return new ErrorResult("Lütfen web sitenizi giriniz.");
		}if(employer.getWeb_addres() != employer.getEmail() ) {
			return new ErrorResult("Lütfen web siteniz ile aynı domaine sahip bir e-posta giriniz.");
		}if(employer.getPhone_number()==null) {
			return new ErrorResult("Lütfen telefon numaranızı giriniz.");
		}
		if(employer.getPassword()== null) {
			return new ErrorResult("Lütfen şifrenizi giriniz.");
		}for (Employer employers : this.employerDao.findAll()) {
			if(employer.getEmail().equals(employers.getEmail())) {
				return new ErrorResult("E posta alınmış!!!");
			}
		}
		
		return new SuccessResult(" İş veren kullanıcı eklendi.");
		
		
	
		
	}

}