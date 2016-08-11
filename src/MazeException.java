/**
 * Created by RobCardy on 2016-08-09.
 */
public class MazeException extends Exception{

    /**
     * Constructor with custom error message
     * @param message Printed to user explaining the error
     */
    public MazeException(String message) {
        System.out.println(message);
    }

    /**
     * Default constructor. Simply states that an error occurred.
     */
    public MazeException() {
        System.out.println("There was an error in the maze.");
    }
}
