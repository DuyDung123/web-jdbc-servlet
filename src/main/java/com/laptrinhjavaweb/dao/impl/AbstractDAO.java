package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.laptrinhjavaweb.dao.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T>{
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
	
	public Connection getConnection() {
		try {
			/*
			 * //load driver mysql "chung ta truyen ten driver vao" error tra ve ClassNotFoundException conn duoc eror 2 tra ve SQLException
			 * Class.forName("com.mysql.jdbc.Driver"); String
			 * url="jdbc:mysql://localhost:3306/newservletjdbc"; String user="root"; String
			 * passWord="123456";
			 */
			
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String passWord = resourceBundle.getString("password");
			return DriverManager.getConnection(url, user, passWord); //khi mà load được nó sẽ trả về một chuỗi kết nối
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}

	@Override
	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		
		List<T> resutls = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement =null;
		ResultSet resultSet = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql); //chỗ này mới chuyền câu query vào thôi
			setParameter(statement, parameters); // chỗ này chuyền tham số vào cho câu query
			resultSet = statement.executeQuery(); //chỗ này nó mới chạy query nè sau đó nó chạy trả về cho ta một bảng dùng loop để lấy dl bang đó
			while (resultSet.next()) {
				resutls.add(rowMapper.mapRow(resultSet));
			}
			return resutls;
		} catch (SQLException e) {
			return null;
		}finally { //dù try có đang chay hay thế nào đi nữa thì chạy song rồi cái finally này mới được nhảy vào cuối cùng
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if(parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if(parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				} else if(parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				}
			}
		} catch (SQLException e) {
			e.fillInStackTrace();
		}
	}
	
/*	else if(parameter == null) {
		statement.setNull(index, Types.NULL); // chỗ nào bỏ trống nó sẽ cho là null
	}
*/
	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (SQLException e) {
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.fillInStackTrace();
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		try {
			Long id = null;
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys(); // no sẽ lấy ra được id vì id mình để nó tự tăng mà dùng cái này phải có Statement.RETURN_GENERATED_KEYS
			if(resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (SQLException e) {
			if(connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.fillInStackTrace();
			}
		}
		return null;
	}

	@Override
	public int count(String sql, Object... parameters) {
		
		Connection connection = null;
		PreparedStatement statement =null;
		ResultSet resultSet = null;
		try {
			int count = 0;
			connection = getConnection();
			statement = connection.prepareStatement(sql); //chỗ này mới chuyền câu query vào thôi
			setParameter(statement, parameters); // chỗ này chuyền tham số vào cho câu query
			resultSet = statement.executeQuery(); //chỗ này nó mới chạy query nè sau đó nó chạy trả về cho ta một bảng dùng loop để lấy dl bang đó
			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			return 0;
		}finally { //dù try có đang chay hay thế nào đi nữa thì chạy song rồi cái finally này mới được nhảy vào cuối cùng
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return 0;
			}
		}
	}
}
