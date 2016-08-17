package net.coderodde.graph.radius;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import net.coderodde.graph.UnweightedGraphNode;

/**
 * This class implements a brute-force algorithm for computing the radius of 
 * an unweighted graph. The graph radius in question is defined as follows:
 * for each graph node, run breadth-first search and return the maximum length
 * from the source node to any other node. Gather the same number over all of 
 * the nodes and then pick the smallest of them.
 * 
 * @author Rodion "rodde" Efremov
 * @version 1.6 (Nov 20, 2015)
 */
public class GraphRadiusFinder {

    private Deque<UnweightedGraphNode> queue;
    private Map<UnweightedGraphNode, Integer> distanceMap;

    public GraphRadiusFinder() {}

    private GraphRadiusFinder(boolean dummy) {
        this.queue = new ArrayDeque();
        this.distanceMap = new HashMap();
    }

    public int compute(UnweightedGraphNode connectedComponentRepresentative) {
        Objects.requireNonNull(connectedComponentRepresentative,
                               "The graph component representative is null.");
        GraphRadiusFinder finderState = new GraphRadiusFinder(false);
        List<UnweightedGraphNode> connectedComponent = 
                finderState.expand(connectedComponentRepresentative);

        int radius = Integer.MAX_VALUE;

        for (UnweightedGraphNode node : connectedComponent) {
            int tentativeRadius = finderState.getMaximumDistanceFrom(node);

            if (radius > tentativeRadius) {
                radius = tentativeRadius;
            }
        }

        return radius;
    }

    private int getMaximumDistanceFrom(UnweightedGraphNode node) {
        queue.clear();
        distanceMap.clear();

        queue.addLast(node);
        distanceMap.put(node, 0);

        int maximumDistance = 0;

        while (!queue.isEmpty()) {
            UnweightedGraphNode current = queue.removeFirst();

            for (UnweightedGraphNode child : current.children()) {
                if (!distanceMap.containsKey(child)) {
                    int distance = distanceMap.get(current) + 1;
                    distanceMap.put(child, distance);
                    queue.addLast(child);

                    if (maximumDistance < distance) {
                        maximumDistance = distance;
                    }
                }
            }
        }

        return maximumDistance;
    }

    private List<UnweightedGraphNode> expand(UnweightedGraphNode node) {
        queue.add(node);
        distanceMap.put(node, 0);

        while (!queue.isEmpty()) {
            UnweightedGraphNode current = queue.removeFirst();

            for (UnweightedGraphNode child : current.children()) {
                if (!distanceMap.containsKey(child)) {
                    distanceMap.put(child, 0);
                    queue.addLast(child);
                }
            }
        }

        return new ArrayList(distanceMap.keySet());
    }
}