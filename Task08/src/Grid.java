/**
 * Created by Birthright on 04.12.2015.
 */
public class Grid {

    private final int SIZE;

    private Stone[][] stones;

    public Grid(int size) {
        SIZE = size;
        stones = new Stone[SIZE][SIZE];
    }


    public int[] addStone(int row, int col, StoneColor state) {
        int count = 0;
        Stone newStone = new Stone(row, col, state);
        stones[row][col] = newStone;
        Stone[] neighbors;
        if (row == 0 && col == 0) {
            neighbors = new Stone[2];
            neighbors[0] = stones[row + 1][col];
            neighbors[1] = stones[row][col + 1];
        } else {
            if (row == SIZE - 1 && col == 0) {
                neighbors = new Stone[2];
                neighbors[0] = stones[row - 1][col];
                neighbors[1] = stones[row][col + 1];
            } else {
                if (row == 0 && col == SIZE - 1) {
                    neighbors = new Stone[2];
                    neighbors[0] = stones[row + 1][col];
                    neighbors[1] = stones[row][col - 1];
                } else {
                    if (row == SIZE - 1 && col == SIZE - 1) {
                        neighbors = new Stone[2];
                        neighbors[0] = stones[row][col - 1];
                        neighbors[1] = stones[row - 1][col];
                    } else {
                        if (row == 0) {
                            neighbors = new Stone[3];
                            neighbors[0] = stones[row][col - 1];
                            neighbors[1] = stones[row][col + 1];
                            neighbors[2] = stones[row + 1][col];
                        } else {
                            if (row == SIZE - 1) {
                                neighbors = new Stone[3];
                                neighbors[0] = stones[row][col - 1];
                                neighbors[1] = stones[row][col + 1];
                                neighbors[2] = stones[row - 1][col];
                            } else {
                                if (col == 0) {
                                    neighbors = new Stone[3];
                                    neighbors[0] = stones[row + 1][col];
                                    neighbors[1] = stones[row - 1][col];
                                    neighbors[2] = stones[row][col + 1];
                                } else {
                                    if (col == SIZE - 1) {
                                        neighbors = new Stone[3];
                                        neighbors[0] = stones[row + 1][col];
                                        neighbors[1] = stones[row - 1][col];
                                        neighbors[2] = stones[row][col - 1];
                                    } else {
                                        neighbors = new Stone[4];
                                        neighbors[0] = stones[row - 1][col];
                                        neighbors[1] = stones[row + 1][col];
                                        neighbors[2] = stones[row][col - 1];
                                        neighbors[3] = stones[row][col + 1];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        int[] points = new int[2];
        Chain finalChain = new Chain();
        for (Stone neighbor : neighbors) {
            if (neighbor == null) {
                continue;
            }
            newStone.setLiberties(newStone.getLiberties() - 1);
            neighbor.setLiberties(neighbor.getLiberties() - 1);
            if (neighbor.getState() != newStone.getState()) {
                points[0] += removeGroupIfDead(neighbor);
                continue;
            }
            if (neighbor.getState() != null) {
                finalChain.join(neighbor.getChain());
            }

        }
        finalChain.addStone(newStone);
        if (newStone.getLiberties() == 0) {
            points[1] += removeGroupIfDead(newStone);
        }
        return points;
    }


    public int removeGroupIfDead(Stone stone) {
        int count = 0;
        if (!stone.getChain().getLiberties()) {
            for (Stone s : stone.getChain().getStones()) {
                s.setChain(null);
                stones[s.getRow()][s.getCol()] = null;
                count++;
            }
        }
        return count;
    }

    public boolean isOccupied(int row, int col) {
        return stones[row][col] != null;
    }


    public StoneColor getState(int row, int col) {
        Stone stone = stones[row][col];
        if (stone == null) {
            return null;
        } else {

            return stone.getState();
        }
    }
}
