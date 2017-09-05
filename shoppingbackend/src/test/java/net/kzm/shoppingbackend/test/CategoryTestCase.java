package net.kzm.shoppingbackend.test;

import static org.junit.Assert.assertEquals;
import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {
private static AnnotationConfigApplicationContext context;

private static CategoryDAO categoryDAO;

private Category category;
@BeforeClass
public static void init(){
	
	context=new AnnotationConfigApplicationContext();
	context.scan("net.kzm.shoppingbackend");
	context.refresh();
	
	categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	
}

/*
public void testAddCategory(){
	category=new Category();
	category.setName("Laptop");
	category.setDescription("this description is for Laptop");
	category.setImageURL("CAT_1.png");
	assertEquals("successfully  added a category inside the label",true,categoryDAO.add(category));
}*/
/*@Test
public void updateCatgory(){
	category=categoryDAO.get(4);
	
	assertEquals("successfully  update category into  database",true,categoryDAO.update(category));
	
}
*/

/*public void deleteCategory(){
	
category=categoryDAO.get(4);
	
	assertEquals("successfully deleted",true,categoryDAO.delete(category));
}*/
@Test
public void fetchRecords(){
	
	assertEquals("successfully fetched complete record",3,categoryDAO.list().size());
	
} 

}
