//package old_classes;
//
//import com.newman.game.CommandListener;
//import com.newman.game.Main;
//
//class TurnBased extends Thread {
//    public void run() {
//        TurnBased_GameLoop.turnCycle(); //Runs the game loop cycle in this thread
//    }
//    //This thread allows the game time cycle to run in parallel to the command listener.
//}
//
//public class TurnBased_GameLoop {
//
//
//    public static void turnCycle() {
//        while (Main.runGame) {
//            while (Main.turnInProcess) {
//                //During the process of a turn, this loops through and gathers user input.
//                CommandListener.getInput();
//            }
//            Main.update(); //This calls updates the game after every turn with changes, such as adding to dayNum
//
//            Main.turnInProcess = true; //This allows for the next turn
//        }
//    }
//
//    public static void startTurnCycle() {
//        TurnBased thread_1 = new TurnBased();
//        thread_1.start();
//    }
//}
