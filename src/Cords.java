class Cords {
    private int x;
    private int y;

    /**
     * Stores a set of coordinates
     * @param x The x-value of the (x, y) pair
     * @param y The y-value of the (x, y) pair
     */
    Cords(int x, int y) {
        setX(x);
        setY(y);
    }

    private void setX(int x) {
        this.x = x;
    }

    private void setY(int y) {
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void incX() {
        x++;
    }

    void incY() {
        y++;
    }

    void decX() {
        x--;
    }

    void decY() {
        y--;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cords) {
            Cords otherCords = (Cords) obj;
            if (otherCords.getX() == x && otherCords.getY() == y)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "x = " + x + ", y = " + y + "\n";
    }
}
