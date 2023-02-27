package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.business.requests.programmingLanguages.CreateProgrammingLanguageRequest;
import kodlama.io.devs.business.requests.programmingLanguages.UpdateProgrammingLanguageRequest;
import kodlama.io.devs.business.response.programmingLanguages.GetAllProgrammingLanguagesResponse;
import kodlama.io.devs.business.response.programmingLanguages.GetProgrammingLanguageByIdResponse;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService programmingLanguageService;
	
	@GetMapping()
	public List<GetAllProgrammingLanguagesResponse> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() CreateProgrammingLanguageRequest createProgrammingLanguageRequest) throws Exception{
		programmingLanguageService.add(createProgrammingLanguageRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		programmingLanguageService.delete(id);
	}
	
	@PutMapping
	public void update(@RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) throws Exception{
		this.programmingLanguageService.update(updateProgrammingLanguageRequest);
	}
	
	@GetMapping("/{id}")
	public GetProgrammingLanguageByIdResponse getById(@PathVariable() int id) {
		return programmingLanguageService.getById(id);
	}
	
	
}
