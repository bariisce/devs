package kodlama.io.devs.business.requests.frameworks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UpdateFrameworkRequest {
	private int id;
	private String name;
}
