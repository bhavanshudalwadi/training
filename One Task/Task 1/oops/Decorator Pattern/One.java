class Coffee {
    int cost;

    Coffee() {
        this.cost = 50;
    }

    int cost() {
        return cost;
    }
}

class Milk extends Coffee {
    Coffee c;

    Milk(Coffee c) {
        this.c=c;
    }

    int cost() {
        return c.cost() + 20;
    }
}

class Sugar extends Coffee {
    Coffee c;

    Sugar(Coffee c) {
        this.c=c;
    }

    int cost() {
        return c.cost() + 10;
    }
}

class One {
    public static void main(String args[]) {
        Coffee c = new Coffee();
        System.out.println("Price of coffee is: "+c.cost());
        Milk m = new Milk(c);
        System.out.println("Price of coffee with milk is: "+m.cost());
        Sugar s1 = new Sugar(c);
        System.out.println("Price of coffee with suger is: "+s1.cost());
        Sugar s2 = new Sugar(m);
        System.out.println("Price of coffee with milk and suger is: "+s2.cost());
    }
}