package model;

public class BaseModelList<T> extends java.util.ArrayList<T> {
    public BaseModelList(java.util.List<T> list){
        for(int i=0;i<list.size();i++){
            this.add(list.get(i));
        }
    }

    public BaseModelList() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<this.size();i++){
            if(i != 0){
                sb.append(",");
            }
            sb.append(this.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }
}
