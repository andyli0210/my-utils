/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andyli.myutils.problem;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author yan
 */
public class P1394 {

    private class Node {

        String name;
        List<Edge> edges;

        public Node(String name) {
            this.name = name;
            edges = new ArrayList<Edge>();
        }

        public void addEdge(Edge edge) {
            this.edges.add(edge);
        }
    }

    private class Edge {

        Node next;
        String leaveTime;
        String arriveTime;

        public Edge(Node next, String leaveTime, String arriveTime) {
            this.next = next;
            this.leaveTime = leaveTime;
            this.arriveTime = arriveTime;
        }
    }
    
    public static void main(String[]args) {
        P1394 p1394 = new P1394();
        p1394.run(System.in);
    }
    
    private String startStop;
    private String endStop;
    private String earliestArriveTime;
    private String latestLeaveTime;
    private String earliestLeaveTime;

    private void findMinTravel(Edge edge, String leaveTime) {
        String stopName = edge.next.name;

        if (stopName.equals(endStop)) {
            if (edge.arriveTime.compareTo(earliestArriveTime) <= 0) {
                earliestArriveTime = edge.arriveTime;
                if (latestLeaveTime.compareTo(leaveTime) < 0) {
                    latestLeaveTime = leaveTime;
                }
                return;
            }

        }

        Node node = edge.next;
        String arriveTime = edge.arriveTime;
        for (Edge nextEdge : node.edges) {
            if (nextEdge.leaveTime.compareTo(arriveTime) > 0) {
                findMinTravel(nextEdge, leaveTime);
            }
        }
    }

    public void run(InputStream in) {
        Scanner scanner = new Scanner(in);

        int index = 0;
        while (scanner.hasNext()) {
            index++;
            solveScenario(scanner, index);
        }

    }

    public void solveScenario(Scanner scanner, int index) {
        int numOfNodes = scanner.nextInt();
        if (numOfNodes == 0) {
            return;
        }
        Map<String, Node> nodes = readNodes(scanner, numOfNodes);

        int numOfTrains = scanner.nextInt();
        readTrains(nodes, numOfTrains, scanner);

        earliestLeaveTime = scanner.next();
        String start = scanner.next();
        String end = scanner.next();

        System.out.println("Scenario #" + index);
        output(nodes, start, end);
        System.out.println("");

    }

    private Map<String, Node> readNodes(Scanner scanner, int n) {
        Map<String, Node> nodes = new HashMap<String, Node>();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            Node node = new Node(name);
            nodes.put(name, node);
        }
        return nodes;
    }

    private void readTrains(Map<String, Node> nodes, int n, Scanner scanner) {
        for (int i = 0; i < n; i++) {
            int numOfStops = scanner.nextInt();
            readEdges(nodes, numOfStops, scanner);
        }
    }

    private void readEdges(Map<String, Node> nodes, int n, Scanner scanner) {
        String lasetstartTime = scanner.next();
        String lastStop = scanner.next();

        Node startNode = nodes.get(lastStop);
        for (int i = 0; i < n - 1; i++) {
            String endTime = scanner.next();
            String nextStop = scanner.next();

            Node endNode = nodes.get(nextStop);

            Edge edge = new Edge(endNode, lasetstartTime, endTime);
            startNode.addEdge(edge);

            lasetstartTime = endTime;
            startNode = endNode;
        }
    }

    private void output(Map<String, Node> nodes, String start, String end) {
        startStop = start;
        endStop = end;
        earliestArriveTime = "9999";
        latestLeaveTime = "0000";

        Node startNode = nodes.get(start);

        for (Edge edge : startNode.edges) {
            if (edge.leaveTime.compareTo(earliestLeaveTime) > 0) {
                String leaveTime = edge.leaveTime;
                findMinTravel(edge, leaveTime);
            }
        }

        if (earliestArriveTime.equals("9999") || latestLeaveTime.equals("0000")) {
            System.out.println("No connection");
        } else {
            System.out.println("Departure " + latestLeaveTime + " " + start);
            System.out.println("Arrival   " + earliestArriveTime + " " + end);
        }
    }
}
