package list;

public class List<T> {

    private T[] array;
    private int actualIndex;

    public List() {
        this.array = (T[]) new Object[10];
        actualIndex = 0;
    }

    public void add(T value) {
        if (this.actualIndex == this.array.length) {
            growList();
        }

        this.array[actualIndex] = value;
        this.actualIndex++;
    }

    public int size() {
        return actualIndex;
    }

    public T get(int index) {
        if (index < 0 || index >= this.actualIndex) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.array[index];
    }

    private void growList() {
        int newSize = this.actualIndex + (this.actualIndex / 2);
        T[] newArray = (T[]) new Object[newSize];
        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i];
        }

        this.array = newArray;
    }

    public void remove(T value) {
        int index = indexOfValue(value);
        if (indexOfValue(value) < 0) {
            return;
        }

        movetoLeft(index);
        this.actualIndex--;
    }

    public boolean contains(T value) {
        return indexOfValue(value) >= 0;
    }

    public int indexOfValue(T value) {
        for (int i = 0; i < this.actualIndex; i++) {
            if (this.array[i] == value || this.array[i].equals(value)) {
                return i;
            }
        }

        return -1;
    }

    private void movetoLeft(int fromIndex) {
        for (int i = fromIndex; i < this.array.length - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
    }
}
