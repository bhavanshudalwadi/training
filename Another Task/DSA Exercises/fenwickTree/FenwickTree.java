package fenwickTree;

public class FenwickTree {
    private int[] BITree;
    private int size;

    public FenwickTree(int n) {
        this.BITree = new int[n + 1];
        this.size = n;
    }

    
    public void update(int index, int delta) {
        index++;  
        while (index <= size) {
            BITree[index] += delta;
            index += index & -index;  
        }
    }

    
    public int getPrefixSum(int index) {
        index++;  
        int sum = 0;
        while (index > 0) {
            sum += BITree[index];
            index -= index & -index;  
        }
        return sum;
    }

    
    public int getRangeSum(int start, int end) {
        if (start == 0) {
            return getPrefixSum(end);
        } else {
            return getPrefixSum(end) - getPrefixSum(start - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 2, 6, 8, 7, 4};

        FenwickTree fenwickTree = new FenwickTree(array.length);

        
        for (int i = 0; i < array.length; i++) {
            fenwickTree.update(i, array[i]);
        }

        
        System.out.println("Prefix Sum from 0 to 4: " + fenwickTree.getPrefixSum(4));  
        System.out.println("Prefix Sum from 2 to 6: " + fenwickTree.getPrefixSum(6));  

        
        System.out.println("Range Sum from 1 to 5: " + fenwickTree.getRangeSum(1, 5));  

        
        int updateIndex = 3;
        int updateValue = 4;
        fenwickTree.update(updateIndex, updateValue);

        
        System.out.println("Range Sum from 1 to 5 after update: " + fenwickTree.getRangeSum(1, 5));  
    }
}
