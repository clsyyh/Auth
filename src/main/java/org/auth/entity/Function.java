package org.auth.entity;

public class Function {
    private Integer id;
    private String name;
    private Integer parentId;
    private String url;
    private Integer serialNum;
    private Integer accordion;

    public Function() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public Integer getAccordion() {
        return accordion;
    }

    public void setAccordion(Integer accordion) {
        this.accordion = accordion;
    }
}
