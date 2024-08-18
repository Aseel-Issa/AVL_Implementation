package designPatterns;

public class WallWatchFactory implements AbstractFactory{

	@Override
	public Watch createWatch() {
		// TODO Auto-generated method stub
		return new WallWatch(10);
	}

}
