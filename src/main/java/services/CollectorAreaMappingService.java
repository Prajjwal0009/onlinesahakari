package services;

import model.*;

import repo.CollectorAreaMappingRepository;


public class CollectorAreaMappingService {
    CollectorAreaMappingRepository repo = null;
    public CollectorAreaMappingService(){
        try {
            repo = new CollectorAreaMappingRepository();
        }
        catch (Exception ex){

        }
    }

    public BaseModelList<CollectorAreaMapping> getAll() {
        try {
            if (repo != null) {
                return repo.GetAll();
            }
        }
        catch (Exception ex){

        }
        return null;
    }
    public int Add(CollectorAreaMapping model){
        try {
            return repo.Add(model);
        }
        catch (Exception ex){

        }
        return -1;
    }
    public int Update(CollectorAreaMapping model){
        try {
            return repo.Update(model);
        }
        catch (Exception ex){

        }
        return -1;
    }

    public CollectorAreaMapping GetSingle(int id){
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
