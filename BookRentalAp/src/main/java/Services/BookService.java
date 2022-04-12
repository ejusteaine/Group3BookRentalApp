package Services;
import java.util.Scanner;

import DAO.dbOperations;
import Models.Book;

import java.util.Scanner;

public class BookService {
    Book books;
    dbOperations dbOp;

    public BookService(){
        this.books = books;
    }

    public void addBook(Scanner sc){

        sc = new Scanner(System.in);
        books = new Book();
        dbOp = new dbOperations();

        System.out.println("Enter release Year");
        String releaseYear = sc.nextLine();
        System.out.println("Enter Book Title ");
        String bkTitle = sc.nextLine();
        System.out.println("Enter Author Id ");
        int bkAuthor = sc.nextInt();
        System.out.println("Enter Category Id ");
        int bkcategory = sc.nextInt();

        books.setTitle(bkTitle);
        books.setAuthorId(bkAuthor);
        books.setCategoryId(bkcategory);
        books.setReleaseYear(releaseYear);
        boolean result = dbOp.addBooks(books);
        System.out.println(" You added "+bkTitle+ " to the database");
    }


    public void viewBook(Scanner sc){
        dbOp = new dbOperations();
        System.out.println("Enter Book Title ");
        String bkTitle = sc.nextLine();
     dbOp.viewBookByName(bkTitle);
        System.out.println();
    }

    public void removeBookById(Scanner sc){
        dbOp = new dbOperations();
        System.out.println("Enter Book ID:");
        int id = sc.nextInt();
        dbOp.DeleteBookById(id);
        System.out.println();
    }

    public void BookStatus(Scanner sc){
        dbOp = new dbOperations();
        System.out.println("Enter Book Name:");
        String bktitle = sc.nextLine();
        dbOp.checkBookStatus(bktitle);
        System.out.println();
    }

    public void changeStatus(Scanner sc){
        dbOp = new dbOperations();
        System.out.println("Enter Book ID");
        int bkId = sc.nextInt();
        System.out.println("Enter Book Status eg: Rented or Available");
        String bkstats = sc.nextLine();
        dbOp.updateStatus(bkId,bkstats);
    }
}
