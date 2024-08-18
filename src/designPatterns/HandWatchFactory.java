package designPatterns;

public class HandWatchFactory implements AbstractFactory{

	@Override
	public Watch createWatch() {
		// TODO Auto-generated method stub
		return new HandWatch(2);
	}

}
