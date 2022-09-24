public class TransactionDB 
{
    private Transaction[] database;
    private int numTransactions;
    private double recentValue;        //keeps count of the value of the transactions made in the most recent year
    private int numRecentTransactions; //keeps count of the transactions made in the most recent year
    private int mostRecentYear;        //keeps track of which is the most recent year

    public TransactionDB()
    {
        database = new Transaction[100]; 
        numTransactions = 0;
        recentValue = 0;
        mostRecentYear = 0;
        numRecentTransactions = 0;
    }

    public void add(Transaction newTr)
    {
        if (numTransactions == database.length) 
        {
            expandDatabase();
        }

        database[numTransactions] = newTr;

        if(newTr.toYear() > mostRecentYear)     //if the year of the transaction added is more recent than the most recent year on record
        {                                       //it resets num and value of most recent transactions and updates the most recent year
            mostRecentYear = newTr.toYear();
            recentValue = 0;
            numRecentTransactions = 0;
        }

        if(newTr.toYear() == mostRecentYear) //if the transaction added was made in the most recent year it will increase the value and num of recent transactions
        {
            recentValue += newTr.toPrice();
            numRecentTransactions++;
        }

        numTransactions++;
    }

    public String toString() //prints out all data in the database
    {
        String report;

        if(numTransactions < 0)
        {
            report = "There are no transactions in the database";
        }
        else
        {
            report = "";
            for(int x=0; x<numTransactions ;x++)
            {
                report += database[x].toString() + "\n";
            }
        }
        
        return report;
    }

    public int numTransactions()
    {
        return numTransactions;
    }

    public double avgRecentCost() //calculates avg of the most recent transactions
    {
        double avgCost = (recentValue/numRecentTransactions);
        return avgCost;
    }

    private void expandDatabase() //if called, expands the length of the database by 2 with the use of a temp array
    {
        Transaction[] temp = new Transaction[database.length * 2];

        for (int num=0; num < database.length; num++)
        {
            temp[num] = database[num];
        }

        database = temp;
    }

}
