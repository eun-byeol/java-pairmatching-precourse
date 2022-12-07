package pairmatching.enums;

public enum MissionType {
    CAR_RACING("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    SHOPPING_BASKET("장바구니"),
    PAYMENT("결제"),
    SUBWAY_LINE("지하철노선도"),
    PERFORMANCE_IMPROVEMENT("성능개선"),
    DISTRIBUTE("배포");

    private String name;

    MissionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}