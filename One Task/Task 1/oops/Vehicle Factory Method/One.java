interface Vehicle {
    public void drive();
}

class Bike implements Vehicle {
    public void drive() {
        System.out.println("You are driving bike");
    }
}

class Car implements Vehicle {
    public void drive() {
        System.out.println("You are driving car");
    }
}

class VehicleFactory {
    public Vehicle getVehicle(String str) {
        if(str.equals("bike")) {
            return new Bike();
        }else if(str.equals("car")) {
            return new Car();
        }else {
            return new Bike();
        }
    }
}

class One {
    public static void main(String args[]) {
       VehicleFactory vf = new VehicleFactory();
       Vehicle v = vf.getVehicle("bike");
       v.drive();
       v = vf.getVehicle("car");
       v.drive();
    }
}