package com.exam1.util;

public interface SQLUitl {
	// customer表
	final String CUSTOMER_LOGIN = "select * from customer where first_name = ?";

	// film表
	final String FILM_SELECT_PAGE = "select f.*,l.name as language_name from film f,language l where f.language_id = l.language_id limit ? , ?";
	final String FILM_INSERT = "insert into film(title,description,language_id) values(?,?,?)";
	final String FILM_DELETE = "delete from film where film_id = ?";
	final String FILM_UPDATE = "update film set title = ? , description = ? , language_id = ? where film_id = ?";
	final String FILM_COUNT = "select count(*) from film";

	// language表
	final String LANGUAGE_SELET_ALL = "select * from language";
	
	//删除表film的记录 关联表
	final String DELETE_FILM_ACTOR = "delete from film_actor where film_id = ? ";
	final String DELETE_FILM_CATEGORY ="delete from film_category where film_id = ?";
	final String DELETE_FILM_TEXT = "delete from film_text where film_id = ?";
	final String DELETE_INVENTORY ="delete from inventory where film_id = ?";
	final String DELETE_SELECT_INVENTORY = "select inventory_id from inventory where film_id = ?";
	final String DELETE_SELECT_RENTAL = "select rental_id from rental where inventory_id = ?";
	final String DELETE_RENTAL = "delete from rental where inventory_id in(?)";
	
}
