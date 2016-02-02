
class ArrayList{
		
	private Entry[] array;
	private int size;
		
	public ArrayList(){
		array = new Entry[16];
		size = 0;
	}
		
	public ArrayList(int size){
		array = new Entry[size];
		size = 0;
	}
		
	public Entry get(int index){
		if(index >= size){
			System.out.println("Error, index out of bounds - me");
			return null;
		}
		return array[index];
	}
		
	public Entry set(int index, Entry value){		//a.k.a. "replace"
		Entry temp = array[index];
		add(index, value);
		return temp;
	}		
	
	public void add(int index, Entry value){
		while(index >= array.length)
			expandArray();
		array[index] = value;
		if( index >= size )
			size = index + 1;
	}
		
	public Entry remove(int index){
		if(index >= size){
			System.out.println("Error, index out of bounds. No element removed");
			return null;
		}
		Entry temp = array[index];
		array[index] = null;
		if ( index == (size - 1) )
			size--;
		return temp;
	}
		
	public int size(){
		return size;
	}
		
	public boolean isEmpty(){
		return (size == 0);
	}
		
	private void expandArray(){
		Entry[] temp = array;
		array = new Entry[temp.length * 2];
		for(int i = 0; i < size; i++)
			array[i] = temp[i];
	}
		
}
