
public class ArrayListImpl implements List {
	private int maxCapacity; // defines the maximum number of elements in the list
	private int currentSize; // defines the number of elements in the list at any given time
	private Object[] array;
	
	// constructor creates a list
    // with a capacity of 5 elements
	
	public ArrayListImpl ( ) {
		this.maxCapacity = 5;
		this.currentSize = 0;
		this.array = new Object[maxCapacity];
	}
	
	public ArrayListImpl (int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.currentSize = 0;
		this.array = new Object[maxCapacity];
	}
		
	@Override
	public boolean isEmpty() {
		if (currentSize!=0) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public int size() {
		return currentSize; 
	}

	@Override
	public ReturnObject get(int index) {
		if (index<0 || index>=maxCapacity) {
			ReturnObjectImpl returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return returnObj;
		} else {
			ReturnObjectImpl returnObj = new ReturnObjectImpl(index);
			return returnObj;
		}
	}

	@Override
	public ReturnObject remove(int index) {
		if (index<0 || index>=maxCapacity) {
			ReturnObjectImpl returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return returnObj;
		} else {
			array [index] = null;
			for (int i = index; i<currentSize; i++) {
				array[i] = array [i+1];
			}
			currentSize--;
		}
		ReturnObjectImpl returnObj = new ReturnObjectImpl(array);
		return returnObj;
	}

	@Override
	public ReturnObject add(int index, Object item) {
		if (index<0 || index>=maxCapacity) {
			ReturnObjectImpl returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
			return returnObj;
		} 
		else if (item == null) {
			ReturnObjectImpl returnObj = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return returnObj;	
		} else {
			if (array[index] == null) {
				array[index]= item;
				ReturnObjectImpl returnObj = new ReturnObjectImpl (item);	
				return returnObj;
			} else {
				for (int i = currentSize; i > index; i--) {
					array[i] = array[i-1];
				}
				array[index] = item;
				currentSize++;
			}
			ReturnObjectImpl returnObj = new ReturnObjectImpl (item);	
			return returnObj;
		}
	}
	
	@Override
	public ReturnObject add(Object item) {
		if (item==null) {
			ReturnObjectImpl returnObj = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
			return returnObj;
		}
		if (currentSize != maxCapacity) {
			array[currentSize] = item;
			currentSize++;
			ReturnObjectImpl returnObj = new ReturnObjectImpl(null);
			return returnObj;	
		}
/*
		else if (currentSize == maxCapacity) {
			Object temporaryArray = array[currentSize];
			int doubledCapacity = 2*maxCapacity;
			ArrayListImpl myList = new ArrayListImpl (doubledCapacity);
			for (int i=0; i<maxCapacity; i++) {
				array[i] = temporaryArray [i];
			}
		}
*/
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}
	
	public String toString() {
		String s = "[";
		for (int i = 0; i < currentSize; ++i) {
			s += array[i] + ", ";
		}
		s += "] ";
		return s;
	}

}
