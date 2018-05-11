package tammi.game;

public enum Piece {
    WHITE(1),
    BLACK(-1);

    private final int yDirection;

    Piece(final int yDirection) {
        this.yDirection = yDirection;
    }

    public int getyDirection() {
        return yDirection;
    }

}
