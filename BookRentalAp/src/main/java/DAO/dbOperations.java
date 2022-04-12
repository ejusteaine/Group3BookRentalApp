package DAO;

import Models.Book;
import Models.Category;

import javax.xml.transform.Result;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class dbOperations {
//    public boolean addCategories(Category category){
//        boolean result =  true;
//        String insertCat = "insert into bookrentalapp.categories (categoryName) values(?)";
//        try{
//            PreparedStatement ps = DBConnection.dbConnected().prepareStatement(insertCat);
//            ps.setString(1,category.getCategory());
//            result = ps.executeUpdate() > 0;
//            return result;
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }
    // Add book to database

    public boolean addBooks(Book book){
        boolean result = true;
        String insertBook = "insert into bookrentalapp.books (title, authorId, categoryId, releaseYear) values(?,?,?,?)";
        try{
            PreparedStatement ps = DBConnection.dbConnected().prepareStatement(insertBook);
            ps.setString(1, book.getTitle());
            ps.setInt(2, book.getAuthorId());
            ps.setInt(3, book.getCategoryId());
            ps.setString(4, book.getReleaseYear());result = ps.executeUpdate() > 0;
            return result;

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void viewBookByName(String title){
        String selectBook = "select books.bookId, books.title, authors.firstName, authors.lastName, categories.categoryName, books.releaseYear from bookrentalapp.books  join bookrentalapp.authors on books.authorId = authors.authorId join bookrentalapp.categories on books.categoryId = categories.categoryId where books.title = ?";
        try{
          PreparedStatement ps = DBConnection.dbConnected().prepareStatement(selectBook);
       ps.setString(1, title);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int bookId = rs.getInt("bookId");
                String bktitle = rs.getString("title");
                String bkauthor = rs.getString("firstName");
                String bklast = rs.getString("lastName");
             String bkcat = rs.getString("categoryName");
                String publishYear = rs.getString("releaseYear");
                System.out.println("Book ID: " + bookId + "\nTitle: " + bktitle + "\nAuthor: " + bkauthor + "\t" + bklast + "\nCategory: " + bkcat + "\nRelease Year: " + publishYear);
            }else{
                System.out.println("Oh snap no data found\nCheck your spelling and try again");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public boolean DeleteBookById(int bookId){
        boolean result = true;
      String deleteBook = "delete from bookrentalapp.books where books.bookId = ?";
      try{
          PreparedStatement ps = DBConnection.dbConnected().prepareStatement(deleteBook);
          ps.setInt(1,bookId);
          if(result = ps.executeUpdate() > 0) {
              System.out.println("Book ID " + bookId + " was successfuly removed");
          }else{
              System.out.println("Oh snap book was not found");
          }
      }catch(Exception e){
          System.out.println(e.getMessage());
          return false;
      }
      return result;
    }

    public void checkBookStatus(String title){
     String bookStatus = "select rentals.checkInDate, rentals.checkOutDate from bookrentalapp.rentals where bookId = ?";
     try{
        PreparedStatement ps = DBConnection.dbConnected().prepareStatement(bookStatus);
        ps.setString(1, title);
         ResultSet rs = ps.executeQuery();
         if(rs.next()){
            Date date1  = rs.getDate("checkInDate");
             Date date2 = rs.getDate("checkOutDate");
           long diff = DAYS.between(date1.toLocalDate(), date2.toLocalDate());
             System.out.println("This rental is "+diff+" days old");
         }else{
             System.out.println("This book is Availble ");
         }
     }catch(Exception e){
         System.out.println(e.getMessage());
     }
    }

    public boolean updateStatus(int bkId, String bookStatus){
        boolean result = true;
        String updateStatus = "update bookrentalapp.books set books.bookStatus = ? where books.bookId = ?";
        try {
            PreparedStatement ps = DBConnection.dbConnected().prepareStatement(updateStatus);
            ps.setInt(1, bkId);
            ps.setString(2, bookStatus);
            result = ps.executeUpdate() > 0;
        }catch(Exception e){
            System.out.println(e.getMessage());
            result = false;
        }
        return result;
    }
}
