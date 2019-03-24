import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;
public class InfixToSuffix {

          public static double stringToArithmetic(String string) {
             return suffixToArithmetic(infixToSuffix(string));
         }
       // 将中缀表达式转换为后缀表达式
       public static String infixToSuffix(String exp) {
          Stack<Character> s = new Stack<Character>();
          // 要输出的后缀表达式字符串
          String suffix = "";
          int length = exp.length();
          for (int i = 0; i < length; i++) {
                  char temp;
                  char ch = exp.charAt(i);
                  switch (ch) {
                  case ' ':
                          break;
                  case '(':
                          s.push(ch);
                          break;
                  case '+':
                      case '-':
                          while (s.size() != 0) {
                                  temp = s.pop();
                                  if (temp == '(') {
                                       s.push('(');
                                       break;
                                   }
                               suffix += temp;

                           }
                       s.push(ch);
                       break;
               case '*':
                   case '/':
                       while (s.size() != 0) {
                               temp = s.pop();
                               if (temp == '+' || temp == '-' || temp == '(') {
                                       s.push(temp);
                                       break;
                                   } else {
                                       suffix += temp;
                                   }
                            }

                        s.push(ch);
                        break;


                case ')':
                        while (!s.isEmpty()) {
                                temp = s.pop();
                                if (temp == '(') {
                                        break;
                                    } else {
                                        suffix += temp;
                                    }
                            }
                        break;
                default:

                    while(ch<='9'&&ch>='0'){
                        suffix += ch;
                        i++;
                        if(i<length){
                        ch=exp.charAt(i);}
                        else
                            ch='k';
                    }
                    suffix+=" ";
                    i--;
                        break;
                }

         }
     while (s.size() != 0) {
             suffix += s.pop();
         }

         String[] endList=suffix.split(" ");
          String start=endList[0];
          for(int i=1;i<endList.length;i++){
              if(!Character.isDigit(endList[i].charAt(0))){
                  String[] edL=endList[i].split("");
                for(String str:edL){
                    start+=" "+str;
                }
              }else{
              start += " "+endList[i];}
          }

          suffix=start;
     return suffix;
 }

public static double suffixToArithmetic(String exp) {
      // 使用正则表达式
      Pattern pattern = Pattern.compile("\\d+||(\\d+\\.\\d+)");
      // 将后缀表达式分割成字符串数组
      String[] strings = exp.split(" ");
      Stack<Double> stack = new Stack<Double>();
      for (int i = 0; i < strings.length; i++) {
           if (strings[i].equals("")) {
                   continue;
               }
           // 如果遇到了数字则直接进栈
           if (pattern.matcher(strings[i]).matches()) {
                   stack.push(Double.parseDouble(strings[i]));
               }
           // 如果是运算符，则弹出栈顶的两个数进行计算
           else {
                   double y = stack.pop();
                   double x = stack.pop();
                   // 将运算结果重新压栈
                   stack.push(calculate(x, y, strings[i]));
               }
       }
   return stack.pop();
 }

private static Double calculate(double x, double y, String string) {
     if (string.trim().equals("+")) {
             return x + y;
         }
     if (string.trim().equals("-")) {
             return x - y;
         }
     if (string.trim().equals("*")) {
             return x * y;
         }
     if (string.trim().equals("/")) {
             return x / y;
         }
     return (double) 0;
 }
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the expression:");
    String exp=sc.nextLine();
    System.out.println(InfixToSuffix.infixToSuffix(exp));
    System.out.println(InfixToSuffix.stringToArithmetic(exp));

    }

}
