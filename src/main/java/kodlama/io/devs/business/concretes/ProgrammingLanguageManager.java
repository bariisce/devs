package kodlama.io.devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.programmingLanguages.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguages.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.response.programmingLanguages.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.business.response.programmingLanguages.GetProgrammingLanguageByIdResponse;
import kodlama.io.devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	
	List<ProgrammingLanguage> programmingLanguages;
	private ProgrammingLanguageRepository programmingLanguageRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		List<ProgrammingLanguage> languages = programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> languageResponse = languages.stream().map(language->this.modelMapperService.forResponse().map(language, GetAllProgrammingLanguagesResponse.class)).collect(Collectors.toList());
		return languageResponse;
	}

	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception {
		
		ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest().map(createProgrammingLanguageRequest, ProgrammingLanguage.class);
		for (ProgrammingLanguage progLanguage : programmingLanguages) {
			if(progLanguage.getLanguageName().equals(createProgrammingLanguageRequest.getName())) {
				throw new Exception("This name is already exist !");
			}
			else if(createProgrammingLanguageRequest.getName().isEmpty()) {
				throw new Exception("This field can not be empty !");
			}
		}
		this.programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public void delete(int id) {
		
		this.programmingLanguageRepository.deleteById(id);
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception {
		
		ProgrammingLanguage programmingLanguage = this.modelMapperService.forRequest().map(updateProgrammingLanguageRequest, ProgrammingLanguage.class);
		for (ProgrammingLanguage programLanguage : programmingLanguages) {
			if(programLanguage.getLanguageName().equals(updateProgrammingLanguageRequest.getName())) {
				throw new Exception("This name is already exist !");
			}
			else if(updateProgrammingLanguageRequest.getName().isEmpty()) {
				throw new Exception("This field can not be empty !");
			}
		}
		this.programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public GetProgrammingLanguageByIdResponse getById(int id) {
		ProgrammingLanguage programmingLanguage = this.programmingLanguageRepository.findById(id).orElseThrow();
		GetProgrammingLanguageByIdResponse getByIdResponse = this.modelMapperService.forResponse().map(programmingLanguage, GetProgrammingLanguageByIdResponse.class);
		return getByIdResponse;
	}

}
