package jdk11to17;

public class TextBlocks {

    record Point(int x, int y) {
    }

    public static void main(String[] args) {

        Point p = new Point(1,8);
        int aa = p.hashCode();
        System.out.println(aa);

        String textBlock = """
                    this is a block-text 
                    this is a new line
                    end line %s
                """.formatted("paramate");
        System.out.println(textBlock);

    }

}
