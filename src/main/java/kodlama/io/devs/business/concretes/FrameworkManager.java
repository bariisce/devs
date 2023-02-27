package kodlama.io.devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.FrameworkService;
import kodlama.io.devs.business.requests.frameworks.CreateFrameworkRequest;
import kodlama.io.devs.business.requests.frameworks.UpdateFrameworkRequest;
import kodlama.io.devs.business.response.frameworks.GetAllFrameworksResponse;
import kodlama.io.devs.business.response.frameworks.GetFrameworkByIdResponse;
import kodlama.io.devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.devs.dataAccess.abstracts.FrameworkRepository;
import kodlama.io.devs.entities.concretes.Framework;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FrameworkManager implements FrameworkService{
	
	List<Framework> frameworks; 
	private FrameworkRepository frameworkRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllFrameworksResponse> getAll() {
		List<Framework> frameworks = frameworkRepository.findAll();
		List<GetAllFrameworksResponse> frameworkResponse = frameworks.stream().map(
				framework->this.modelMapperService.forResponse().map(
						framework, GetAllFrameworksResponse.class)).collect(Collectors.toList());
		return frameworkResponse;
	}

	@Override
	public void add(CreateFrameworkRequest createFrameworkRequest) throws Exception {
		Framework framework = this.modelMapperService.forRequest().map(createFrameworkRequest, Framework.class);
		for (Framework frame : frameworks) {
			if(frame.getFrameworkName().equals(createFrameworkRequest.getName())) {
				throw new Exception("This name is already exist !");
			}
			else if(createFrameworkRequest.getName().isEmpty()) {
				throw new Exception("This field can not be empty !");
			}
		}
		this.frameworkRepository.save(framework);
	}

	@Override
	public void update(UpdateFrameworkRequest updateFrameworkRequest) throws Exception {
		Framework framework = this.modelMapperService.forRequest().map(updateFrameworkRequest, Framework.class);
		for (Framework frame : frameworks) {
			if(frame.getFrameworkName().equals(updateFrameworkRequest.getName())) {
				throw new Exception("This name is already exist !");
			}
			else if(updateFrameworkRequest.getName().isEmpty()) {
				throw new Exception("This field can not be empty !");
			}
		}
		this.frameworkRepository.save(framework);
	}

	@Override
	public void delete(int id) {
		frameworkRepository.deleteById(id);
		
	}

	@Override
	public GetFrameworkByIdResponse getById(int id) {
		Framework framework = this.frameworkRepository.findById(id).orElseThrow();
		GetFrameworkByIdResponse response = this.modelMapperService.forResponse().map(framework, GetFrameworkByIdResponse.class);
		return response;
	}

}
