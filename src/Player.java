import java.util.Random;

class Player extends Maze{

    private Cords position;

    public Player(String mazePath) throws MazeException{
        super(mazePath);
        setPosition();
        setCharacter(position);
        System.out.println("Second");
    }

    private Cords randPos(int xMax, int yMax) {
        int x;
        int y;

        Random randy = new Random();

        do {
            y = randy.nextInt(yMax);
            x = randy.nextInt(xMax);
        } while(!cordValid(x, y));

        return new Cords(x, y);
    }

    private boolean cordValid(int x, int y) {
        Character temp = getMaze()[y][x];

        return !(temp.equals('#'));
    }

    private void setPosition() {
        position = randPos(getxMax(), getyMax());
    }

    public Cords getPosition() {
        return position;
    }

    public void moveUp() {
        if (cordValid(position.getX(), position.getY() - 1)) {
            deleteOldCharacter(position);
            position.decY();
            setCharacter(position);
        }
        else {
            System.out.println("Sorry, you can't move there");
        }
    }

    public void moveDown() {
        if (cordValid(position.getX(), position.getY() + 1)) {
            deleteOldCharacter(position);
            position.incY();
            setCharacter(position);
        }
        else {
            System.out.println("Sorry, you can't move there");
        }
    }

    public void moveLeft() {
        if (cordValid(position.getX() - 1, position.getY())) {
            deleteOldCharacter(position);
            position.decX();
            setCharacter(position);
        }
        else {
            System.out.println("Sorry, you can't move there");
        }
    }

    public void moveRight() {
        if (cordValid(position.getX() + 1, position.getY())) {
            deleteOldCharacter(position);
            position.incX();
            setCharacter(position);
        }
        else {
            System.out.println("Sorry, you can't move there");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Player: " + position;
    }
}
