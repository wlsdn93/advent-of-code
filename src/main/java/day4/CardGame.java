package day4;

public class CardGame {

    public int getPowerOfCount(String input) {
        int count = this.countMatchedNumber(input);
        return (int)(count > 0 ? Math.pow(2, count - 1) : 0);
    }

    public int countMatchedNumber(String input) {
        String[] split = input.split(":");
        String[] cards = split[1].split("\\|");
        String[] winningNumbers = cards[0].trim().split("\\s{1,2}");
        String[] numbersYouHave = cards[1].trim().split("\\s{1,2}");
        int count = 1;
        for (String w : winningNumbers) {
            for (String y : numbersYouHave) {
                if (w.equals(y)) count++;
            }
        }
        return count;
    }
}
