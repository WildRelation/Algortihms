package uppgift3;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkBrackets("(()()(()())((())))()"));
        System.out.println(checkBrackets("(((){}[])[]{()}){}"));
        System.out.println(checkBrackets("[{}([]{})]"));
        System.out.println(checkBrackets("({)}"));
        System.out.println(checkBrackets("())"));
        System.out.println(checkBrackets("[[]"));
        System.out.println(checkBrackets("{[]([(){]}}"));
    }

    private static boolean checkBrackets(String s) {
    }
}
