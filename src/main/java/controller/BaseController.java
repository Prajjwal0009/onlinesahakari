package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.ApiPath;
import model.BaseModelList;
import model.CollectorModel;
import model.PathType;

import java.lang.reflect.*;

import static spark.Spark.get;
import static spark.Spark.post;

public abstract class BaseController<T> {
    private final Class<T> type;
    protected BaseController(Class<T> tClass){
        type = tClass;
    }

    public abstract BaseModelList<ApiPath> setupPath();
    public abstract int add(T model);
    public abstract int update(T data, T model);
    public abstract int delete(int id);
    public abstract BaseModelList<T> getAll();
    public abstract T getSingle(int id);

    private Object getData(int id){
        if(id==0) {
            return getAll();
        }
        else{
            return getSingle(id);
        }
    }

    protected int sanitizeId(String idParam){
        int id = 0;
        try {
            id = Integer.parseInt(idParam);
        }
        catch(Exception ex) {
        }
        return id;
    }
    private ApiPath getPathByType(PathType pathType){
        for (var path: this.setupPath()
             ) {
            if(path.pathType == pathType)
                return path;

        }
        return null;
    }

    public void init(){
        get(getPathByType(PathType.GET_SINGLE).pathName, (req, res)-> {
            var id = sanitizeId(req.params("id"));
            return getData(id);
        });
        get(getPathByType(PathType.GET_ALL).pathName, (req, res)-> {
            return getData(0);
        });
        get(getPathByType(PathType.DELETE).pathName, (req, res)-> {
            var id = sanitizeId(req.params("id"));
            var data =  getSingle(id);
            if(data != null) {
                var success = delete(id);
                if(success > 0)
                    return "success";
                else
                    return "failure";
            }
            else
                return "data not exist";
        });

        post(getPathByType(PathType.ADD).pathName, (req, res)-> {
            T model=  new Gson().fromJson(req.body(),type);
            int result = this.add(model);
            if(result > 0)
                return "success";
            else
                return "failure";
        });

        post(getPathByType(PathType.UPDATE).pathName, (req, res)-> {
            T model=  new Gson().fromJson(req.body(),type);  //  get value from postman, convert to java object from json using GSON library
            var id = sanitizeId(req.params("id"));
            var data =  getSingle(id);

            if(data != null) {
                int result = this.update(data,model);
                if (result > 0)
                    return "success";
                else
                    return "failure";
            }
            else{
                return "no data exist";
            }
        });
    }
}
