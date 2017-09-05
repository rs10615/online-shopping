package net.kzn.shoppingbackend.daoimpl;

import java.util.List;




import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;



import org.hibernate.Query;
//import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Category> list() {
		

	String selectActiveResult="FROM Category WHERE active=:a";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveResult);
query.setParameter("a", true);

return query.list();
	}


	@Override
	public Category get(int id) {
	return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	
	}

	@Override
	public boolean add(Category category) {
		try{
			
			//add the category to the database table
		sessionFactory.getCurrentSession().persist(category);
			
			return true;
		}catch(Exception e){
		
		return false;
		}
		
	}


@Override
public boolean update(Category category) {
	
	try{
		
		//add the category to the database table
	sessionFactory.getCurrentSession().update(category);
		
		return true;
	}catch(Exception e){
	
	return false;
	}
}


@Override
public boolean delete(Category category) {
	
	category.setActive(false);
	try{
		
		//add the category to the database table
	sessionFactory.getCurrentSession().update(category);
		
		return true;
	}catch(Exception e){
	
	return false;
	}
}

}
