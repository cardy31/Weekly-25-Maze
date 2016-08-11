abstract class Maze {

    private char[][] maze;
    private Cords exit;
    private int xMax;
    private int yMax;

    public Maze(String mazePath) throws MazeException {
        setMaze(mazePath);
        setxMax();
        setyMax();
        exit = setExit();
        System.out.println("First");
    }

    private Cords setExit() throws MazeException{
        for(int i = 0; i < yMax; i++) {
            for(int j = 0; j < xMax; j++) {
                Character temp = maze[i][j];
                if (temp.equals('X')) {
                    return new Cords(j, i);
                }
            }
        }
        throw new MazeException("The exit of the maze couldn't be found.");
    }

    private void setMaze(String mazePath) throws MazeException{
        maze = IOHelper.readInMaze(mazePath);
    }

    private void setxMax() {
        xMax = maze[0].length;
    }

    private void setyMax() {
        yMax = maze.length;
    }

    void setCharacter(Cords position) {
        maze[position.getY()][position.getX()] = 'B';
        System.out.println("Character set!");
    }

    void deleteOldCharacter(Cords position) {
        maze[position.getY()][position.getX()] = ' ';
    }

    char[][] getMaze() {
        return maze;
    }

    protected int getxMax() {
        return xMax;
    }

    protected int getyMax() {
        return yMax;
    }

    protected Cords getExit() {
        return exit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < yMax; i++) {
            for(int j = 0; j < xMax; j++) {
                sb.append(maze[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString() + "\n" + "Exit: " + exit;
    }
}
