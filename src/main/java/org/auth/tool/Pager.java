package org.auth.tool;

import java.util.List;

public class Pager<E> {
    private int pageSize;
    private int currentPage;
    private int totalRecord;
    private int totalPage;
    private List<E> dataList;

    public Pager(int pageNum,int pageSize,List<E> sourceList){
        if(sourceList==null){
            System.out.println("null***********");
            return;
        }
            this.totalRecord = sourceList.size();
            this.pageSize = pageSize;
            this.totalPage = this.totalRecord % this.pageSize == 0 ? this.totalRecord / this.pageSize : this.totalRecord / this.pageSize + 1;
            this.currentPage = this.totalPage < pageNum ? this.totalPage : pageNum;
            int formIndex = this.pageSize * (this.currentPage - 1);
            int toIndex = this.pageSize * this.currentPage > this.totalRecord ? this.totalRecord : this.pageSize * this.currentPage;
            this.dataList = sourceList.subList(formIndex, toIndex);
    }

    public Pager(int pageSize, int currentPage, int totalRecord, int totlaPage, List<E> dataList) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;
        this.totalPage = totlaPage;
        this.dataList = dataList;
    }

    public Pager() {
        super();
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<E> getDataList() {
        return dataList;
    }

    public void setDataList(List<E> dataList) {
        this.dataList = dataList;
    }

}
