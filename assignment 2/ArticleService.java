package com.museum.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

import com.museum.Exception.ResourceAlreadyExistException;
import com.museum.Exception.ResourceNotFoundArticleException;
import com.museum.entity.Article;
import com.museum.entity.ArticleDao;
import com.museum.entity.Category;

public class ArticleService {
	private ArticleDao articleDao;
	

	public ArticleService() throws SQLException{
		articleDao =new ArticleDao();
		
	}
	public void addArticle(String name,Category category,LocalDate createDate,String createName) throws SQLException 
	{
		Optional<Article> existingArticle =articleDao.findAll().stream()	
				.filter(article-> article.getName().equalsIgnoreCase(name)).findFirst();
		
		if(existingArticle.isEmpty()) {
		Article newArticle=new Article(null,name,category,createDate,createName);
		boolean status= articleDao.save(newArticle);
		if(status)
			System.out.println("Article added successfully!!!");
		else
			System.out.println("Article Failed to add!!!");
		}else
			throw new ResourceAlreadyExistException("Article Already Exist with same name"+name);
		
	}


public void displayAllArticles() throws SQLException{
		articleDao.findAll().stream().forEach(article-> System.out.println(article));
		
}
public void displayArticleDetails(Integer id) throws SQLException{
	Article foundArticle=articleDao.findById(id);
	if(foundArticle != null)
	{
		System.out.println(foundArticle);
	}else
		throw new ResourceNotFoundArticleException("Article not Found Of ID:"+id);
}		


public void deleteArticle(int id) throws SQLException {
	Boolean status = articleDao.delete(id);
	if (status)
		System.out.println("Article deleted Sucessfully!!");
	else
		System.out.println("Article failed to delete!!");
	
}

public void updateArticle(int id, String name, Category category, LocalDate createdDate, String creatorName) throws SQLException,ResourceNotFoundArticleException

{
	Article art = articleDao.findById(id);
	if (art != null) {
	Boolean status = articleDao.update(new Article(id, name, category, createdDate, creatorName));
	if (status)
		System.out.println("Article deleted Sucessfully!!");
	else
		System.out.println("Article failed to delete!!");
	}
	else
		throw new ResourceNotFoundArticleException("Article not found with id " + id);

	
}

}

