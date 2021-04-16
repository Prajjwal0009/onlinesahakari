package services;

import model.BaseModel;
import model.BaseModelList;
import model.CustomerModel;
import repo.BaseRepository;
import repo.CustomerRepository;
import java.lang.reflect.Constructor;

public class BaseService<T extends BaseRepository, M extends BaseModel>  {

    private Class<T> typeArgumentClass;

    public BaseService(Class<T> typeArgumentClass) {

        this.typeArgumentClass = typeArgumentClass;
    }
    T repo = null;
    public BaseService(){
        try {
            repo = typeArgumentClass.newInstance();
        }
        catch (Exception ex){

        }
    }

    public BaseModelList<M> getAll() {
        try {
            if (repo != null) {
                return repo.GetAll();
            }
        }
        catch (Exception ex){

        }
        return null;
    }

    public int Add(M model){
        try {
            return repo.Add(model);
        }
        catch (Exception ex){

        }
        return -1;
    }

    public int Update(M model){
        try {
            return repo.Update(model);
        }
        catch (Exception ex){

        }
        return -1;
    }

/*    public M GetSingle(int id){
        try {
            return repo.GetSingle(id);
        }
        catch (Exception ex){

        }
        return -1;
    }*/
}
