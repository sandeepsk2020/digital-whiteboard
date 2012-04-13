package de.htwg.digitalwhiteboard.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.htwg.digitalwhiteboard.users.verification.PasswordValidator;
import de.htwg.digitalwhiteboard.util.Constants;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		BufferedReader reader = request.getReader();

		String received = reader.readLine();

		String gotoPage = "error.jsp";

		if (received != null) {

			if (received.contains(Constants.ANON_LOGIN_NAME)) {

				gotoPage = "todo.jsp";

			} else if (received.contains(Constants.PRESENTER_USERNAME)
					&& received.contains(Constants.PRESENTER_PASSWORD)) {

				// parse result

				// pw and user check

				if (validateLogin()) {
					gotoPage = "presenterMainPage.jsp";
				}
			}
		}

		request.getRequestDispatcher(gotoPage).forward(request, response);
	}

	private boolean validateLogin() {

		return PasswordValidator.getOnlyInstance().validatePassword(null, null);
	}
}
