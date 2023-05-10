package nulp.trspo.aviatickets.ticket.dictionary;

public enum Services {
    BAGGAGE(1050), PRIORITY(2000);
    private final int value;

    Services(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
