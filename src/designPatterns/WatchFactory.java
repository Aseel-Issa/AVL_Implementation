package designPatterns;

public abstract class WatchFactory {
	
	public static Watch createWatch(AbstractFactory factory) {
		
		return factory.createWatch();
	}
}
