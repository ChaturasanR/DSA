/**
 * The legendary Farmer John is throwing a huge party, and animals from all over
 * the world are hanging out at his house. His guests are hungry, so he
 * instructs his cow Bessie to bring out the snacks! Moo!
 * 
 * There are A snacks flavors, numbered with integers 1,2,…,A. Bessie has A
 * snacks, one snack of each flavor. There are M guests and every guest has
 * exactly two favorite flavors. The procedure for eating snacks will go as
 * follows:
 * 
 * First, Bessie will line up the guests in some way.
 * Each guest in their turn will eat all remaining snacks of their favorite
 * flavor. In case no favorite flavors are present when a guest goes up, they
 * become very sad.
 * Help Bessie to minimize the number of sad guests by lining the guests in an
 * optimal way.
 * 
 * Solution:
 * 1. Consider snacks as nodes and the animals as edges
 * 2. If there is no cycle we can arrange the animals such that each get atleast
 * one snack
 * 3. So the number of sad guests = minimum edges needed to remove so that the
 * graph becomes acyclic
 * 4. Since it is undirected graph we can use DSU to check for how many edges it
 * leads to a cycle formation
 * 
 * T.C: O(V + E), S.C: O(V)
 */
public class CowsAndSnacks {

    public int getMinSadGuests(int totalSnacksFlavours, int[][] favouriteSnacksFlavours) {
        int[] parents = new int[totalSnacksFlavours + 1];
        fillParents(parents);

        int sadGuests = 0;
        for (int[] flavours : favouriteSnacksFlavours) {
            if (this.union(flavours[0], flavours[1], parents))
                sadGuests++;
        }
        return sadGuests;
    }

    private void fillParents(int[] parents) {
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    private boolean union(int u, int v, int[] parents) {
        int rootU = findRoot(u, parents);
        int rootV = findRoot(v, parents);
        if (rootU != rootV) {
            parents[rootU] = rootV;
            return false;
        }
        return true;
    }

    private int findRoot(int u, int[] parents) {
        if (parents[u] == u)
            return u;

        // path compression => O(1) avg retrieval
        parents[u] = findRoot(parents[u], parents);
        return parents[u];
    }

    public static void main(String[] args) {
        int totalSnacksFlavours = 5;
        int[][] favouriteSnacksFlavours = { { 1, 2 }, { 4, 3 }, { 1, 4 }, { 3, 4 } };
        CowsAndSnacks cowsAndSnacks = new CowsAndSnacks();
        System.out.println(cowsAndSnacks.getMinSadGuests(totalSnacksFlavours, favouriteSnacksFlavours));

        totalSnacksFlavours = 6;
        int[][] favouriteSnacksFlavours1 = { { 2, 3 }, { 2, 1 }, { 3, 4 }, { 6, 5 }, { 4, 5 } };
        System.out.println(cowsAndSnacks.getMinSadGuests(totalSnacksFlavours, favouriteSnacksFlavours1));
    }

}
