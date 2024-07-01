interface Iterator {
    public boolean hasNext();
    public int next();
}

class myArray implements Iterator {
    int arr[] = {1, 2, 3, 4, 5};
    int current;

    public boolean hasNext() {
        if(arr.length == current) {
            return false;
        }else {
            return true;
        }
    }

    public int next() {
        if(this.hasNext()) {
            return arr[current++];
        }
        return -1;
    }
}

class One {
    public static void main(String args[]) {
        Iterator i = new myArray();
        while(i.hasNext()) {
            System.out.print(i.next()+" ");
        }
    }
}