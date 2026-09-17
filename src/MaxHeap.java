public class MaxHeap {
    private String[] words;
    private int[] freqs;
    private int size;

    public MaxHeap(int capacity) {
        words = new String[capacity];
        freqs = new int[capacity];
        size = 0;
    }
    public void add(String word, int freq) {
        words[size] = word;
        freqs[size] = freq;
        siftUp(size);
        size++;
    }
    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (freqs[parent] >= freqs[i]) break;
            swap(parent, i);
            i = parent;
        }
    }
    private void swap(int i, int j) {
        String tw = words[i]; words[i] = words[j]; words[j] = tw;
        int tf = freqs[i];    freqs[i] = freqs[j]; freqs[j] = tf;
    }
    public String peekWord() {
        return size == 0 ? null : words[0];
    }
    public int peekFreq() {
        return size == 0 ? 0 : freqs[0];
    }
}
