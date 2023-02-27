package kodlama.io.devs.business.response.frameworks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetFrameworkByIdResponse {
	
	private int id;
	private String name;
}
