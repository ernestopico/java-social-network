import java.util.Queue;
import java.util.LinkedList;

class GraphAlgorithms
{
    // Breadth-first search can be used to find the distance from the source to every account in the network.
    public static void breadthFirstSearch(Network network, Account source) {
        for(Account u : network.keySet()) {
            u.visited = false;
            u.distance = -1;
        }
        source.visited = true;
        source.distance = 0;
        Queue<Account> Q = new LinkedList<Account>();
        Q.add(source);
        while(! Q.isEmpty()) {
            Account u = Q.remove();
            for(Account v : network.get(u)) {
                if(! v.visited) {
                    v.visited = true;
                    v.distance = u.distance + 1;
                    Q.add(v);
                }
            }
        }
    }
	
	public static Account networkCenter(Network network){
		Account center = null;
		
		for(Account source: network.keySet()){
			breadthFirstSearch(network, source); 
			
			double sum = 0;
			for(Account acc : network.keySet()){
				if(acc.distance >= 0){
					sum = sum + acc.distance;
				}
			}
			source.eccentricity = sum/network.size();
			if(center == null || source.eccentricity < center.eccentricity){
				center = source;
			}
		}
		return center;
	}
		
}
