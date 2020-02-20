package com.shopstack.dao.customer;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.shopstack.entities.customer.Customer;

/**
 * @author adefunmi
 *
 */


import com.shopstack.entities.customer.Customer;
	
@Repository
public class CustomerDaoImpl implements CustomerDao {
	

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(CustomerDao.class);
	

	@Transactional
	@Override
	public void addCustomer(Customer customerId) {
	
	
		Session currentSession = sessionFactory.getCurrentSession();
		logger.info("Saving Customer to database " + customerId.toString());
		
		currentSession.save(customerId);
		 
		
		}


	@Transactional
	@Override
	public Customer findById(int customerId) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Customer.class, customerId);
	}
	

	

}
