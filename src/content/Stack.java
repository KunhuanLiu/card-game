package content;


public class Stack<T> {
	private T[] myArray;
	private static final int NOITEM=-1;
	private int top;
	private int capacity;

	@SuppressWarnings("unchecked")
	public Stack(int cap) {
		this.myArray = (T[]) new Object[cap];
		this.top=NOITEM;
		this.capacity=cap;
	}
	
	
	public void add(T entry){
		if (top+1<capacity){
		top+=1;
		myArray[top]=entry;
		}
		else{
			throw new RuntimeException("stack is over capacity");
		}
	}
	
	public T peek(){
		if (!isEmpty()){
		return myArray[top];
		}
		else{
			throw new RuntimeException("stack is empty");
		}
	}
	
	public T pop(){
		if (isEmpty()){
			throw new RuntimeException("stack is empty");
		}
		else{
			T temp=myArray[top];
			myArray[top]=null;
			top-=1;
			return temp;
		}
	}
	
	public boolean isEmpty(){
		if (top==NOITEM){
			return true;
		}
		else{
			return false;
		}
	}
	@SuppressWarnings("unchecked")
	public void clear(){
		myArray=(T[]) new Object[capacity];
		this.top=NOITEM;
	}

}
