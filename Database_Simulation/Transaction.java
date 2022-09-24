public class Transaction 
{
    private String pieceName;
    private double salesPrice;
    private int year;
    Collector Seller;
    Collector Buyer;

    public Transaction(String pieceName, Collector Seller, Collector Buyer, double salesPrice, int year)
    {
        this.pieceName = pieceName;
        this.salesPrice = salesPrice;
        this.year = year;
        this.Seller = Seller;
        this.Buyer = Buyer;
    }

    public String toString() //prints out all info about the transaction
    {
        String transaction = "[" + pieceName + " sold by " + Seller.toString() + " to " + Buyer.toString() + " in " + year + " for $" + salesPrice + "]";
        return transaction;
    }

    public double toPrice() //accessor for price used in TransactionDB
    {
        return salesPrice;
    }

    public int toYear() //accessor for year used in TransactionDB
    {
        return year;
    }

}
