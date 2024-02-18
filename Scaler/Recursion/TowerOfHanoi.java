import java.util.ArrayList;
import java.util.Arrays;

/*
    Problem: We have three towers A, B and C. We have the tiles in ascending order of size at tower A. 
    Now the problem is to movie all tiles from A to C using B with maintaining the ascending order of size at any tower
    T.C: O(N), S.C: O(N)
*/
public class TowerOfHanoi {

    private void TOH(int N, int src, int aux, int des, ArrayList<ArrayList<Integer>> moves) {
        // Assumption: Moves all N disks from src to dest using aux
        if (N == 0)
            return;

        // Solving the subproblem of moving N-1 tiles from source to auxiliary
        TOH(N - 1, src, des, aux, moves);

        // Making the move
        moves.add(new ArrayList<>(Arrays.asList(N, src, des)));

        // Solving the subproblem of moving N-1 tiles from auxiliary to destination
        TOH(N - 1, aux, src, des, moves);
    }

    public ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        TOH(A, 1, 2, 3, result);
        return result;
    }

}
