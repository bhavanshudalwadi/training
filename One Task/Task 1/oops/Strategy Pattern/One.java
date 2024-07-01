interface PaymentStrategy {
    public void makePayment();
}

class CreditCardPayment implements PaymentStrategy {
    public void makePayment() {
        System.out.println("You made payment through Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void makePayment() {
        System.out.println("You made payment through Pay Pal");
    }
}

class One {
    PaymentStrategy obj;
    
    One(PaymentStrategy obj) {
        this.obj = obj;
    }

    public void makePayment() {
        obj.makePayment();
    }

    public static void main(String args[]) {
       One o1 = new One(new CreditCardPayment());
       o1.makePayment();
       
       One o2 = new One(new PayPalPayment());
       o2.makePayment();
    }
}