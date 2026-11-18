// https://leetcode.com/problems/accounts-merge/

// Java
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // keep track of the relationship between nodes
        Map<String, List<String>> graph = new HashMap<>();

        // keep track of the parent name for a given email
        Map<String, String> emailToName = new HashMap<>();

        // build the map
        for (List<String> acc : accounts) {
            String name = acc.get(0);

            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                emailToName.put(email, name); // set the mapping in emailToName
                graph.putIfAbsent(email, new ArrayList<>()); // add a path between i and i-1

                if (i > 1){
                    graph.get(acc.get(i)).add(acc.get(i-1));
                    graph.get(acc.get(i- 1)).add(acc.get(i));
                }
            }
        }

        // i need a res and also a visited set
        List<List<String>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        // iterate through all the emails
        for (String email : emailToName.keySet()){
            if (!visited.contains(email)){
                List<String> neighbours = new ArrayList<>(); // create new listarray to store all the connected emails
                dfs(email, visited, graph, neighbours); // use dfs to get all the connected emails
                Collections.sort(neighbours); // sort the email
                List<String> account = new ArrayList<>(); // init account
                account.add(emailToName.get(email)); // acc must start with the acc name
                account.addAll(neighbours);
                res.add(account);
            }
        }

        return res;
    }

    public void dfs(String email, Set<String> visited, Map<String, List<String>> graph, List<String> neighbours) {
        // add to visited so you dont traverse again
        visited.add(email);

        // add to the list
        neighbours.add(email);

        // iterate through all the neighbours from the graph recursively if not yet visited
        for (String neighbour : graph.get(email)) {
            // if already visited, means already in the neighbours array
            if(!visited.contains(neighbour)) dfs(neighbour, visited, graph, neighbours);
        }
    }
}


// we can use an Adjacency List to represent the eamils as a graph
// the key will be an email and the value is a list of all the emails it is connected to
// but we also need anotehr map to keep track of the owner of each email for use later
// i can create the adjanmcemcy list by iterating trhough the accounts
    // instead of comparing each and every pair, just connect i and i - 1
// we then use dfs to find all the neighbours