class Two {
    public static void main(String args[]) {
        int arr[] = {34, 12, 24, 56, 19}, max = arr[0];

        for(int i=1; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("Max of Array: "+max);
    }
}