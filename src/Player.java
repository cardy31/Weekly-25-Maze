import java.util.Random;

class Player extends Maze{

    private Cords position;

    public Player(String mazePath) throws MazeException{
        super(mazePath);
        setPosition();
        setCharacter(position, 'B');
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
        if(x <= 0 || y <= 0)
            return false;

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
            setCharacter(position, '^');
        }
        else if(cordValid(position.getX(), position.getY() - 2)) {
            deleteOldCharacter(position);
            position.decY();
            setCharacter(position, '^');
            Cords newWall = new Cords(position.getX(), position.getY() - 1);
            setCharacter(newWall, '#');
        }
        else {
            setCharacter(position, '^');
            System.out.println("Sorry, you can't move there");
        }
    }

    public void moveDown() {
        if (cordValid(position.getX(), position.getY() + 1)) {
            deleteOldCharacter(position);
            position.incY();
            setCharacter(position, 'v');
        }
        else if(cordValid(position.getX(), position.getY() + 2)) {
            deleteOldCharacter(position);
            position.incY();
            setCharacter(position, 'v');
            Cords newWall = new Cords(position.getX(), position.getY() + 1);
            setCharacter(newWall, '#');
        }
        else {
            setCharacter(position, 'v');
            System.out.println("Sorry, you can't move there");
        }
    }

    public void moveLeft() {
        if (cordValid(position.getX() - 1, position.getY())) {
            deleteOldCharacter(position);
            position.decX();
            setCharacter(position, '<');
        }
        else if(cordValid(position.getX() - 2, position.getY())) {
            deleteOldCharacter(position);
            position.decX();
            setCharacter(position, '<');
            Cords newWall = new Cords(position.getX() - 1, position.getY());
            setCharacter(newWall, '#');
        }
        else {
            setCharacter(position, '<');
            System.out.println("Sorry, you can't move there");
        }
    }

    public void moveRight() {
        if (cordValid(position.getX() + 1, position.getY())) {
            deleteOldCharacter(position);
            position.incX();
            setCharacter(position, '>');
        }
        else if(cordValid(position.getX() + 2, position.getY())) {
            deleteOldCharacter(position);
            position.incX();
            setCharacter(position, '>');
            Cords newWall = new Cords(position.getX() + 1, position.getY());
            setCharacter(newWall, '#');
        }
        else {
            setCharacter(position, '>');
            System.out.println("Sorry, you can't move there");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Player: " + position;
    }
}
