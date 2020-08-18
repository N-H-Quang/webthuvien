/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package common;

import java.util.List;
public interface GenericDao <T>{
	<T>List<T> query(String sql,RowMapper<T> rowmapper, Object... parameters);  
	void update (String sql,Object... parameters);
	int insert (String sql,Object... parameters);
	boolean checkdublicade(String sql,Object... parameters);
}
