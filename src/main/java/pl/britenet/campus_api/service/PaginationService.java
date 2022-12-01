package pl.britenet.campus_api.service;


import java.util.List;

public class PaginationService<T> {

    private List<T> allRecords;
    private int pageLimit;
    private int page;
    private int pageCount;

    public PaginationService(List<T> allRecords, int pageLimit) {
        this.allRecords = allRecords;  //lisa
        this.pageLimit = pageLimit; //limit na stronieS
        this.page = 0; //strona
        this.pageCount = (int) Math.ceil(allRecords.size()/this.pageLimit); // ilosc stron
    }

    public void getCurrent(){
        try {
            for (int i = 0; i < pageLimit; i++){
                System.out.println(allRecords.get(i));
            }
            System.out.println("(p) previous ------ next (n)");
            page++;
        }catch (IndexOutOfBoundsException e){
            System.out.println( "There is not next data");
        }

    }

    public  void getNext() {
        try {
            for (int i = 0; i < pageLimit; i++) {
                System.out.println(allRecords.get((page * pageLimit) + i));
            }
            System.out.println("(p) previous ------ next (n)");
            page++;
        }catch (IndexOutOfBoundsException e){
            System.out.println( "There is not next data");
        }
    }

    public  void getPrevious(){
       try {
           page--;
           for (int i = 0; i < pageLimit; i++){
               System.out.println(allRecords.get((page * pageLimit) - (5 - i)));
           }
           System.out.println("(p) previous ------ next (n)");
       } catch (IndexOutOfBoundsException e){
           System.out.println( "There is not previous data");
       }
    }

}
//next previos current
//dodac kolumny do bazy (i tu T.T)
//4 rapoty na group by + 1 rollaup z zadanka 12:30~
