package com.hibernate.HibernateOneToOneMapping;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.hibernate.Dao.DaoClass;
import com.hibernate.model.Passport;
import com.hibernate.model.Person;
public class App 
{
	public static void main(String args[])
	{
		SessionFactory factory = DaoClass.getFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Passport passport = new Passport();
		passport.setNumber("123");

		Person person = new Person();
		person.setName("abc");
		person.setPassport(passport);

		session.save(passport);
		int personId = (Integer)session.save(person);

		tx.commit();        
		session.close();

		DaoClass.getPersonDetails(personId);        
		factory.close();        
	}
}
