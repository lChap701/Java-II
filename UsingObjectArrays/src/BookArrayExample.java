public class BookArrayExample {
    public static void main(String[] args){
        int[] nums = new int[3]; // defaults all data to zero

        Book[] bookArray = new Book[3];
        bookArray[0] = (new Book()); // gets default value in default constructor
        bookArray[1] = new Book("The Catcher in The Rye", "Salinger", 7.99);
        bookArray[2] = new Book("Java Programming", "Farrell", 125.00);

        for (int i = 0; i < bookArray.length && bookArray[i] != null; i++){
            System.out.println(bookArray[i].displayBook() + "\n");
        }

        // is a foreach loop
        for(Book b : bookArray){ // b would be equal to int b = 0; b < bookArray.length;
            if(b != null){ // avoids printing null values
                System.out.println(b.displayBook() + "\n");
            }
        }
    }
}
