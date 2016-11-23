package ar.edu.unju.fi.soo.dao.impl;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.soo.model.dao.PlanDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
@Transactional
public class PlanDAOImplTestCase {
	 @Inject
	 private PlanDAO planDAO;
	 
	 @Test
	 public void testPlayNextFee(){
		 
	 }
	 

}
