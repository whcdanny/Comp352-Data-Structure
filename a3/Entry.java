
public class Entry{
	private int key;
	private char value;
		
	public Entry(){
		key = 0;
		value = 0;
	}
	
	public Entry(int key, char value){
		this.key = key;
		this.value = value;
	}
		
	public int getKey(){
		return key;
	}
	
	public int getValuey(){
		return value;
	}
	
	public void setKey(int key){
		this.key = key;
	}
	
	public void setKey(char value){
		this.value = value;
	}
}	
