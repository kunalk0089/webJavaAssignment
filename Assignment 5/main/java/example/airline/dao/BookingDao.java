package example.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.airline.entiry.Booking;
import com.airline.entiry.Flight;
import com.airline.services.BookingService;
import com.airline.utils.JdbcUtils;
import com.mysql.cj.protocol.Resultset;

public class BookingDao {
	String query;

	public boolean saveBooking(int uid, int fid) {
		boolean status = false;
		query = "INSERT INTO booking(user_id,flight_id) values(?,?)";
		try (Connection con = JdbcUtils.getConnection(); PreparedStatement psmt = con.prepareStatement(query);) {
			psmt.setInt(1, uid);
			psmt.setInt(2, fid);
			int count = psmt.executeUpdate();
			if (count > 0) {
				System.out.println("total update is: " + count);
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public List<Booking> findById(int uid) {
		List<Booking> bookings = new ArrayList<Booking>();

		query = "select * from booking where user_id = ?";
		try (Connection con = JdbcUtils.getConnection(); PreparedStatement psmt = con.prepareStatement(query);) {
			psmt.setInt(1, uid);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				bookings.add(new Booking(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4).toLocalDate()));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookings;
	}

	public boolean removeBooking(int fid) {
		boolean status = false;
		query = "delete from booking where flight_id=?";
		try (Connection con = JdbcUtils.getConnection(); PreparedStatement psmt = con.prepareStatement(query);) {
			psmt.setInt(1, fid);
			int count = psmt.executeUpdate();
			if (count > 0) {
				System.out.println("total deleted is: " + count);
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
