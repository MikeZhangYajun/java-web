package dal;

import java.util.List;
import entity.Author;
import java.util.HashMap;

public class AuthorDALImp extends GenericDAL<Author>{

    public AuthorDALImp() {
        super( Author.class);
    }

    public List<Author> findAll(){
        return findResults("Author.findAll", null);
    }

    public Author findByAuthorID( int authorID){
        HashMap<String, Object> map = new HashMap<>();
        map.put("authorID", authorID);
        return findResult("Author.findByAuthorID", map);
    }

    public List<Author> findByFirstName( String firstName){
        HashMap<String, Object> map = new HashMap<>();
        map.put("firstName", firstName);
        return findResults("Author.findByFirstName", map);
    }

    public List<Author> findByLastName( String lasttName){
        HashMap<String, Object> map = new HashMap<>();
        map.put("lasttName", lasttName);
        return findResults("Author.findByLastName", map);
    }
}
