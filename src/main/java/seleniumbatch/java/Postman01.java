package seleniumbatch.java;
	import okhttp3.OkHttpClient;
	import okhttp3.Request;
	import okhttp3.Response;

	public class Postman01 {
	    public static void main(String[] args) throws Exception {

	        OkHttpClient client = new OkHttpClient();

	        Request request = new Request.Builder()
	                .url("https://jsonplaceholder.typicode.com/posts/1")
	                .get()
	                .build();

	        Response response = client.newCall(request).execute();

	        System.out.println(response.body().string());
	    }
	}
