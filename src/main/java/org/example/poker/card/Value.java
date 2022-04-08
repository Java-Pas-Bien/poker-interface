package org.example.poker.card;

public enum Value {
    DEUX('2', 2),
    TROIS('3', 3),
    QUATRE('4', 4),
    CINQ('5', 5),
    SIX('6', 6),
    SEPT('7', 7),
    HUIT('8', 8),
    NEUF('9', 9),
    DIX('X', 10),
    VALET('V', 11),
    DAME('D', 12),
    ROI('R', 13),
    AS('A', 14);

    public final int score;
    public final char label;
    Value(char label, int score) { this.label = label; this.score = score; }

    @Override
    public String toString() {
        return String.format("%c", this.label);
    }

    public static Value fromString(String string) {
        switch(string.charAt(0)) {
            case '2': return DEUX;
            case '3': return TROIS;
            case '4': return QUATRE;
            case '5': return CINQ;
            case '6': return SIX;
            case '7': return SEPT;
            case '8': return HUIT;
            case '9': return NEUF;
            case 'X': return DIX;
            case 'V': return VALET;
            case 'D': return DAME;
            case 'R': return ROI;
            default: return AS;
        }
    }
}
