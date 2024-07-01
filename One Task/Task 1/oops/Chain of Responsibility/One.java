interface Handler {
    void setNextHandler(Handler nextHandler);
    void processRequest(String request);
}

class ConcreteHandler1 implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void processRequest(String request) {
        if (request.equals("Type1")) {
            System.out.println("ConcreteHandler1 is handling the request: " + request);
        } else if (nextHandler != null) {
            nextHandler.processRequest(request);
        }
    }
}

class ConcreteHandler2 implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void processRequest(String request) {
        if (request.equals("Type2")) {
            System.out.println("ConcreteHandler2 is handling the request: " + request);
        } else if (nextHandler != null) {
            nextHandler.processRequest(request);
        }
    }
}

class ConcreteHandler3 implements Handler {
    private Handler nextHandler;

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void processRequest(String request) {
        if (request.equals("Type3")) {
            System.out.println("ConcreteHandler3 is handling the request: " + request);
        } else if (nextHandler != null) {
            nextHandler.processRequest(request);
        }
    }
}

public class One {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);

        handler1.processRequest("Type1");
        handler1.processRequest("Type2");
        handler1.processRequest("Type3");
        handler1.processRequest("Type4");
    }
}
