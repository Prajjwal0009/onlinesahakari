package services;

import model.*;
import repo.AreaModelRepository;

public class AreaModelService {
    AreaModelRepository repo = null;
    public AreaModelService(){
        try {
            repo = new AreaModelRepository();
        }
        catch (Exception ex){

        }
    }

    public BaseModelList<AreaModel> getAll() {
        try {
            if (repo != null) {
                return repo.GetAll();
            }
        }
        catch (Exception ex){

        }
        return null;
    }
    public int Add(AreaModel model){
        try {
            return repo.Add(model);
        }
        catch (Exception ex){

        }
        return -1;
    }
    public int Update(AreaModel model){
        try {
            return repo.Update(model);
        }
        catch (Exception ex){

        }
        return -1;
    }

    public AreaModel GetSingle(int id){
        try {
            return repo.GetSingle(id);
        }
        catch (Exception ex){
            ex.printStackTrace();
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
