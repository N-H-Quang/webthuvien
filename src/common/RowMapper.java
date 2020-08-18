/*
day la code cua nguyen huu quang
jdk version :8.0
*/
package common;

import java.sql.ResultSet;

public interface RowMapper<T> {
T Maprow(ResultSet rs);
}
