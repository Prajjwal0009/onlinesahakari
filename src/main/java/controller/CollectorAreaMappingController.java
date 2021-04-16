package controller;

import model.*;
import services.CollectorAreaMappingService;

public class CollectorAreaMappingController extends BaseController<CollectorAreaMapping> {
    CollectorAreaMappingService service = null;
    public CollectorAreaMappingController(){
        super(CollectorAreaMapping.class);
        service = new CollectorAreaMappingService();
    }

    public BaseModelList<CollectorAreaMapping> getAll(){
        return service.getAll();
    }
    @Override
    public BaseModelList<ApiPath> setupPath() {
        BaseModelList<ApiPath> pathList = new BaseModelList<ApiPath>();

        var getAll = new ApiPath("areaMapping", PathType.GET_ALL);
        var getSingle = new ApiPath("areaMapping/:id", PathType.GET_SINGLE);
        var add = new ApiPath("areaMapping", PathType.ADD);
        var update = new ApiPath("areaMapping/:id", PathType.UPDATE);
        var delete = new ApiPath("areaMapping/delete/:id", PathType.DELETE);

        pathList.add(getAll);
        pathList.add(getSingle);
        pathList.add(add);
        pathList.add(update);
        pathList.add(delete);

        return pathList;
    }
    @Override
    public int add(CollectorAreaMapping model){
        return service.Add(model);
    }
    @Override
    public int update(CollectorAreaMapping data,CollectorAreaMapping model){
        data.setCollectorId(model.getCollectorId());
        data.setAreaId(model.getAreaId());
        return service.Update(model);
    }
    @Override
    public int delete(int id){
        return service.Delete(id);
    }
    public CollectorAreaMapping getSingle(int id){
        return service.GetSingle(id);
    }

}
