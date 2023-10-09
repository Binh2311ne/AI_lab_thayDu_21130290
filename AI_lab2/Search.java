import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Search implements ISearchAlgo {
    public Node execute(Node root, String goal) {
        Queue<Node> frontier = new LinkedList<Node>();
        frontier.add(root);
        List<Node> explaned = new ArrayList<Node>();
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            if (current.getLabel().equals(goal))
                return current;
            explaned.add(current);
            List<Node> children = current.getChildrenNodes();
            for (Node child : children) {
                if ((!frontier.contains(child)) && (!explaned.contains(child)))
                    frontier.add(child);
                child.setParent(current);

            }

        }
        return null;

    }

    @Override
    public Node execute(Node root, String start, String goal) {

        return null;
    }

    public static void main(String[] args) {
        Node nodeS = new Node("S");
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        nodeS.addEdge(nodeA, 5);
        nodeS.addEdge(nodeB, 2);
        nodeS.addEdge(nodeC, 4);
        nodeA.addEdge(nodeD, 9);
        nodeA.addEdge(nodeE, 4);
        nodeB.addEdge(nodeG, 6);
        nodeC.addEdge(nodeF, 2);
        nodeD.addEdge(nodeH, 7);
        nodeE.addEdge(nodeG, 6);
        nodeF.addEdge(nodeG, 1);
        BFSGraphSearch algo1 = new BFSGraphSearch();
        Node result = algo1.execute(nodeS, "G");
        System.out.println(result.toString());
    }

}


