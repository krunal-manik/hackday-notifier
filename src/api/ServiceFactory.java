package api;

public class ServiceFactory {
	
	public static ApiService getApiService() {
		return new MockApiService();
	}
}
