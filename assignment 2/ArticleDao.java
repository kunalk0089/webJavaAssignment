package com.museum.entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.museum.utils.JdbcUtils;

public class ArticleDao implements JdbcDao<Article,Integer>
{
	
	private Connection con;
	private String query;
	private PreparedStatement pstm;
	private Statement stm;
	
	
	
	public ArticleDao() throws SQLException
	{
		con=JdbcUtils.getDbConnection();
	}
	
	@Override
	public Boolean save(Article article) throws SQLException {
		query="insert into article values(?,?,?,?,?);";
		pstm=con.prepareStatement(query);
		pstm.setInt(1, 0);
		pstm.setString(2, article.getName());
		pstm.setString(3, article.getCategory().toString());
		pstm.setDate(4, Date.valueOf(article.getCreateDate()));
		pstm.setString(5, article.getCreatorName());
		int count=pstm.executeUpdate();
		if(count > 0) {
			System.out.println(count +"Row Inserted!!!");
			return true;
		}else
		return false;
	}

	@Override
	public Collection<Article> findAll() throws SQLException {
		List<Article> articles=new ArrayList<Article>();
		query="select * from article;";
		stm=con.createStatement();
		ResultSet rs= stm.executeQuery(query);
		while(rs.next()) {
			Article article=new Article(rs.getInt("id"),
					rs.getString("name") ,
					Category.valueOf(rs.getString("category")), 
					rs.getDate("date_created").toLocalDate(),
					rs.getString("creator_name"));
			articles.add(article);
		}
		
		return articles;
	}

	@Override
	public Article findById(Integer key) throws SQLException {
		Article foundarticle=null;
		query="select * from article where id=?";
		pstm=con.prepareStatement(query);
		pstm.setInt(1, key);
		ResultSet rs=pstm.executeQuery();
		while(rs.next())
		{
			 foundarticle=new Article(rs.getInt("id"),
					rs.getString("name") ,
					Category.valueOf(rs.getString("category")), 
					rs.getDate("date_created").toLocalDate(),
					rs.getString("creator_name"));
		}
		return foundarticle;
	}
	@Override
	public Boolean delete(Integer id) throws SQLException {
		query = "delete from aricle where id = ?";
		pstm = con.prepareStatement(query);
		pstm.setInt(1, id);

		int count = pstm.executeUpdate();

		if (count > 0) {
			System.out.println(count + " rows affected!");
			return true;
		}
		return false;
	}

	@Override
	public Boolean update(Article article) throws SQLException {
		query = "update aricle set name = ?, category = ?,date_created  = ?,creator_name = ? where  id  = ?";
		pstm = con.prepareStatement(query);
		pstm.setString(1, article.getName());
		pstm.setString(2, article.getCategory().toString());
		pstm.setDate(3, Date.valueOf(article.getCreateDate()));
		pstm.setString(4, article.getCreatorName());
		pstm.setInt(5, article.getId());
		int count = pstm.executeUpdate();

		if (count > 0) {
			System.out.println(count + " rows affected!");
			return true;
		}
		return false;
	}


}
