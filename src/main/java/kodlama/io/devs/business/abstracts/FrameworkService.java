package kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.devs.business.requests.frameworks.CreateFrameworkRequest;
import kodlama.io.devs.business.requests.frameworks.UpdateFrameworkRequest;
import kodlama.io.devs.business.response.frameworks.GetAllFrameworksResponse;
import kodlama.io.devs.business.response.frameworks.GetFrameworkByIdResponse;

public interface FrameworkService {
	List<GetAllFrameworksResponse> getAll();
	void add(CreateFrameworkRequest createFrameworkRequest) throws Exception;
	void update(UpdateFrameworkRequest updateFrameworkRequest) throws Exception;
	void delete(int id);
	GetFrameworkByIdResponse getById(int id);
}
