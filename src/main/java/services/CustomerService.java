package services;

import model.*;
import repo.CustomerRepository;

public class CustomerService {
    CustomerRepository repo = null;
    public CustomerService(){
        try {
            repo = new CustomerRepository();
        }
        catch (Exception ex){

        }
    }

    public BaseModelList<CustomerModel> getAll() {
        try {
            if (repo != null) {
                return repo.GetAll();
            }
        }
        catch (Exception ex){

        }
        return null;
    }
    public int Add(CustomerModel model){
        try {
            return repo.Add(model);
        }
        catch (Exception ex){
            ex.printStackTrace();

        }
        return -1;
    }
    public int Update(CustomerModel model){
        try {
            return repo.Update(model);
        }
        catch (Exception ex){

        }
        return -1;
    }

    public CustomerModel GetSingle(int id){
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
