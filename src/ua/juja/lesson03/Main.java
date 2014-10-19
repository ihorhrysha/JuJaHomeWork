package ua.juja.lesson03;

/**
 * Created by Ігор on 12.10.2014.
 */
public class Main {
    public static void main(String[] args) {
        Issue is = new Book("name",12,"gogoog");
        System.out.println(is.toPrint());
    }
}

class Issue {
    private String name;
    private int countPages;

    public Issue(String name, int countPages) {
        this.name = name;
        this.countPages = countPages;
    }

    public String toPrint() {
        return "Issue{" +
                "name=" + name +
                ",countPages=" + countPages +
                "}";
    }

    public int getCountPages() {
        return countPages;
    }

    public String getName(){
        return name;
    }

}

class Journal extends Issue {
    private String yearJournal;
    private String numberJournal;

    public Journal(String nameJournal, int countPages, String yearJournal, String numberJournal) {
        super(nameJournal, countPages);
        this.yearJournal = yearJournal;
        this.numberJournal = numberJournal;
    }

    @Override
    public String toPrint() {
        return "Journal{" +
                "name=" + getName() +
                ",countPages=" + getCountPages() +
                ",year=" + yearJournal +
                ",number=" + numberJournal +
                "}";
    }
}

class Book extends Issue {

    private String authorBook;

    public Book(String name, int countPages, String authorBook) {
        super(name, countPages);
        this.authorBook = authorBook;
    }

    @Override
    public String toPrint() {
        return "Book{" +
                "name=" + getName() +
                ",countPages=" + getCountPages() +
                ",author=" + authorBook +
                "}";
    }
}

class Library {

    public String printCatalog(Issue[] catalog) {
        String returnInfo="";

        for (Issue item : catalog) {
            returnInfo+=item.toPrint();
        }

        return returnInfo;
    }

    public String getIssueWithCountPagesMoreN(Issue[] catalog, int barrierCountPages) {

        String returnInfo="";

        for (Issue item : catalog)
            if (item.getCountPages()>barrierCountPages)
                returnInfo+=item.toPrint();

        return returnInfo;

    }
}