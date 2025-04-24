/*package example.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airline.entiry.User;
import com.airline.utils.JdbcUtils;

public class UserDao {
	private String query;

	public void save(User user) {

		query = "insert into user(user_name, user_email, user_password) values(?,?,?);";
		try (Connection con = JdbcUtils.getConnection(); PreparedStatement psmt = con.prepareStatement(query)) {
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getEmail());
			psmt.setString(3, user.getPassword());

			int recordupdate = psmt.executeUpdate();
			if (recordupdate > 0) {
				System.out.println(recordupdate + " inserted");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		query = "select * form user;";
		try (Connection con = JdbcUtils.getConnection(); Statement smt = con.createStatement();) {
			ResultSet rs = smt.executeQuery(query);

			while (rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return users;
	}

	public User searchUserByEmailAndPassword(String email, String password) {
		query = "Select * from user where user_email = ? and user_password = ?";
		User foundUser = null;
		try (Connection con = JdbcUtils.getConnection(); PreparedStatement psmt = con.prepareStatement(query)) {
			psmt.setString(1, email);
			psmt.setString(2, password);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				foundUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return foundUser;
	}
}*/
package example.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airline.entiry.User;
import com.airline.utils.JdbcUtils;

public class UserDao {
	private String query;

	public void save(User user) {
		query = "INSERT INTO user(user_name, user_email, user_password) VALUES (?, ?, ?);";
		try (Connection con = JdbcUtils.getConnection(); PreparedStatement psmt = con.prepareStatement(query)) {
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getEmail());
			psmt.setString(3, user.getPassword());

			int recordUpdate = psmt.executeUpdate();
			if (recordUpdate > 0) {
				System.out.println(recordUpdate + " record(s) inserted.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		query = "SELECT * FROM user;";
		try (Connection con = JdbcUtils.getConnection(); Statement smt = con.createStatement()) {
			ResultSet rs = smt.executeQuery(query);
			while (rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public User searchUserByEmailAndPassword(String email, String password) {
		query = "SELECT * FROM user WHERE user_email = ? AND user_password = ?";
		User foundUser = null;
		try (Connection con = JdbcUtils.getConnection(); PreparedStatement psmt = con.prepareStatement(query)) {
			psmt.setString(1, email);
			psmt.setString(2, password);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				foundUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foundUser;
	}
}
