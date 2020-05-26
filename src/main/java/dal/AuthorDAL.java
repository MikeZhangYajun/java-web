package dal;

import java.util.List;

import entity.Author;

public interface AuthorDAL{

	List<Author> getAll();
	Author getWithID( int id);
	boolean add(Author a);
}
