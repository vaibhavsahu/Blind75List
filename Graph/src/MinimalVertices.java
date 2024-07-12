import java.util.*;

public class MinimalVertices {

        int discoveryTime = 0; // discovery time

        // Nodes in adjacency lists are numbered from 0 to N - 1
        public void findSccAndDecrementIndegreeOfRoot(List<Set<Integer>> adjacencyLists, int[] indegree) {
            discoveryTime = 0; // reset index to 0
            int len = adjacencyLists.size();
            int[] discoveryTime = new int[len];
            int[] earliestDiscoveredNodeReachable = new int[len];
            Deque< Integer > sccStack = new ArrayDeque<>();
            boolean[] onStack = new boolean[len];

            for (int i = 0; i < adjacencyLists.size(); i++) {
                if (discoveryTime[i] == 0) { // indices[i] == 0 when vertex i is not already visited
                    dfs(adjacencyLists, discoveryTime, earliestDiscoveredNodeReachable, sccStack, onStack, i, indegree);
                }
            }
        }

        private void dfs(
                List<Set<Integer>> adjacencyLists,
                int[] discoveryTimes,
                int[] earliestDiscoveredNodeReachable,
                Deque< Integer > strongComponentStack,
                boolean[] onStack,
                int currentNode,
                int[] indegree)
        {
            discoveryTime++;
            discoveryTimes[currentNode] = discoveryTime; // array is zero based index, nodes are numbered from 0 to N - 1
            earliestDiscoveredNodeReachable[currentNode] = discoveryTime;
            strongComponentStack.push(currentNode);
            onStack[currentNode] = true;
            for (int adjVertex : adjacencyLists.get(currentNode)) { //adjacencyList of vertex i is stored ar index i in arraylist
                if (discoveryTimes[adjVertex] == 0) { // discoveryTime[v] == 0 when vertex v is not already visited
                    dfs(adjacencyLists, discoveryTimes, earliestDiscoveredNodeReachable, strongComponentStack, onStack, adjVertex, indegree);
                    earliestDiscoveredNodeReachable[currentNode] =
                            Math.min(earliestDiscoveredNodeReachable[currentNode], earliestDiscoveredNodeReachable[adjVertex]);
                } else { // adjacentVertex is already visited
                    if (!onStack[adjVertex]) {
                        continue;
                    } else {
                        // adjacent vertex is in stack, so must be in the same SCC
                        earliestDiscoveredNodeReachable[currentNode] =
                                Math.min(earliestDiscoveredNodeReachable[currentNode], discoveryTimes[adjVertex]);
                    }
                }
            }
            // now that DFS on currentNode is done lets see
            // if we got any SCC before backtracking
            if (earliestDiscoveredNodeReachable[currentNode] == discoveryTimes[currentNode]) {
                Set< Integer > sccNodes = new HashSet<>();
                int top = 0;
                // construct a set of all the nodes in this SCC
                do {
                    top = strongComponentStack.pop();
                    sccNodes.add(top);
                    onStack[top] = false;
                } while (top != currentNode); // root can have self loop as well. it takes care of that too.

                for (int current : sccNodes) {
                    for (int otherNode : sccNodes) {
                        if (adjacencyLists.get(otherNode).contains(current)) {
                            indegree[current]--;
                        }
                    }
                }
                boolean isolatedSCC = true;
                for (int sccNode : sccNodes) {
                    if (indegree[sccNode] != 0) {
                        isolatedSCC = false;
                    }
                }
                for (int sccNode : sccNodes) {
                    indegree[sccNode] = Integer.MAX_VALUE;
                }
                if (isolatedSCC) {
                    indegree[currentNode] = 0;
                }

            }

        }


        public List<Integer> getMinimalVertices(List<Set<Integer>> adjacencyLists) {
            int totalNumberOfUsers = adjacencyLists.size();
            int[] indegree = new int[totalNumberOfUsers];
            for (Set< Integer > adjacencyList : adjacencyLists) {
                for (int user : adjacencyList) {
                    indegree[user]++;
                }
            }
            findSccAndDecrementIndegreeOfRoot(adjacencyLists, indegree);

            List< Integer > res = new ArrayList<>();

            for (int i = 0; i < totalNumberOfUsers; i++) {
                if (indegree[i] == 0) {
                    res.add(i);
                }
            }
            return res;
        }

        public static void main(String[] args) {
            List<Set<Integer>> adjLists = new ArrayList<>();
            adjLists.add(new HashSet< Integer >() {{ add(1); }}); // for node 0
            adjLists.add(new HashSet< Integer >() {{ add(2); }}); // for node 1
            adjLists.add(new HashSet< Integer >() {{ add(3); }}); // for node 2
            adjLists.add(new HashSet< Integer >() {{ add(4); }}); // for node 2

            MinimalVertices ob = new MinimalVertices();
            List< Integer > res = ob.getMinimalVertices(adjLists);
            for (int i : res) {
                System.out.print(i + "  ");
            }
            System.out.println();
            System.out.println();
            /*
           0<-------1
                  _
            \     /|
            _\|  /
               2

              / \
               |
               3
               |
              \ /

               6 _
             /  |\
           |/_    \
            4----->5

            Expected Result => 3
         */
            adjLists = new ArrayList<>();
            adjLists.add(new HashSet< Integer >() {{ add(2); }}); // for node 0
            adjLists.add(new HashSet< Integer >() {{ add(0); }}); // for node 1
            adjLists.add(new HashSet< Integer >() {{ add(1); }}); // for node 2
            adjLists.add(new HashSet< Integer >() {{ add(2); add(6); }}); // for node 3
            adjLists.add(new HashSet< Integer >() {{ add(5); }}); // for node 4
            adjLists.add(new HashSet< Integer >() {{ add(6); }}); // for node 5
            adjLists.add(new HashSet< Integer >() {{ add(4); }}); // for node 6

             ob = new MinimalVertices();
            res = ob.getMinimalVertices(adjLists);
            for (int i : res) {
                System.out.print(i + "  ");
            }
            System.out.println();
            System.out.println();

        /*
           0<-------1
                  _
            \     /|
            _\|  /
               2

               3

               6 _
             /  |\
           |/_    \
            4----->5

            Expected Result => 3 and (0 or 1 or 2) and (4 or 5 or 6)
         */
            adjLists = new ArrayList<>();
            adjLists.add(new HashSet< Integer >() {{ add(2); }}); // for node 0
            adjLists.add(new HashSet< Integer >() {{ add(0); }}); // for node 1
            adjLists.add(new HashSet< Integer >() {{ add(1); }}); // for node 2
            adjLists.add(new HashSet< Integer >()); // for node 3
            adjLists.add(new HashSet< Integer >() {{ add(5); }}); // for node 4
            adjLists.add(new HashSet< Integer >() {{ add(6); }}); // for node 5
            adjLists.add(new HashSet< Integer >() {{ add(4); }}); // for node 6

            ob = new MinimalVertices();
            res = ob.getMinimalVertices(adjLists);
            for (int i : res) {
                System.out.print(i + "  ");
            }
            System.out.println();
            System.out.println();


        /*
           0<-------1
                  _
            \     /|
            _\|  /
               2
               ^
               |
               3

               6 _
             /  |\
           |/_    \
            4----->5

            Expected Result => 3 and (4 or 5 or 6)
         */
            adjLists = new ArrayList<>();
            adjLists.add(new HashSet< Integer >() {{ add(2); }}); // for node 0
            adjLists.add(new HashSet< Integer >() {{ add(0); }}); // for node 1
            adjLists.add(new HashSet< Integer >() {{ add(1); }}); // for node 2
            adjLists.add(new HashSet< Integer >() {{ add(2);}}); // for node 3
            adjLists.add(new HashSet< Integer >() {{ add(5); }}); // for node 4
            adjLists.add(new HashSet< Integer >() {{ add(6); }}); // for node 5
            adjLists.add(new HashSet< Integer >() {{ add(4); }}); // for node 6

            ob = new MinimalVertices();
            res = ob.getMinimalVertices(adjLists);
            for (int i : res) {
                System.out.print(i + "  ");
            }
            System.out.println();
            System.out.println();


        /*
           0<-------1
                  _
            \     /|
            _\|  /
               2

               |
              \ /

               3 _
             /  |\
           |/_    \
            4----->5

            Expected result => 0 or 1 or 2
         */
            adjLists = new ArrayList<>();
            adjLists.add(new HashSet< Integer >() {{ add(2); }}); // for node 0
            adjLists.add(new HashSet< Integer >() {{ add(0); }}); // for node 1
            adjLists.add(new HashSet< Integer >() {{ add(1); add(3); }}); // for node 2
            adjLists.add(new HashSet< Integer >() {{ add(4); }}); // for node 3
            adjLists.add(new HashSet< Integer >() {{ add(5); }}); // for node 4
            adjLists.add(new HashSet< Integer >() {{ add(3); }}); // for node 5

            ob = new MinimalVertices();
            res = ob.getMinimalVertices(adjLists);
            for (int i : res) {
                System.out.print(i + "  ");
            }
            System.out.println();
            System.out.println();

        /*
           0<-------1
                  _
            \     /|
            _\|  /
               2


               3 _
             /  |\
           |/_    \
            4----->5

            Expected result => (0 or 1 or 2) and (3 or 4 or 5)
         */
            adjLists = new ArrayList<>();
            adjLists.add(new HashSet< Integer >() {{ add(2); }}); // for node 0
            adjLists.add(new HashSet< Integer >() {{ add(0); }}); // for node 1
            adjLists.add(new HashSet< Integer >() {{ add(1); }}); // for node 2
            adjLists.add(new HashSet< Integer >() {{ add(4); }}); // for node 3
            adjLists.add(new HashSet< Integer >() {{ add(5); }}); // for node 4
            adjLists.add(new HashSet< Integer >() {{ add(3); }}); // for node 5

            ob = new MinimalVertices();
            res = ob.getMinimalVertices(adjLists);
            for (int i : res) {
                System.out.print(i + "  ");
            }
            System.out.println();
            System.out.println();



        /*
            0

            Expected Result: 0
         */
            adjLists = new ArrayList<>();
            adjLists.add(new HashSet< Integer >()); // for node 0
            ob = new MinimalVertices();
            res = ob.getMinimalVertices(adjLists);
            for (int i : res) {
                System.out.print(i + "  ");
            }
            System.out.println();
            System.out.println();

        /*
            0------>1
            ^       |
            |_______|

            ExpectedResult: 0 or 1
         */
            adjLists = new ArrayList<>();
            adjLists.add(new HashSet< Integer >(){{add(1);}}); // for node 0
            adjLists.add(new HashSet< Integer >(){{add(0);}}); // for node 1
            ob = new MinimalVertices();
            res = ob.getMinimalVertices(adjLists);
            for (int i : res) {
                System.out.print(i + "  ");
            }
            System.out.println();
            System.out.println();


        /*
            1------>0

            ExpectedResult: 1
         */
            adjLists = new ArrayList<>();
            adjLists.add(new HashSet< Integer >()); // for node 0
            adjLists.add(new HashSet< Integer >(){{add(0);}}); // for node 1
            ob = new MinimalVertices();
            res = ob.getMinimalVertices(adjLists);
            for (int i : res) {
                System.out.print(i + "  ");
            }
            System.out.println();


        }


    }
