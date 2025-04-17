package practice;

import java.util.Collection;

public interface StudentJdbcDao<T,K> {
	Collection<T> getAll();
	T getOne(K key);
	 void add (T t);
	 void update (T t);
	 void delete( K key);

}
