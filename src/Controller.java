public class Controller {

    private static String mazePath = "/Users/RobCardy/GitHub/Weekly 25 Maze/src/maze.txt";

    public static void main(String[] args) throws MazeException{
        Player player = new Player(mazePath);
        System.out.println(player.toString());

        boolean finished = false;

        // Game loop
        while(finished == false) {
            String input;

            // Get input
            input = IOHelper.getString("Direction: ");

            // Update character position
            switch(input) {
                case "w": player.moveUp();
                          System.out.println(player);
                          break;
                case "a": player.moveLeft();
                          System.out.println(player);
                          break;
                case "s": player.moveDown();
                          System.out.println(player);
                          break;
                case "d": player.moveRight();
                          System.out.println(player);
                          break;
                default:  System.out.println("Invalid input. Use WASD for movement.");
            }

            // Check for a win
            if (player.getExit().equals(player.getPosition())) {
                finished = true;
                System.out.println("Good job! You got to the exit!");
            }
        }
    } // end main method
} // end Controller class
