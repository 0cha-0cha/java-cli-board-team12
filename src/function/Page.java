package function;

import main.ClearScreen;
import main.ProgressBar;

public interface Page {
    default void clear(){
        ClearScreen.clearScreen();
    }

    default void loading(double duration, String message){
        ProgressBar.displayProgressBar(duration, message);
        System.out.println();
    }

    public abstract void select();

    public abstract void show(int page);
}
