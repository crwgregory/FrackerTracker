package entityTests;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.User;

public class UserTests {
	
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	
	@Before
	public void setUp(){
		emf = Persistence.createEntityManagerFactory("FrackerTracker");
		em = emf.createEntityManager();
	}
	
	@After
	public void tearDown() throws Exception{
		em.close();
		emf.close();
	}
	
	@Test
	public void willPass(){
		boolean willPass = true;
		assertEquals(willPass, true);
	}

	@Test
	public void getUsername(){
		User u = em.find(User.class, 1);
		assertEquals("bobDobbs", u.getUsername());
	}
}
