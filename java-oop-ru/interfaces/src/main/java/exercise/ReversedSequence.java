package exercise;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

class ReversedSequence implements CharSequence {
    private String string;
    private String reversedStr;

    @Override
    public String toString() {
        return reversedStr;
    }

    ReversedSequence(String str) {
        this.reversedStr = IntStream.rangeClosed(1, str.length())
                .mapToObj(i -> String.valueOf(str.charAt(str.length() - i)))
                .collect(Collectors.joining());
    }

    @Override
    public int length() {
        return reversedStr.length();
    }

    @Override
    public char charAt(int index) {
        return reversedStr.charAt(index);
    }

    @Override
    public boolean isEmpty() {
        return CharSequence.super.isEmpty();
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return reversedStr.subSequence(start, end);
    }

    @Override
    public IntStream chars() {
        return CharSequence.super.chars();
    }

    @Override
    public IntStream codePoints() {
        return CharSequence.super.codePoints();
    }
}

