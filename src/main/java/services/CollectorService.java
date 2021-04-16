package services;

import model.*;
import repo.CollectorRepository;

public class CollectorService {
    CollectorRepository repo = null;
    public CollectorService(){
        try {
            repo = new CollectorRepository();
        }
        catch (Exception ex){

        }
    }

    public BaseModelList<CollectorModel> getAll() {
        try {
            if (repo != null) {
                return repo.GetAll();
            }
        }
        catch (Exception ex){

        }
        return null;
    }
    public int Add(CollectorModel model){
        try {
            return repo.Add(model);
        }
        catch (Exception ex){

        }
        return -1;
    }
    public int Update(CollectorModel model){
        try {
            return repo.Update(model);
        }
        catch (Exception ex){

        }
        return -1;
    }

    public CollectorModel GetSingle(int id){
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
