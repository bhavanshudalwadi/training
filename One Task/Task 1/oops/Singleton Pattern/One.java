class Logger {
    private static Logger instance;

    static Logger getInstance() {
        if(instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    void printLog(String str) {
        System.out.println(str);
    }
}

class One {
    public static void main(String args[]) {
        Logger log = Logger.getInstance();
        log.printLog("Bhavanshu Dalwadi");
    }
}