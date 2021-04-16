package model;

public class ApiPath {
    public ApiPath(){}
    public ApiPath(String pathName, PathType pathType){
        this.pathName = pathName;
        this.pathType = pathType;
    }

    public PathType pathType;
    public String pathName;

    public PathType getPathType() {
        return pathType;
    }

    public void setPathType(PathType pathType) {
        this.pathType = pathType;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }
}
