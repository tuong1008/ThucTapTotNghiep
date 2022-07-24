package ptithcm.dao;

/**
 * @author Tuong
 */
public interface GenericDao<T> {
    String save(T product);

    String update(T product);

    String delete(T product);
}
