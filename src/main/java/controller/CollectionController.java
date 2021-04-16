package controller;

import model.*;
import services.CollectionService;

public class CollectionController extends BaseController<CollectionModel> {
    CollectionService service = null;

    public CollectionController(){
        super(CollectionModel.class);
        service = new CollectionService();
    }
    @Override
    public BaseModelList<ApiPath> setupPath() {
        BaseModelList<ApiPath> pathList = new BaseModelList<ApiPath>();

        var getAll = new ApiPath("collection", PathType.GET_ALL);
        var getSingle = new ApiPath("collection/:id", PathType.GET_SINGLE);
        var add = new ApiPath("collection", PathType.ADD);
        var update = new ApiPath("collection/:id", PathType.UPDATE);
        var delete = new ApiPath("collection/delete/:id", PathType.DELETE);

        pathList.add(getAll);
        pathList.add(getSingle);
        pathList.add(add);
        pathList.add(update);
        pathList.add(delete);

        return pathList;
    }

    public BaseModelList<CollectionModel> getAll(){
        return service.getAll();
    }

    public int add(CollectionModel model){
        return service.Add(model);
    }
    public int update(CollectionModel data, CollectionModel model){
        data.setCollectorId(model.getCollectorId());
        data.setCustomerId(model.getCustomerId());
        data.setAmount(model.getAmount());
        data.setCollectionDate(model.getCollectionDate());
        data.setReceivedBy(model.getReceivedBy());
        return service.Update(model);
    }
    public int delete(int id){
        return service.Delete(id);
    }
    public CollectionModel getSingle(int id){
        return service.GetSingle(id);
    }

}
