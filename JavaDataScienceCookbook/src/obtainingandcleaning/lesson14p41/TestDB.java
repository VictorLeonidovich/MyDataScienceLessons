package obtainingandcleaning.lesson14p41;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.MysqlDataSource;

public class TestDB {
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	private static final String SERVER_NAME = "localhost";
	private static final String URL = "jdbc:mysql://localhost:3306/mydbdatascience?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";


	public static void main(String[] args) {
		TestDB test = new TestDB();
		test.readTable(USER_NAME, PASSWORD, SERVER_NAME);
	}

	private void readTable(String userName, String password, String serverName) {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUser(userName);
		dataSource.setPassword(password);
		dataSource.setServerName(serverName);
		dataSource.setURL(URL);
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM mydbdatascience.books");
			while (rs.next()) {
				int id = rs.getInt("id");
				String book = rs.getString("book_name");
				String author = rs.getString("author_name");
				Date dateCreated = rs.getDate("date_created");
				System.out.format("%s, %s, %s, %s\n", id, book, author, dateCreated);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("SQLException");
			e.printStackTrace();
		}

	}

}
