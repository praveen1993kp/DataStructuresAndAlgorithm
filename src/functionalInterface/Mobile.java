package functionalInterface;

public interface Mobile {
	
	static int getOSVersion() {
		return 12;	
	}
	
	default void closeApplication() {
		System.out.println("App Closed");
	}
}
