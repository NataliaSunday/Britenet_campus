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
        for (int i = 0; i < pageLimit; i++){
            System.out.println(allRecords.get(i));
        }
        page++;
    }

    public  void getNext(){
        for (int i = 0; i < pageLimit; i++){
            System.out.println(allRecords.get((page * pageLimit) +i));
        }
        page++;
    }

    public  void getPrevious(){
        page--;
        for (int i = 0; i < pageLimit; i++){
            System.out.println(allRecords.get((page * pageLimit) - (5 - i)));
        }
    }



}
//next previos current
//dodac kolumny do bazy (i tu T.T)
//4 rapoty na group by + 1 rollaup z zadanka 12:30~
