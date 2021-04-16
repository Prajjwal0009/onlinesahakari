package controller;

import model.*;
import services.AreaModelService;

public class AreaModelController extends BaseController<AreaModel> {
    AreaModelService service = null;
    public AreaModelController(){
        super(AreaModel.class);
        service = new AreaModelService();
    }

    @Override
    public BaseModelList<ApiPath> setupPath() {
        BaseModelList<ApiPath> pathList = new BaseModelList<ApiPath>();

        var getAll = new ApiPath("area", PathType.GET_ALL);
        var getSingle = new ApiPath("area/:id", PathType.GET_SINGLE);
        var add = new ApiPath("area", PathType.ADD);
        var update = new ApiPath("area/:id", PathType.UPDATE);
        var delete = new ApiPath("area/delete/:id", PathType.DELETE);

        pathList.add(getAll);
        pathList.add(getSingle);
        pathList.add(add);
        pathList.add(update);
        pathList.add(delete);

        return pathList;
    }
    public BaseModelList<AreaModel> getAll(){
        return service.getAll();
    }
    @Override
    public int add(AreaModel model){
        return service.Add(model);
    }
    @Override
    public int update(AreaModel data,AreaModel model){
        data.setName(model.getName());
        data.setDescription(model.getDescription());
        return service.Update(model);
    }
    @Override
    public int delete(int id){
        return service.Delete(id);
    }
    public AreaModel GetAreaModelData(int id){
        return service.GetSingle(id);
    }
    public AreaModel getSingle(int id){
        return service.GetSingle(id);
    }
}
