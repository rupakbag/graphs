package foursquare;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*  First we build the tree based on the routes provided. Each node contains a name field and a list of children nodes that it can contain.
*   If this node represents a complete route then the endpoint is populated with value provided otherwise it left empty.
*   Time Complexity building the tree O(nm) where n is the number of routes and m is the maximum numbers of components in a path.
*   Space Complexity of building the tree is O(nm) since the maximum number of nodes that can get created is nm.
*
*   Now given a path, we need to determine the endpoint name.
*   We declare two stacks. Stack1 stores the nodes visited as we traverse down the tree. Stack2 contains the index within the path that
*   we have traversed so far. We need this index in order to backtrack in case we don't find an exact match and we have encountered a wildcard "X"
*   which we can then use to traverse further down the tree.
*
*   At every level we store in the stack1 the node that directly matched with the path component along with the component index in stack2.
*   Besides the exact match we also push the wildcard "X" if present, which can then be used if an exact match is not found.
*   Time Complexity of findEndPoint method is the order of height of the tree which is O(m)
*
*   Final Time Complexity: O(nm)
*   Final Space Complexity: O(nm)
*/
public class Q2 {
    private static List<String> routeAll(List<Route> routes, List<String> paths) {
        List<String> endpoints = new ArrayList<String>();
        Node root = new Node("");
        buildTree(routes, root);
        for (String path : paths) {
            endpoints.add(findEndPoint(path, root));
        }
        return endpoints;
    }

    private static String findEndPoint(String path, Node root) {
        LinkedList<Node> stack1 = new LinkedList<>();
        LinkedList<Integer> stack2 = new LinkedList<>();
        String[] arr = path.split("/");
        if (arr.length == 0) return root.endPoint;

        stack1.add(root);
        stack2.add(1);
        while(!stack1.isEmpty()) {
            Node n = stack1.pollLast();
            int i = stack2.pollLast();
            if (arr.length == i) return n.endPoint;
            if (n.children == null) {
                continue;
            }
            if (n.children.containsKey("X")) {
                stack1.add(n.children.get("X"));
                stack2.add(i + 1);
            }
            String s = arr[i];
            if (n.children.containsKey(s)) {
                stack1.add(n.children.get(s));
                stack2.add(i + 1);
            }
        }
        return "404";
    }

    private static void buildTree(List<Route> routes, Node root) {
        Node n;
        for (Route r : routes) {
            n = root;
            for (String s : r.path.split("/")) {
                if (s.isEmpty()) continue;
                if (n.children == null) {
                    n.children = new HashMap<>();
                }
                if (!n.children.containsKey(s)) {
                    n.children.put(s, new Node(s));
                }
                n = n.children.get(s);
            }
            n.endPoint = r.endpoint;
        }
    }

    static class Node {
        String name;
        String endPoint;
        HashMap<String, Node> children;
        Node(String name) {
            this.name = name;
        }
    }
    /**
     *      Hey! You probably won't need to edit anything below here.
     */

    static class Route {
        String path;
        String endpoint;
        public Route(String path, String endpoint) {
            this.path = path;
            this.endpoint = endpoint;
        }
    }

    private static List<Route> getRoutes(InputStream is) throws IOException {
        List<Route> routes = new ArrayList<Route>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null && line.length() != 0) {
            String[] tokenizedLine = line.split(" ");
            routes.add(new Q2.Route(tokenizedLine[0], tokenizedLine[1]));
        }
        return routes;
    }

    private static List<String> getPaths(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        List<String> paths = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null && line.length() != 0) {
            paths.add(line);
        }
        return paths;
    }

    public static void main(String... args) throws IOException {
        List<Route> routes = Q2.getRoutes(new FileInputStream(args[0]));
        List<String> paths = Q2.getPaths(new FileInputStream(args[1]));

        for(String endpoint : Q2.routeAll(routes, paths)) {
            System.out.println(endpoint);
        }
    }
}

