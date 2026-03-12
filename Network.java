// Do not modify.

import java.util.HashMap;
import java.util.LinkedList;

class Network extends HashMap<Account, LinkedList<Account>>
{
    public void addAccount(Account acc) {
        this.put(acc, new LinkedList<Account>());
    }

    public void addConnection(Account acc1, Account acc2) {
        this.get(acc1).add(acc2);
        this.get(acc2).add(acc1);
    }
}
