/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationswing.Util;

import java.util.List;
import javaapplicationswing.Model.Book;
import javaapplicationswing.Model.Sage;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;

/**
 *
 * @author lv270669zia
 */
public class ViewControler {
    public static JList getList(){
        try{
        Repository repository = new Repository();
        
        final DefaultListModel bookDLM = repository.getAllBook();
        final JList booksJList = new JList((ListModel) bookDLM);

        booksJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                return booksJList;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    public static void setNewSageBook(String bookName, String description, String sageName, String city, String age) {
        try {
        Repository repository = new Repository();
        Integer bookId = repository.addBook(bookName, description);
        Integer sageId = repository.addSage(sageName, city, age);
        repository.addSageBook(sageId, bookId);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static String getSageName(String bookName)
    {
        try {
        Repository repository = new Repository();
        
        Sage sage = repository.getSageOfBook(bookName);
        return sage.getName();
    }
    catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    public static String getBookDescription(String bookName)
    {
        try {
        Repository repository = new Repository();
        Book book = repository.getBookByName(bookName);
        return book.getDescription();
    }
    catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void deleteBook(String bookName)
    {
        try {
        Repository repository = new Repository();
        Book book = repository.getBookByName(bookName);
        repository.deleteBook(book.getId());
    }
    catch (Exception ex){
            ex.printStackTrace();           
        }
    }
}
