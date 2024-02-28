package jdk11to17;

public class SwitchExpression {
     static void normally() {
        //normally
        var value = 1;
        switch (value) {
            case 1,2,3,5 : {
                System.out.println("normally case 1");
                System.out.println(" case 1");
                System.out.println(" case 1");
                break;
            }
            case 6,7:
                System.out.println("normally case 2");
                System.out.println("case 2");
                System.out.println("case 2");
                break;
            default:
                System.out.println("normally default");
                System.out.println("default");
        }
    }

    static void expression() {
        //expression
        var value = 2;
        switch (value) {
            case 1,2,3,5 -> {
                System.out.println("expression case 1");
                System.out.println("case 1");
                System.out.println("case 1");
            }
            case 6,7 -> {
                System.out.println("expression case 2");
                System.out.println("case 2");
                System.out.println("case 2");
            }
            default -> {
                System.out.println("expression default");
                System.out.println("default");
            }
        }
    }

    public static void main(String[] args) {
        normally();
        expression();
    }
}
