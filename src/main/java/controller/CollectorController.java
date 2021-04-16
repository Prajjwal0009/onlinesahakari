package controller;

import model.ApiPath;
import model.BaseModelList;
import model.CollectorModel;
import model.PathType;
import services.CollectorService;

public class CollectorController extends BaseController<CollectorModel> {
    CollectorService service = null;

    public CollectorController() {
        super(CollectorModel.class);
        service = new CollectorService();
    }

    @Override
    public BaseModelList<ApiPath> setupPath() {
        BaseModelList<ApiPath> pathList = new BaseModelList<ApiPath>();

        var getAll = new ApiPath("collector", PathType.GET_ALL);
        var getSingle = new ApiPath("collector/:id", PathType.GET_SINGLE);
        var add = new ApiPath("collector", PathType.ADD);
        var update = new ApiPath("collector/:id", PathType.UPDATE);
        var delete = new ApiPath("collector/delete/:id", PathType.DELETE);

        pathList.add(getAll);
        pathList.add(getSingle);
        pathList.add(add);
        pathList.add(update);
        pathList.add(delete);

        return pathList;
    }

    public BaseModelList<CollectorModel> getAll() {
        return service.getAll();
    }

    @Override
    public int add(CollectorModel model) {
        return service.Add(model);
    }

    @Override
    public int update(CollectorModel data, CollectorModel model) {
        data.setAddress(model.getAddress());
        data.setName(model.getName());
        return service.Update(data);
    }

    @Override
    public int delete(int id) {
        return service.Delete(id);
    }

    public CollectorModel getSingle(int id) {
        return service.GetSingle(id);
    }
}