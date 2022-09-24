public class Collector 
{
    private int colID;
    private String colName;
    private char colCategory;

    public Collector(int colID, String colName, char colCategory)
    {
        this.colID = colID;
        this.colName = colName;
        this.colCategory = colCategory;
    }

    public String toString() //Prints out all info about the collector
    {
       String summary = "{" + colID + ", " + colName + ", " + colCategory + "}";
       return summary;
    }

}
