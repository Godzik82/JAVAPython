package interfaces;

public interface Items {
    
    int getExist();
    String getName();
    int getWeight();
    // int getStreigth();
    // void setExist(int changeExist);
    public default int downStreigth(){
        return -1;
    }
    // void brokeItem();
    // String[] addItem();

}
