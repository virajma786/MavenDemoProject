package mvndemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainExample {

	public static void main(String[] args) {
		Person p = new Person("vignesh", "pune", 23);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(p);
		
		/// my java object is converting into json object with the help of dependency 
		try {
			String a = mapper.writeValueAsString(p);
			System.out.println(a);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
