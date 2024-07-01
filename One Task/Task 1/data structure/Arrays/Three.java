class Three {
    public static void main(String args[]) {
        int arr[] = {34, 12, 24, 56, 19}, revArr[] = new int[5];
        for(int i=0, j=arr.length-1; i<arr.length; i++, j--) {
            revArr[i] = arr[j];
            System.out.print(revArr[i]+" ");
        }
    }
}