package TestBook;

import DAO.dbOperations;
import Models.Category;
import Services.BookService;
import Services.CustomerService;
import Services.categoryService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      Scanner input = new Scanner(System.in);

        BookService bkService = new BookService();
        CustomerService cService = new CustomerService();

      int choice;
        try {
            do {
                System.out.println("----------Book Rental App-------------");
                System.out.println(
                        "1 Add a Book\n" +
                                "2 View Book By Name\n" +
                                "3 Remove a Book By BookId\n" +
                                "4 Update Book's Status\n" +
                                "5 Add a Customer\n" +
                                "6 Remove a Customer By Id\n" +
                                "7 Update Customer's Name\n" +
                                "8 View existing Customer\n" +
                                "9 Rental Status\n"
                );
                System.out.println();
                System.out.println("Make a Selection: ");

                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        bkService.addBook(sc);
                        break;
                    case 2:
                        bkService.viewBook(sc);
                        break;
                    case 3:
                        bkService.removeBookById(sc);
                        break;
                    case 4:
                        bkService.BookStatus(sc);
                        ;
                        break;
                    case 5:
                        cService.addCustomer(sc);
                        break;
                    case 6:
                    	cService.removeCustomerById(sc);
                    	break;
                }
            }
            while (choice != 4) ;
        }catch(InputMismatchException ex){
            System.out.println("Invalid input, You should enter a number from 1 - 5");
        }

    }
}
