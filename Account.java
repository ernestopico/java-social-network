// Do not modify.

class Account
{
    private String username; // uniquely identifies this object

    // variables used by GraphAlgorithms
    public boolean visited;
    public int distance; // smallest number of steps from the source to this account
    public double eccentricity;

    public Account(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object obj) {
        Account acc = (Account) obj;
        return this.username.equals(acc.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public String toString() {
        return username;
    }
}
