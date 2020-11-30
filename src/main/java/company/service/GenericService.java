package company.service;

public interface GenericService<T,Id> {
    void create(T t);
}
