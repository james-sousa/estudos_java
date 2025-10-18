public class Client extends Person{
    private double wallet;

    public Client() {}

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return getName() + " - Saldo: " + wallet;
    }
}
