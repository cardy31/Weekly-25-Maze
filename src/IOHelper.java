import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


class IOHelper {

    /**
     * Reads the maze in from a .txt file
     * @return An array of chars representing the maze
     */
    static char[][] readInMaze(String path) throws MazeException{

        ArrayList<String> maze = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();

            while(line != null) {
                maze.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new MazeException("The maze wasn't read in correctly");
        }

        int length = maze.size();
        int width = maze.get(0).length();

        char[][] mazeArray = new char[length][width];
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < width; j++) {
                mazeArray[i][j] = maze.get(i).charAt(j);
            }
        }
        return mazeArray;
    }

    public static String getString(String prompt) {

        Scanner reader = new Scanner(System.in);

        String userText;
        System.out.print(prompt);
        userText = reader.nextLine();
        return userText;
    }
}
