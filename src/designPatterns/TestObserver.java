package designPatterns;

public class TestObserver {
	
	public static void main(String[] args) {
		Subject blog = new Blog();
		Observer user = new User();
		
//		blog.register(user);
		user.subscribe(blog);
		
		blog.setPost("First post");
	
	}
	

}
