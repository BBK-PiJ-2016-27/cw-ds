
public class ArrayListImpl implements List {
    private int maxCapacity; // defines the maximum number of elements in the
                             // list
    private int currentSize; // defines the number of elements in the list at
                             // any given time
    private Object[] array;

    // constructor creates a list
    // with a capacity of 5 elements
    public ArrayListImpl() {
        this.maxCapacity = 5;
        this.currentSize = 0;
        this.array = new Object[maxCapacity];
    }

    @Override
    public boolean isEmpty() {
        if (currentSize != 0) {
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
        if (index < 0 || index >= size()) {
            ReturnObjectImpl returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            return returnObj;
        }
        Object toReturn = array[index];
        ReturnObjectImpl returnObject = new ReturnObjectImpl(toReturn);
        return returnObject;
    }

    @Override
    public ReturnObject remove(int index) {
        if (index < 0 || index >= size()) {
            ReturnObjectImpl returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            return returnObj;
        } else {
            Object savedItem = array[index];
            array[index] = null;
            for (int i = index; i < currentSize; i++) {
                array[i] = array[i + 1];
            }
            currentSize--;
            ReturnObjectImpl returnObject = new ReturnObjectImpl(savedItem);
            return returnObject;
        }
    }

    @Override
    public ReturnObject add(int index, Object item) {
        if (index < 0 || index >= size()) {
            ReturnObjectImpl returnObj = new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
            return returnObj;
        } else if (item == null) {
            ReturnObjectImpl returnObj = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return returnObj;
        }
        if (currentSize == maxCapacity) {
            int newCapacity = maxCapacity * 2;
            Object[] doubledArray = new Object[newCapacity];
            for (int i = 0; i < maxCapacity; i++) {
                doubledArray[i] = array[i];
            }
            array = doubledArray;
            maxCapacity = newCapacity;
        }
        for (int i = currentSize; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        currentSize++;
        Object emptyObject = null;
        return new ReturnObjectImpl(emptyObject);
    }

    @Override
    public ReturnObject add(Object item) {
        if (item == null) {
            ReturnObjectImpl returnObj = new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
            return returnObj;
        }
        if (currentSize == maxCapacity) {
            int newCapacity = maxCapacity * 2;
            Object[] doubledArray = new Object[newCapacity];
            for (int i = 0; i < maxCapacity; i++) {
                doubledArray[i] = array[i];
            }
            array = doubledArray;
            maxCapacity = newCapacity;
        }
        array[currentSize] = item;
        currentSize++;
        Object emptyObject = null;
        return new ReturnObjectImpl(emptyObject);
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
