package controller;

import model.ApiPath;
import model.BaseModelList;
import model.PathType;
import model.UserModel;
import services.UserService;

public class UserController extends BaseController<UserModel> {
    UserService service = null;
    public UserController(){
        super(UserModel.class);
        service = new UserService();
    }
    @Override
    public BaseModelList<ApiPath> setupPath() {
        BaseModelList<ApiPath> pathList = new BaseModelList<ApiPath>();

        var getAll = new ApiPath("user", PathType.GET_ALL);
        var getSingle = new ApiPath("user/:id", PathType.GET_SINGLE);
        var add = new ApiPath("user", PathType.ADD);
        var update = new ApiPath("user/:id", PathType.UPDATE);
        var delete = new ApiPath("user/delete/:id", PathType.DELETE);

        pathList.add(getAll);
        pathList.add(getSingle);
        pathList.add(add);
        pathList.add(update);
        pathList.add(delete);

        return pathList;
    }

    public BaseModelList<UserModel> getAll(){
        return service.getAll();
    }
    @Override
    public int add(UserModel model){
        return service.Add(model);
    }
    @Override
    public int update(UserModel data, UserModel model){
        data.setUserName(model.getUserName());
        data.setPassword(model.getPassword());
        data.setDisplayName(model.getDisplayName());
        return service.Update(model);
    }
    @Override
    public int delete(int id){
        return service.Delete(id);
    }
    public UserModel getSingle(int id){
        return service.GetSingle(id);
    }

}
