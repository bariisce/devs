package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.programmingLanguages.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguages.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.response.programmingLanguages.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.business.response.programmingLanguages.GetProgrammingLanguageByIdResponse;


public interface ProgrammingLanguageService {
	List<GetAllProgrammingLanguagesResponse> getAll();
	void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception;
	void delete(int id);
	void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception;
	GetProgrammingLanguageByIdResponse getById(int id);
}
