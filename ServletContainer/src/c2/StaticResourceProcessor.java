package c2;

import java.io.IOException;

public class StaticResourceProcessor {
	public void process(Request request, Response response){
		try{
			response.sendStaticResponse();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
