package services;

import model.*;
import repo.UserRepository;

public class UserService {
    UserRepository repo = null;
    public UserService(){
        try {
            repo = new UserRepository();
        }
        catch (Exception ex){

        }
    }

    public BaseModelList<UserModel> getAll() {
        try {
            if (repo != null) {
                return repo.GetAll();
            }
        }
        catch (Exception ex){

        }
        return null;
    }
    public int Add(UserModel model){
        try {
            return repo.Add(model);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return -1;
    }
    public int Update(UserModel model){
        try {
            return repo.Update(model);
        }
        catch (Exception ex){

        }
        return -1;
    }

    public UserModel GetSingle(int id){
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
