package com.dao;

import org.springframework.transaction.annotation.Transactional;

import com.model.Payment;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

	@Repository("paymentDAO")
	public class PaymentDAO 
	{
		@Autowired
		SessionFactory sessionFactory;
		
		
		public PaymentDAO(SessionFactory sesionFactory)
		{
			this.sessionFactory=sessionFactory;
		}
		
		@Transactional
		public void insertPaymentDetails(Payment payment)
		{
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(payment);
			session.flush();
			
		}
		
		@Transactional
		public Payment getPayment(int paymentid)
		{
			Session session=sessionFactory.openSession();
			Payment payment=(Payment)session.get(Payment.class,paymentid);
			session.close();
			return payment;
        }

}