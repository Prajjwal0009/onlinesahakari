package controller;

import model.*;
import services.CustomerService;

public class CustomerController extends BaseController<CustomerModel>{
    CustomerService service = null;


    public CustomerController() {
        super(CustomerModel.class);
        service = new CustomerService();
    }


    public BaseModelList<ApiPath> setupPath() {
        BaseModelList<ApiPath> pathList = new BaseModelList<ApiPath>();

        var getAll = new ApiPath("customer", PathType.GET_ALL);
        var getSingle = new ApiPath("customer/:id", PathType.GET_SINGLE);
        var add = new ApiPath("customer", PathType.ADD);
        var update = new ApiPath("customer/:id", PathType.UPDATE);
        var delete = new ApiPath("customer/delete/:id", PathType.DELETE);

        pathList.add(getAll);
        pathList.add(getSingle);
        pathList.add(add);
        pathList.add(update);
        pathList.add(delete);

        return pathList;
    }
    public BaseModelList<CustomerModel> getAll(){
        return service.getAll();
    }

    @Override
    public int add(CustomerModel model){
        return service.Add(model);
    }
    @Override
    public int update(CustomerModel data, CustomerModel model){
        data.setAddress(model.getAddress());
        data.setName(model.getName());
        data.setStartDate(model.getStartDate());
        data.setAreaId(model.getAreaId());
        data.setArea(model.getArea());
        data.setActive(model.isActive());

        return service.Update(model);
    }
    @Override
    public int delete(int id){
        return service.Delete(id);
    }
    public CustomerModel getSingle(int id){
        return service.GetSingle(id);
    }

}
