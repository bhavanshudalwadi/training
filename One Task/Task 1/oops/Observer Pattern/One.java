class Cricket {
    int runs = 0;
    double run_rate = 0;

    void updateRuns(int r) {
        runs += r;
        updateRunRate();
    }

    void updateRunRate() {
        run_rate++;
    }

    void printRunRate() {
        System.out.println("Runrate is "+run_rate);
    }
}

class One {
    public static void main(String args[]) {
        Cricket obs = new Cricket();
        obs.updateRuns(4);
        obs.updateRuns(6);
        obs.printRunRate();
    }
}