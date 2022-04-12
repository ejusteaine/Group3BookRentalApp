package Services;
import DAO.dbOperations;
import Models.Category;

import java.util.Scanner;

public class categoryService {
    Category categories;
    dbOperations dbOps;

    public categoryService() {
        this.categories = categories;
    }
        public void addCategories(Scanner sc){
            sc = new Scanner(System.in);
            categories = new Category();
            dbOps = new dbOperations();
            System.out.println("Enter a Category Name");
            String catname = sc.nextLine();
            categories.setCategory(catname);
            boolean result = dbOps.addCategories(categories);
            System.out.println("You added "+ catname+ " to the database");


    }
}
