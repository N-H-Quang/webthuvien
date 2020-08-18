/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AbstractDAO<T> implements GenericDao<T> {
	public Connection getConnection() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=LibraryWeb";
		String userName = "root";
		String password = "root";
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			System.out.println("loi sql");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("loi class");
		}
		return connection;
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowmapper, Object... parameters) {
		List<T> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement stament = null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			stament = (PreparedStatement) connection.prepareStatement(sql);
			if (parameters != null)
				Setparemeter(stament, parameters);
			resultSet = stament.executeQuery();
			while (resultSet.next()) {
				result.add(rowmapper.Maprow(resultSet));
			}
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if (stament != null)
					stament.close();
				if (resultSet != null)
					resultSet.close();
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}

		return result;
	}

	private void Setparemeter(PreparedStatement stament, Object... parameters) {
		try {
			int index = 0;
			for (Object object : parameters) {
				index += 1;
				if (object instanceof Integer) {
					stament.setInt(index, (Integer) object);
				} else if (object instanceof String) {
					stament.setString(index, (String) object);
				} else if (object instanceof Long) {
					stament.setLong(index, (Long) object);
				} else if (object instanceof Timestamp) {
					stament.setTimestamp(index, (Timestamp) object);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = (PreparedStatement) connection.prepareStatement(sql);
			Setparemeter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public int insert(String sql, Object... parameters) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = (PreparedStatement) connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			Setparemeter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			connection.commit();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			} else {
				return 0;
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return 0;
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (resultSet != null)
					resultSet.close();
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public boolean checkdublicade(String sql, Object... parameters) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			if (parameters != null)
				Setparemeter(statement, parameters);
			resultSet = statement.executeQuery();
			if (resultSet.next()==false) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			return false;
		} finally {
			try {

				if (statement != null)
					statement.close();
				if (resultSet != null)
					resultSet.close();
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
