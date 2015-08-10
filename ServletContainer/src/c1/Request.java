package c1;

import java.io.IOException;
import java.io.InputStream;

public class Request {
	private InputStream input;
	private String uri;
	
	public Request(InputStream input){
		this.input = input;
	}
	/**
	 * parse headers
	 */
	public void parse(){
		StringBuffer request = new StringBuffer(2048);
		int i;
		byte[] buffer = new byte[2048];
		try {
			i = input.read(buffer);//return -1 if has reached end of file
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			i = -1;//handle exception
		}
		for(int j=0;j<i;j++){
			request.append((char)buffer[j]);
		}
		System.out.println(request.toString());
		uri = parseUri(request.toString());
	}
	/**
	 * parse URL from headers
	 * 用空格分割
	 * @param requestString
	 * @return
	 */
	private String parseUri(String requestString){
		int index1, index2;
		index1 = requestString.indexOf(' ');
		if(index1 != -1){
			index2 = requestString.indexOf(' ', index1+1);
			if(index2>index1){
				return requestString.substring(index1+1, index2);
			}
		}
		return null;
	}
	public String getUri(){
		return uri;
	}
}
