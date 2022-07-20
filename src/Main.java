import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] subStr;
        subStr = line.split(" ");
        int num1 = 0;
        int num2 = 0;
        int num3 = -30;
        boolean fladRim = false;
        boolean flag = true;
        if (subStr.length == 3) {
            if ((Operation.isNumeric(subStr[0])) & (Operation.isNumeric(subStr[2]))) {
                num1 = Integer.parseInt(subStr[0]);
                num2 = Integer.parseInt(subStr[2]);
            } else if (!(Operation.isNumeric(subStr[0])) & !(Operation.isNumeric(subStr[2]))) {
                num1 = Operation.convertRim(subStr[0]);
                num2 = Operation.convertRim(subStr[2]);
                fladRim = true;
            } else {
                System.out.println("throws Exception");
                flag = false;
            }
            if (flag) {
                if (subStr[1].equals("+")) {
                    num3 = num1 + num2;
                } else if (subStr[1].equals("-")) {
                    num3 = num1 - num2;
                } else if (subStr[1].equals("*")) {
                    num3 = num1 * num2;
                } else if (subStr[1].equals("/")) {
                    num3 = num1 / num2;
                } else {
                    System.out.println("throws Exception");
                }
                if (num3 < 0) {
                    System.out.println("throws Exception");
                } else if (num1 > 10 & num2 > 10) {
                    System.out.println("throws Exception");
                } else if (fladRim) {
                    System.out.println(Operation.convertArab(num3));
                } else {
                    System.out.println(num3);
                }
            }
        } else{
            System.out.println("throws Exception");
        }
    }
}


class Operation {
    static int convertRim(String value) {
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < value.length(); i++) {
            if ((i != value.length() - 1) & flag) {
                if (value.charAt(i) == 'I') {
                    if (value.charAt(i + 1) == 'V') {
                        flag = false;
                        sum += 4;
                    } else if (value.charAt(i + 1) == 'X') {
                        flag = false;
                        sum += 9;
                    } else {
                        sum += 1;
                    }
                }else if (value.charAt(i) == 'V') {
                    sum += 5;
                }else if (value.charAt(i) == 'X') {
                    if (value.charAt(i + 1) == 'L') {
                        flag = false;
                        sum += 40;
                    } else if (value.charAt(i + 1) == 'C') {
                        flag = false;
                        sum += 90;
                    } else {
                        sum += 10;
                    }
                }else if (value.charAt(i) == 'L') {
                    sum += 50;
                }else if (value.charAt(i) == 'C') {
                    if (value.charAt(i + 1) == 'D') {
                        flag = false;
                        sum += 400;
                    } else if (value.charAt(i + 1) == 'M') {
                        flag = false;
                        sum += 900;
                    } else {
                        sum += 100;
                    }
                }else if (value.charAt(i) == 'D') {
                    sum += 500;
                }else if (value.charAt(i) == 'M') {
                    sum += 1000;
                }
            } else if ( !(flag)) {
                flag = true;
                continue;
            } else {
                if (value.charAt(i) == 'I') {
                    sum += 1;
                } else if (value.charAt(i) == 'V') {
                    sum += 5;
                } else if (value.charAt(i) == 'X') {
                    sum += 10;
                } else if (value.charAt(i) == 'L') {
                    sum += 50;
                } else if (value.charAt(i) == 'C') {
                    sum += 100;
                } else if (value.charAt(i) == 'D') {
                    sum += 500;
                } else if (value.charAt(i) == 'M') {
                    sum += 1000;
                } else {
                    break;
                }

            }
        }
        return sum;
    }

    static String convertArab(int value){
        String rim = "";
        int num = value;
        if (num >= 100) {
            if (num == 1000) {
                rim = rim.concat("M");
            }
            if ((num >= 900) & (num < 1000)) {
                rim = rim.concat("CM");
            }if ((num >= 500) & (num < 900)) {
                rim = rim.concat("D");
                num = num - 500;
            }
            if ((num >= 400) & (num < 500)) {
                rim = rim.concat("CD");
            }
            if (num < 400) {
                for (int i = 99; i < num; i = i + 100) {
                    rim = rim.concat("C");
                }
            }
            num %= 100;
        }
        if((num >= 10)) {
            if ((num >= 90) & (num < 100)) {
                rim = rim.concat("XC");
            }
            if ((num >= 50) & (num < 90)) {
                rim = rim.concat("L");
                num = num - 50;
            }else if ((num >= 40) & (num < 50)) {
                rim = rim.concat("XL");
            }
            if (num < 40) {
                for (int i = 9; i < num; i = i + 10) {
                    rim = rim.concat("X");
                }
            }
            num %= 10;
        }
        if (num < 10){
            if (num == 9){
                rim = rim.concat("IX");
            }
            if ((num >= 5) & (num < 9)) {
                rim = rim.concat("V");
                num = num - 5;
            }else if (num == 4){
                rim = rim.concat("IV");
            }
            if (num < 4) {
                for (int i = 0; i < num; i = i + 1) {
                    rim = rim.concat("I");
                }
            }
        }
    return rim;
    }

    static boolean isNumeric(String string) {
        int intValue;
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}


