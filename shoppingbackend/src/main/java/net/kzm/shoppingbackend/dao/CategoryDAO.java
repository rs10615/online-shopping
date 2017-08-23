package net.kzm.shoppingbackend.dao;

import java.util.List;

import net.kzm.shoppingbackend.dto.Category;


public interface CategoryDAO {
 Category get(int id);
	List<Category> list();
}
