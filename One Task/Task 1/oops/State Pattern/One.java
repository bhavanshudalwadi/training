class Context {
    int i;

    Context() {
        this.i = 0;
    }

    void changeState() {
        if(this.i == 0) {
            this.i = 1;
            System.out.println("State chnaged from A to B");
        }else{
            this.i = 0;
            System.out.println("State chnaged from B to A");
        }
    }
}

class One {
    public static void main(String args[]) {
        Context i = new Context();
        i.changeState();
        i.changeState();
    }
}