package logic;

import dal.AuthorDALImp;
import java.util.List;
import java.util.function.ObjIntConsumer;

import entity.Author;
import java.util.Arrays;
import java.util.Map;

public class AuthorLogic extends GenericLogic<Author, AuthorDALImp> {

    public static final String ID = "id";
    public static final String FN = "fn";
    public static final String LN = "ln";

    public AuthorLogic() {
        super(new AuthorDALImp());
    }

    @Override
    public List<String> getColumnNames() {
        return Arrays.asList("ID", "First Name", "Last Name");
    }

    @Override
    public List<String> getColumnCodes() {
        //First Name: <input type="text" name=Author.FN>
        return Arrays.asList(ID, FN, LN);
    }

    @Override
    public List<?> extractDataAsList(Author e) {
        return Arrays.asList(e.getAuthorID(), e.getFirstName(), e.getLastName());
    }

    @Override
    public Author createEntity( Map<String, String[]> requestData) {
        ObjIntConsumer< String> validator = (value, length) -> {
            if (value == null || value.trim().isEmpty() || value.length() > length) {
                throw new IllegalArgumentException("value cannot be null, empty or larger than 30 chars");
            }
        };

        String fn = requestData.get(FN)[0];
        String ln = requestData.get(LN)[0];
        
        validator.accept(fn, 30);
        validator.accept(ln, 30);

        Author a = new Author();
        a.setFirstName(fn);
        a.setLastName(ln);
        
        if(requestData.containsKey(ID)){
            int id = Integer.valueOf(requestData.get(ID)[0]);
            a.setAuthorID(id);
        }
        
        return a;
    }

    @Override
    public Author getWithId(int id) {
        return get(()->dal().findByAuthorID(id));
    }

    @Override
    public List< Author> getAll() {
        return get(()->dal().findAll());
    }
}
