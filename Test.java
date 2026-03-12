class Test
{
    public static void main(String[] args) {
        Account a1 = new Account("frodo");
        Account a2 = new Account("sam");
        Account a3 = new Account("aragorn");
        Account a4 = new Account("legolas");
        Account a5 = new Account("gimli");
        Account a6 = new Account("gandalf");

        Network network = new Network();

        network.addAccount(a1);
        network.addAccount(a2);
        network.addAccount(a3);
        network.addAccount(a4);
        network.addAccount(a5);
        network.addAccount(a6);

        network.addConnection(a1, a2);
        network.addConnection(a1, a3);
        network.addConnection(a3, a4);
        network.addConnection(a3, a5);
        network.addConnection(a3, a6);
        network.addConnection(a4, a5);

        System.out.println("network:");
        System.out.println(network);

        System.out.println("\nbreadth-first search starting from " + a2 + "...");
        GraphAlgorithms.breadthFirstSearch(network, a2);
        System.out.println("distances to " + a2 + ":");
        for(Account acc : network.keySet()) {
            System.out.println("\t" + acc + ": " + acc.distance);
        }

        Account center = GraphAlgorithms.networkCenter(network);
        System.out.println("\ncenter: " + center + ", eccentricity: " + center.eccentricity);
    }
}

// expected output:

// network:
// {gimli=[legolas, aragorn], legolas=[gimli, aragorn], aragorn=[gimli, legolas, frodo, gandalf], frodo=[aragorn, sam], sam=[frodo], gandalf=[aragorn]}

// breadth-first search starting from sam...
// distances to sam:
//         gimli: 3
//         legolas: 3
//         aragorn: 2
//         frodo: 1
//         sam: 0
//         gandalf: 3

// center: aragorn, eccentricity: 1.0
