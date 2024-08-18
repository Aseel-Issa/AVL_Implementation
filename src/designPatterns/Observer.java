package designPatterns;

public interface Observer {

	public void subscribe(Subject s);
	public void recieveMessage(String s);
}
