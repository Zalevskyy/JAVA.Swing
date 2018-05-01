/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationswing.Util;

import java.util.ArrayList;
import java.util.List;
import javaapplicationswing.Model.Book;
import javaapplicationswing.Model.Sage;
import javaapplicationswing.Model.Sagebooks;
import javax.swing.DefaultListModel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.sql.*;
import org.hibernate.Query;

/**
 *
 * @author lv270669zia
 */
public class Repository {
    Session session = null;//HibernateSFactory.getSessionFactory().openSession();
    Transaction transaction = null;
    Integer bookID = null;
    Integer sageID = null;
    
    public Integer addBook(String name, String description){  
      try {
         session = HibernateSFactory.getSessionFactory().openSession();
         transaction = session.beginTransaction();
         Book book = new Book(name, description);
         bookID = (Integer) session.save(book); 
         transaction.commit();
      } catch (HibernateException e) {
         if (transaction!=null) transaction.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return bookID;
    }
    public Integer addSage(String sage, String city, String age){
        try {
         session = HibernateSFactory.getSessionFactory().openSession();
         transaction = session.beginTransaction();
         Sage sageForBook = new Sage(sage, city, age);
         sageID = (Integer) session.save(sageForBook); 
         transaction.commit();
      } catch (HibernateException e) {
         if (transaction!=null) transaction.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
        return sageID;
    }
    
    public void addSageBook(int sageId, int bookId){
        try {
         session = HibernateSFactory.getSessionFactory().openSession();
         transaction = session.beginTransaction();
         Sagebooks sageBook = new Sagebooks(sageId, bookId);
         session.save(sageBook); 
         transaction.commit();
      } catch (HibernateException e) {
         if (transaction!=null) transaction.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
    }
    
    public DefaultListModel getAllBook(){
             
        DefaultListModel books=new DefaultListModel();
        try {
            session = HibernateSFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String queryString = "from Book";
        List <Book> bookList = (List <Book>) session.createQuery(queryString).list();
        bookList.forEach(books::addElement);
        }
        catch (HibernateException e) {
         if (transaction!=null) transaction.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
        return books;
    }
    
    public Book getBook(int id){
        Book book=null;
        try {
            session = HibernateSFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String queryString = "from Book where id = :id";
         book = (Book)session.createQuery(queryString);
        }
        catch (HibernateException e) {
         if (transaction!=null) transaction.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
        return book;
    }
    
    public Sage getSageOfBook(String bookName){
        Book book=null;
        Sage sage=null;
        try {
            session = HibernateSFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String queryString = "from Book where name = :name";
             Query query = session.createQuery(queryString);
             query.setParameter("name", bookName);
             List<Book> list = query.list();
         book = list.get(0);
         int id = book.getId();
         
          Query querySagebook = session.createQuery("from Sagebooks where idBook = :id");
          querySagebook.setParameter("id", id);
         List<Sagebooks> listsagebook = querySagebook.list();
         Sagebooks sagebook  = listsagebook.get(0);
         id = sagebook.getIdSage();
         Query querySage = session.createQuery("from Sage where id = :id");
         querySage.setParameter("id", id);
         List<Sage> listsage = querySage.list();
         sage = listsage.get(0);
        }
        catch (HibernateException e) {
         if (transaction!=null) transaction.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
        return sage;
    }
    
    public Book getBookByName(String bookName){
        Book book=null;
        try {
            session = HibernateSFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String queryString = "from Book where name = :bookName";
         
         Query query = session.createQuery(queryString);
         query.setParameter("bookName", bookName);
         List<Book> listbook = query.list();
         book = listbook.get(0);
        }
        catch (HibernateException e) {
         if (transaction!=null) transaction.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
        return book;
    }
    
    public void updateBook(int id, Book book) {       
        try {
            session = HibernateSFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            //Book book2 = (Book)session.get(Book.class, id);
                     
//            String queryString = "from Books where id = :id";
//            Query query = session.createQuery(queryString);
//            Book book1 = (Book) query.uniqueResult();
            session.update(book);
            transaction.commit();
            System.out.println("Book records updated!");
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
 
        } finally { 
            session.close();
        }
    }
    /* Method to delete an employee from the records */
   public void deleteBook(Integer id){      
      try {
          session = HibernateSFactory.getSessionFactory().openSession();
         transaction = session.beginTransaction();
         Book book = (Book)session.get(Book.class, id); 
         session.delete(book); 
         transaction.commit();
      } catch (HibernateException e) {
         if (transaction!=null) transaction.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
}
