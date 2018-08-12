
public class PrivateConstructor {

	private PrivateConstructor p;
	
	private PrivateConstructor(){
		// Implementation
	}
	
	
	public PrivateConstructor getInstance() {
		this.p = new PrivateConstructor();
		return this.p;
	}
	
	
}
