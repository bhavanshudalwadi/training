class Car {
    String make, model;
    int year;

    Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    void displayCarDetails() {
        System.out.println("Car Make = "+make);
        System.out.println("Car Model = "+model);
        System.out.println("Car Year = "+year);
    }
}