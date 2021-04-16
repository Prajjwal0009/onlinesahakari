package services;

import model.*;
import repo.CollectionRepository;


public class CollectionService {
    CollectionRepository repo = null;
    public CollectionService(){
        try {
            repo = new CollectionRepository();
        }
        catch (Exception ex){

        }
    }

    public BaseModelList<CollectionModel> getAll() {
        try {
            if (repo != null) {
                return repo.GetAll();
            }
        }
        catch (Exception ex){

        }
        return null;
    }
    public int Add(CollectionModel model){
        try {
            return repo.Add(model);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return -1;
    }
    public int Update(CollectionModel model){
        try {
            return repo.Update(model);
        }
        catch (Exception ex){

        }
        return -1;
    }

    public CollectionModel GetSingle(int id){
        try {
            return repo.GetSingle(id);
        }
        catch (Exception ex){

        }
        return null;
    }
    public int Delete(int id){
        try {
            return repo.Delete(id);
        }
        catch (Exception ex){

        }
        return -1;
    }
}
