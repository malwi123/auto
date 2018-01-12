package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Repository.CarRepository;
import Repository.CustomerRepository;
import Repository.RepositoryCatalog;
import Repository.TransactionRepository;
import domain.Car;
import domain.Customer;
import domain.IHaveId;
import domain.Transaction;

public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	//set connection
    	Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");

    	//set repositories
    	RepositoryCatalog rc = new RepositoryCatalog(connection);
    	CarRepository carRepo =  (CarRepository) rc.GetCarRepository();
    	CustomerRepository customerRepo =  (CustomerRepository) rc.GetCustomerRepository();
    	TransactionRepository transactionRepo =  (TransactionRepository) rc.GetTransactionRepository();
    	
    	//Operations on cars table
    	carRepo.add(new Car("Ford","Mustang","Cabrio",10000));
    	carRepo.add(new Car("Ford","Ka","1.6",1000));
    	
    	Car c1 =  new Car("Skoda1","Fabia","1.0",666);
    	c1.setId(1);
    	carRepo.update(c1);
    	
    	List<IHaveId> cars = carRepo.getAll();
    	carRepo.delete(cars.get(0));
    	
    	//Operations on customers table
    	customerRepo.add(new Customer("Adam4","Adamski4","997"));
    	customerRepo.add(new Customer("Bogdan1","Bogdanski","998"));
    	
    	Customer c2 =  new Customer("Bogdan3","Bogdanski3","999-999-999");
    	c2.setId(1);
    	customerRepo.update(c2);
    	
    	List<IHaveId> customers = customerRepo.getAll();
    	customerRepo.delete(customers.get(0));

    	//Operations on transactions table
    	transactionRepo.add(new Transaction(5,5));
    	transactionRepo.add(new Transaction(7,7));
    	
    	Transaction t1 =  new Transaction(1,2);
    	t1.setId(1);
    	transactionRepo.update(t1);

    	List<IHaveId> transactions= transactionRepo.getAll();
    	transactionRepo.delete(transactions.get(0));

        System.out.println( "Koniec" );
    }
}
