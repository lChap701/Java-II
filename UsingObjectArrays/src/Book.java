public class Book {
    private String title;
    private String author;
    private double price;

    // default constructor
    Book(){
        title = "Default Title";
        author = "Default Author";
        price = 0;
    }

    Book(String t, String a, double p){
        setTitle(t);
        setAuthor(a);
        setPrice(p);
    }

    public void setTitle(String t) {
        title = t;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public void setPrice(double p) {
        price = p;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public double getPrice(){
        return price;
    }

    // could use variables instead of getters (title instead of getTitle())
    public String displayBook(){
        return "Title: " + getTitle() + "\n" +
                "Author: " + getAuthor() + "\n" +
                "Price: " + getPrice() + "\n";
    }
}
