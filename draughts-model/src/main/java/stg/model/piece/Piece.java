package stg.model.piece;

import stg.model.board.Board;
import stg.model.board.Square;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rickjackson on 3/10/17.
 */
public class Piece {
    public Move move = new Move(this);
    private Square square;
    private PieceColor color;
    private PieceType type;
    
    public Piece() {
        
    }
    
    public Piece(PieceColor color, PieceType type) {
        this.color = color;
        this.type = type;
    }
    
    public Piece(int value) {
        setProperties(value);
    }
    
    public Square getSquare() {
        return square;
    }
    
    public void setSquare(Square square) {
        if (getSquare() != null) {
            getSquare().removePiece();
        }
        this.square = square;
        getSquare().placePiece(this);
    }
    
    public void setSquare(int index) {
        setSquare(getBoard().getSquare(index));
    }
    
    public Board getBoard() {
        return getSquare().getBoard();
    }
    
    public int atIndex() {
        return getSquare().index();
    }
    
    public PieceColor getColor() {
        return color;
    }
    
    public void setColor(PieceColor color) {
        this.color = color;
    }
    
    public void setColor(int i) {
        this.color = PieceColor.values()[i + 1];
    }
    
    public PieceType getType() {
        return type;
    }
    
    public void setType(PieceType type) {
        this.type = type;
    }
    
    public void setType(int i) {
        this.type = PieceType.values()[i];
    }
    
    public void setProperties(int i) {
        if (i < 0) {
            setColor(PieceColor.WHITE);
        } else if (i > 0) {
            setColor(PieceColor.BLACK);
        } else {
            setColor(PieceColor.EMPTY);
        }
        
        if (Math.abs(i) == 2) {
            setType(PieceType.KING);
        } else if (Math.abs(i) == 1) {
            setType(PieceType.MAN);
        } else {
            setType(PieceType.EMPTY);
        }
    }
    
    public int value() {
        return color.getValue() * type.getValue();
    }
    
    public boolean isMan() {
        return type.equals(PieceType.MAN);
    }
    
    public boolean isKing() {
        return type.equals(PieceType.KING);
    }
    
    public boolean isCaptured() {
        return color.equals(PieceColor.EMPTY) && type.equals(PieceType.EMPTY);
    }
    
    public void capture() {
        getSquare().removePiece();
        setProperties(0);
    }
    
    public boolean isSameColor(Piece piece) {
        return this.getColor().equals(piece.getColor());
    }
    
    @Override
    public String toString() {
        return color.equals(PieceColor.EMPTY) && type.equals(PieceType.EMPTY)
                ? "Empty"
                : color.toString() + " " + type.toString();
    }
    
    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
    
    public static class Move extends Moves {
        private Piece piece;
        private boolean mustJump;
        
        public Move(Piece piece) {
            this.piece = piece;
        }
        
        public void to(Square square) {
            piece.setSquare(square);
        }
        
        public void to(int index) {
            piece.setSquare(piece.getBoard().getSquare(index));
        }
        
        public void move(int to) {
            int i = piece.atIndex();
            
            if (i > to) {
                if (i - to > 6) {
                    jump(Direction.UP, getJumpLeftRight(to));
                } else {
                    simple(Direction.UP, getSimpleLeftRight(to));
                }
            } else {
                if (to - i > 6) {
                    jump(Direction.DOWN, getJumpLeftRight(to));
                } else {
                    simple(Direction.DOWN, getJumpLeftRight(to));
                }
            }
        }
        
        private Direction getUpDown(int to) {
            int i = piece.atIndex();
            
            if (i > to) {
                return Direction.UP;
            } else {
                return Direction.DOWN;
            }
        }
        
        private Direction getSimpleLeftRight(int to) {
            int i = piece.atIndex();
            
            if (rowIsEven()) {
                if (i - to == 4) {
                    return Direction.LEFT;
                } else if (i - to == 3) {
                    return Direction.RIGHT;
                } else if (to - i == 4) {
                    return Direction.LEFT;
                } else if (to - i == 5) {
                    return Direction.RIGHT;
                }
            } else {
                if (i - to == 5) {
                    return Direction.LEFT;
                } else if (i - to == 4) {
                    return Direction.RIGHT;
                } else if (to - i == 3) {
                    return Direction.LEFT;
                } else if (to - i == 4) {
                    return Direction.RIGHT;
                }
            }
            return null;
        }
        
        private Direction getJumpLeftRight(int to) {
            int i = piece.atIndex();
            
            if (i - to == 9) {
                return Direction.LEFT;
            } else if (i - to == 7) {
                return Direction.RIGHT;
            } else if (to - i == 7) {
                return Direction.LEFT;
            } else if (to - i == 9) {
                return Direction.RIGHT;
            }
            return null;
        }
        
        public void simple(Direction upDown, Direction leftRight) {
            Square simple = piece.move.getTarget(piece.getSquare(), upDown,
                                                 leftRight);
            piece.move.to(simple);
        }
        
        public void jump(Direction upDown, Direction leftRight) {
            Square simple = piece.move.getTarget(piece.getSquare(), upDown,
                                                 leftRight);
            Square jump = piece.move.getTarget(simple, upDown, leftRight);
            piece.move.capture(simple);
            piece.move.to(jump);
        }
        
        public void capture(Square jumped) {
            jumped.getPiece().capture();
        }
        
        public boolean isEmpty(Square square) {
            return square.isEmpty();
        }
        
        public boolean isEmpty(int index) {
            return piece.getBoard().getSquare(index).isEmpty();
        }
        
        public boolean isNotSameColor(Square square) {
            return !(piece.getColor().equals(square.getPiece().getColor()));
        }
        
        public Square getSimpleMoveTarget(Direction upDown,
                                          Direction leftRight) {
            if (upDown.equals(Direction.UP)) {
                if (leftRight.equals(Direction.LEFT)) {
                    return piece.getSquare().upLeft();
                } else {
                    return piece.getSquare().upRight();
                }
            } else {
                if (leftRight.equals(Direction.LEFT)) {
                    return piece.getSquare().downLeft();
                } else {
                    return piece.getSquare().downRight();
                }
            }
        }
        
        public Outcome checkMoveTo(Square target) {
            if (target == null) {
                return Outcome.INVALID;
            } else if (target.isEmpty()) {
                return Outcome.EMPTY;
            } else if (target.getPiece().isSameColor(piece)) {
                return Outcome.SAME;
            } else {
                return Outcome.OTHER;
            }
        }
        
        public Square getTarget(Square square, Direction upDown,
                             Direction leftRight) {
            if (upDown.equals(Direction.UP)) {
                if (leftRight.equals(Direction.LEFT)) {
                    return square.upLeft();
                } else {
                    return square.upRight();
                }
            } else {
                if (leftRight.equals(Direction.LEFT)) {
                    return square.downLeft();
                } else {
                    return square.downRight();
                }
            }
        }
        
        public int getTargetIndex(Square target) {
            return target == null ? -1 : target.index();
        }
        
        public boolean isValid(Square target) {
            return target != null && target.isEmpty();
        }
        
        public boolean checkJump(Square simple) {
            return checkMoveTo(simple).equals(Outcome.OTHER);
        }
        
        public boolean canJumpTo(Square jump) {
            return checkMoveTo(jump).equals(Outcome.EMPTY);
        }
        
        public MoveType moveType(Direction upDown, Direction leftRight) {
            Square simple = getTarget(piece.getSquare(), upDown, leftRight);
            Square jump;
            MoveType type = MoveType.NONE;
            
            switch (checkMoveTo(simple)) {
                case INVALID:
                case SAME:
                    type = MoveType.NONE;
                    break;
                case EMPTY:
                    type = MoveType.SIMPLE;
                    break;
                case OTHER:
                    type = MoveType.JUMP;
                    break;
            }
            if (type.equals(MoveType.JUMP)) {
                jump = getTarget(simple, upDown, leftRight);
                
                if (checkMoveTo(jump).equals(Outcome.EMPTY)) {
                    type = MoveType.JUMP;
                } else {
                    type = MoveType.NONE;
                }
            }
            return type;
        }
        
        public boolean mustJump() {
            if (Math.abs(piece.value()) == 2) {
                return moveType(Direction.UP, Direction.LEFT) == MoveType.JUMP
                        || moveType(Direction.UP, Direction.RIGHT)
                           == MoveType.JUMP
                        || moveType(Direction.DOWN, Direction.LEFT)
                           == MoveType.JUMP
                        || moveType(Direction.DOWN, Direction.RIGHT)
                           == MoveType.JUMP;
            } else if (piece.value() < 0) {
                return moveType(Direction.UP, Direction.LEFT) == MoveType.JUMP
                        || moveType(Direction.UP, Direction.RIGHT)
                           == MoveType.JUMP;
            } else {
                return moveType(Direction.DOWN, Direction.LEFT) == MoveType.JUMP
                        || moveType(Direction.DOWN, Direction.RIGHT)
                           == MoveType.JUMP;
            }
        }
        
        public Square getMoveTo(boolean mustJump, Direction upDown,
                               Direction leftRight) {
            Square target = getTarget(piece.getSquare(), upDown, leftRight);
            
            if (mustJump) {
                if (checkMoveTo(target).equals(Outcome.OTHER)) {
                    target = getTarget(target, upDown, leftRight);
                    if (!checkMoveTo(target).equals(Outcome.EMPTY)) {
                        target = null;
                    }
                } else {
                    target = null;
                }
            } else {
                if (!checkMoveTo(target).equals(Outcome.EMPTY)) {
                    target = null;
                }
            }
            return target;
        }
        
        public List<Integer> getDirectionMoves(boolean mustJump,
                                               Direction upDown) {
            List<Integer> moves;
            Square left = getMoveTo(mustJump, upDown, Direction.LEFT);
            Square right = getMoveTo(mustJump, upDown, Direction.RIGHT);
            
            if (left == null && right == null) {
                return new ArrayList<>(0);
            } else if (left == null) {
                moves = new ArrayList<>(1);
                moves.add(right.index());
                return moves;
            } else if (right == null) {
                moves = new ArrayList<>(1);
                moves.add(left.index());
                return moves;
            } else {
                moves = new ArrayList<>(2);
                moves.add(left.index());
                moves.add(right.index());
                return moves;
            }
        }
        
        public List<Integer> getAvailableMoves(boolean mustJump) {
            List<Integer> moves = new ArrayList<>(4);
            
            if (Math.abs(piece.value()) == 2) {
                moves.addAll(getDirectionMoves(mustJump, Direction.UP));
                moves.addAll(getDirectionMoves(mustJump, Direction.DOWN));
            } else if (piece.value() < 0) {
                moves.addAll(getDirectionMoves(mustJump, Direction.UP));
            } else {
                moves.addAll(getDirectionMoves(mustJump, Direction.DOWN));
            }
            return moves;
        }
        
        private boolean upMove(int to) {
            return to - piece.atIndex() < 0;
        }
        
        private boolean colIsEven() {
            return piece.getSquare().getCol() % 2 == 0;
        }
        
        private boolean rowIsEven() {
            return piece.getSquare().getRow() % 2 == 0;
        }
    }
}
