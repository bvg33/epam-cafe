package com.epam.web.enums;

public enum OrderStateEnum {
    ACCEPT("Accept","accept"),PREPARING("Preparing","preparing"),
    FINISH("Finish","finish"),PICKED_UP("Picked_up","picked");
    private String eng;
    private String key;
    OrderStateEnum(String eng,String key) {
        this.eng=eng;
        this.key=key;
    }

    public String getEng() {
        return eng;
    }

    public String getKey() {return key; }
}
