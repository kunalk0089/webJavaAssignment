package com.airline.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.airline.entiry.Booking;
import com.airline.services.BookingService;

/**
 * Servlet implementation class BookFlightServlet
 */
@WebServlet("/bookFlight")
public class BookFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookFlightServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Object id = session.getAttribute("userId");
		int userId = (int) id;
		int flightId = Integer.parseInt(request.getParameter("flightId"));
		BookingService s=new BookingService();
		boolean isBooked = new BookingService().bookingFlights(userId, flightId);
		if (isBooked) {
			List<Booking> books = s.ShowBooking(userId);
		request.setAttribute("bookings", books);
		request.getRequestDispatcher("mybooking.jsp").forward(request, response);
		out.println("<h2 style='color:green'>Flight Is Booked Successfully</h2>");
//		response.sendRedirect("mybooking.jsp");

			out.println("<h2 style='color:green'>Flight Booked Successfully!!!</h2>");
		} else {
			out.println("<h2 style='color:red'>Failed To Book Flight!!!</h2>");
		}

	}

}
