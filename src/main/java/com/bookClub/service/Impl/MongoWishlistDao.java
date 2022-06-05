package com.bookClub.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.bookClub.model.WishlistItem;
import com.bookClub.service.dao.WishlistDao;



@Repository("WishlistDao")
public class MongoWishlistDao implements WishlistDao{
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void add(WishlistItem entity) {
		mongoTemplate.save(entity);		
	}

	@Override
	public void update(WishlistItem entity) {
		WishlistItem wl=mongoTemplate.findById(entity.getId(),WishlistItem.class);
		
		if(wl !=null) {
			wl.setId(entity.getId());
			wl.setIsbn(entity.getIsbn());
			wl.setTitle(entity.getTitle());			
		}
		mongoTemplate.save(wl);
	}

	@Override
	public boolean remove(String key) {
		
		Query  query=new Query();
		query.addCriteria(Criteria.where("id").is(key));
		
		mongoTemplate.remove(query,WishlistItem.class);
		
		return false;
	}

	@Override
	public List<WishlistItem> list() {
		return mongoTemplate.findAll(WishlistItem.class);
	}

	@Override
	public WishlistItem find(String key) {
		return mongoTemplate.findById(key, WishlistItem.class);
	}

}
