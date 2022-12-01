package pl.britenet.campus_api.service;


import java.util.List;

public class PaginationService<T> {

    private List<T> allRecords;
    private int pageLimit;
    private int page;
    private int pageCount;

    public PaginationService(List<T> allRecords, int pageLimit) {
        this.allRecords = allRecords;  //lisa
        this.pageLimit = pageLimit; //limit na stronie

        this.page = 0; //strona
        this.pageCount = (int) Math.ceil(allRecords.size()/this.pageLimit); // ilosc stron


    }


    public void getCurrent(){
        for (int i = 0; i < pageLimit; i++){
            System.out.println(allRecords.get(i));

        }
        page++;
        System.out.println(page + " " + pageLimit + " " + pageCount);
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

    public void getProducts(List<T> list, int actualPage){


            for(int i = 0; i < pageLimit; i++ ){
                System.out.println(list.get(i + (pageLimit * actualPage)));


            } System.out.println(actualPage);


    }


}
//next previos current
//dodac kolumny do bazy (i tu T.T)
//4 rapoty na group by + 1 rollaup z zadanka 12:30~
