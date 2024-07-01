abstract class Game {   
    abstract void initialize();  
    abstract void startPlay();  
    abstract void endPlay();  
    
    // This is tamplete
    public final void play() {  
        initialize();  

        startPlay();  
        
        endPlay();  
    }  
}

class Football extends Game {
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");  
    }

    void startPlay() {
        System.out.println("Game Started. Welcome to in the football game!");  
    }

    void endPlay() {
        System.out.println("Game Over!");  
    }
}

class Basketball extends Game {
    void initialize() {
        System.out.println("Basketball Game Initialized! Start playing.");  
    }

    void startPlay() {
        System.out.println("Game Started. Welcome to in the basketball game!");  
    }

    void endPlay() {
        System.out.println("Game Over!");  
    }
}

class One {
    public static void main(String args[]) {
        Game g = new Basketball();
        g.play();
    }
}