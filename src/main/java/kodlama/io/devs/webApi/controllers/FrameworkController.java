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

import kodlama.io.devs.business.abstracts.FrameworkService;
import kodlama.io.devs.business.requests.frameworks.CreateFrameworkRequest;
import kodlama.io.devs.business.requests.frameworks.UpdateFrameworkRequest;
import kodlama.io.devs.business.response.frameworks.GetAllFrameworksResponse;
import kodlama.io.devs.business.response.frameworks.GetFrameworkByIdResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/framework")
@AllArgsConstructor
public class FrameworkController {
	private FrameworkService frameworkService;
	
	
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() CreateFrameworkRequest createFrameworkRequest) throws Exception {
		this.frameworkService.add(createFrameworkRequest);
	}
	
	@PutMapping()
	public void update(@RequestBody() UpdateFrameworkRequest updateFrameworkRequest) throws Exception {
		this.frameworkService.update(updateFrameworkRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(int id) {
		this.frameworkService.delete(id);
	}
	
	@GetMapping("/{id}")
	public GetFrameworkByIdResponse getById(@PathVariable() int id) {
		return this.frameworkService.getById(id);
	}
	
	@GetMapping()
	public List<GetAllFrameworksResponse> getAll(){
		return frameworkService.getAll();
	}
	
}
