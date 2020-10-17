package others;

import java.util.ArrayList;

public class Graph {
    private ArrayList<ArrayList<Object>> graphList;

    public Graph(int size) {
        graphList = new ArrayList<ArrayList<Object>>();
        for (int i = 0; i < size + 1; i++) {
            graphList.add(new ArrayList<>());
        }
    }

    public ArrayList<ArrayList<Object>> getGraph() {
        return graphList;
    }

    public ArrayList<Object> getValue(int i) {
        return graphList.get(i);
    }

    public void add(int x, int y) {
        graphList.get(x).add(y);
        graphList.get(y).add(x);
    }

    public void putSingle(int x, int y) {
        graphList.get(x).add(y);
    }

    public void print() {
        for (int i = 1; i < graphList.size(); i++) {
            for (int j = 0; j < graphList.get(i).size(); j++) {
                System.out.print(" -> " + graphList.get(i).get(j));
            }
            System.out.println();
        }
    }
}
