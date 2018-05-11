package tammi.game;

public class Square {

    private final int x;
    private final int y;
    private Piece piece = null;

    public Square(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public final Piece getPiece() {
        return piece;
    }

    public final void setPiece(final Piece piece) {
        this.piece = piece;
    }

    public final boolean hasPiece() {
        return piece != null;
    }

    public final void removePiece() {
        this.piece = null;
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }
}
