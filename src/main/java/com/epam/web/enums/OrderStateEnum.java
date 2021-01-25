package com.epam.web.enums;

public enum OrderStateEnum {
    ACCEPT("Accept","Принят","Прынят"),PREPARING("Preparing","Готовится","Гатуецца"),
    FINISH("Finish","Закончен","Закончан"),PICKED_UP("Picked_up","Забран","Забран");
    private String eng;
    private String ru;
    private String by;
    OrderStateEnum(String eng, String ru, String by) {
        this.eng=eng;
        this.ru=ru;
        this.by=by;
    }

    public String getEng() {
        return eng;
    }

    public String getRu() {
        return ru;
    }

    public String getBy() {
        return by;
    }
}
