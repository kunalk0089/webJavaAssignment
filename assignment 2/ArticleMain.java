package com.museum;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import com.museum.Exception.ResourceAlreadyExistException;
import com.museum.entity.Category;
import com.museum.service.ArticleService;

public class ArticleMain {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		ArticleService service=null;
		try {
			 service=new ArticleService();
		} catch (SQLException e) {
			System.err.println();
		}
		boolean exit= true;
		while(exit)
		{
			System.out.println("==========Menu==============="
					+ "\n1.Add Article."
					+ "\n2.Display All Article."
					+ "\n3.Display Details Of Article."
					+"\n4.to delete article by id"
					+"\n5.to update article by id"
					+ "\n0.Exit");
			int ch=sc.nextInt();
			switch (ch) {
			case 1: {
				try {
					System.out.println("Enter article name,category(PAINTING,SCULPTURE,ARTIFACT),created date,creator name:");
					String name=sc.next();
					Category category=Category.valueOf(sc.next());
					LocalDate date= LocalDate.parse(sc.next());
					String creatorName=sc.next();
					service.addArticle(name, category, date, creatorName);
				} catch (SQLException | ResourceAlreadyExistException e) {
					System.err.println(e.getMessage());
				}
				
				break;
			}case 2: {
				try {
					service.displayAllArticles();
				} catch (SQLException | ResourceAlreadyExistException e) {
					System.err.println(e.getMessage());
				}
				
				break;
			}case 3: {
				try {
					System.out.println("Enter Article ID: ");
					service.displayArticleDetails(sc.nextInt());
				} catch (SQLException | ResourceAlreadyExistException e) {
					System.err.println(e.getMessage());
				}
			}
			case 4: 
			{
				System.out.println("enter id");
				try {
					service.deleteArticle(sc.nextInt());
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				break;
			}
			case 5:
			{
				System.out.println("enter id, name, category(PAINTING,SCULPTURE, ARTIFACT),date, creator name");
				try {
					service.updateArticle(sc.nextInt(), sc.next(), Category.valueOf(sc.next()), LocalDate.parse(sc.next()), sc.next());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
				
				
			case 0: {
				exit=false;
				System.out.println("Thank You");
				
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}
		}

	}

}
