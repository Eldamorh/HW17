

public class IntStackImpl implements IntStack, IntList {

    int[] array=new int[10];
    int size = 0;


    IntStackImpl() {}

    IntStackImpl(int value) {
        push(value);
    }

    IntStackImpl(int[] array) {
        for (int i : array) {
            add(i);
        }
    }

    private void resize(){
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    @Override
    public void push(int value) {
        if (size == array.length / 2) {
            resize();
        }
        array[size] = value;
        size++;
    }

    @Override
    public int pop() {
        if (size == 0) {
            return Integer.MIN_VALUE;
        } else {
            size--;
            return array[size];
        }
    }

    @Override
    public int peek() {
        return array[size - 1];
    }

    @Override
    public void add(int i) {
        if (size == array.length / 2) {
            resize();
        }
        array[size] = i;
        size++;
    }

    @Override
    public void insert(int index, int value) {
        if (size == array.length / 2) {
            resize();
        }
        if (index <= size) {
            int[] newArray = new int[array.length];
            System.arraycopy(array, 0, newArray, 0, index);
            newArray[index] = value;
            System.arraycopy(array, index, newArray, index + 1, size - index);
            size++;
            array = newArray;
        }else{
            throw new IndexOutOfBoundsException();
        }


    }


    @Override
    public void set(int index, int value) {
        if (index <= size && size != 0) {
            array[index] = value;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }


    @Override
    public int size() {
        return size;
    }


    @Override
    public int capacity() {
        return array.length;
    }


    @Override
    public int getByIndex(int index) {
        return array[index];
    }



    @Override
    public Integer getIndexByValue(int value) {
        for (int i : array) {
            if (i == value) {
                return i - 1;
            }
        }
        return null;
    }

    @Override
    public boolean contains(int value) {
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                int[] newArray = new int[array.length];
                System.arraycopy(array, 0, newArray, 0, i);
                System.arraycopy(array, i + 1, newArray, i, size - i);
                size--;
                array = newArray;
            }
        }


    }

    @Override
    public void removeByIndex(int index) {
        if (index <= size && size != 0){
            int[] newArray = new int[array.length];
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index + 1, newArray, index, size - index);
            size--;
            array = newArray;
        }else{
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        int[] newArray = new int[toIndex - fromIndex];
        System.arraycopy(array, fromIndex, newArray, 0, toIndex - fromIndex);
        return new IntStackImpl(newArray);
    }

    @Override
    public int[] toArray() {
        int[] newArray = new int[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }
}
