public class NumArrayList {

    private int size;
    private Integer[] elementData;

    public NumArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Integer[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = new Integer[0];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public NumArrayList() {
        this.elementData = new Integer[0];
    }






}
