/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Leoyork
 */
public class Calculator {

    /**
     * @param args the command line arguments
     */
    final public static float compute(String input) {
        // TODO code application logic here
//        String input = "-0+3.2*0+2";
       ArrayList<String> op = new ArrayList<String>();
       op.add("+");  op.add("-"); op.add("*"); op.add("/");
      char[] inputc = input.toCharArray();
      
       String temp1="";//用来保存预处理之后的字符串，预处理即把操作数和操作符分开
       
       
       int i  = 0 ;
       if(inputc[0]=='-')//考虑最开始的数为负数的情况、、默认所有负数都只出现在字符串开始，除非用括号括起来
       {
           temp1="-";
           i=1;
       }
       while(i<inputc.length)//开始循环，用~把操作数和操作符隔开
       {
          
               String read_temp  =""+inputc[i];
                 if(op.contains(read_temp))//如果当前字符为操作符
                 {
                     temp1=temp1+"~"+read_temp+"~";
                   
                 }
                 else//如果当前字符为操作数
                 {
                     temp1=temp1+read_temp;
                     //检验输入的合法性，若不为【.】，则应为数字
                     if(!read_temp.equals("."))
                     {
                    try
                    {
                        int test =  Integer.valueOf(read_temp);
                    }
                    catch(Exception e)
                    {
//                     System.out.println("输入格式错误 :)");   
                       javax.swing.JOptionPane.showMessageDialog(null,"输入格式错误\n请重新输入","输入错误",JOptionPane.ERROR_MESSAGE );
      
                    }
                     }
                     //检验完毕
                     
                     
                 }
                  i++;
        }
//       System.out.println("解释后的字符串："+temp1);
       String[] statementArr = temp1.split("~");//inputs中存放的是每个操作数和操作符
//       for(String s : statementArr)
//       {
//           System.out.println("解析得到的字符："+s);
//       }
//       
       
       //解析完毕之后开始处理
       Node left  = null;
       Node right = null;
       Node root = null;
       Stack stack = new Stack();
     for(int j = 0; j<statementArr.length;j++)//先处理优先级高的操作符
       {
//           System.out.println("解析得到的字符："+j+statementArr[j]);
           if(statementArr[j].equalsIgnoreCase("*"))
           {
               left = (Node) stack.pop();
//               int val = Integer.parseInt(statementArr[++j]);
               float val = Float.parseFloat(statementArr[++j]);
//               System.out.println("val"+val);
               right = new ValueNode(val);
              MulNode m =  new MulNode(left,right);
//              System.out.println("乘法的结果为："+m.interpret());
               stack.push(m);
           }
           else if(statementArr[j].equalsIgnoreCase("/"))
           {
               left = (Node) stack.pop();
//               int val = Integer.parseInt(statementArr[++j]);
               float val = Float.parseFloat(statementArr[++j]);
               
               right = new ValueNode(val);
               stack.push(new DivNode(left,right));
           }
        else if(statementArr[j].equalsIgnoreCase("+"))
           {
              
               stack.push(new PlusNode());
           }
          else if(statementArr[j].equalsIgnoreCase("-"))
           {
              
               stack.push(new MinusNode());
           }

           else//遇到数字
           {
//               System.out.println("解析得到数字："+statementArr[j]);
               stack.push(new ValueNode(Float.parseFloat(statementArr[j])));
           }
       }

//    
//    
       String others = "";//用others来存放剩下的字符串，即只包含次优先级操作符和操作数的字符串
       while(!stack.isEmpty())
       {
//          System.out.println("栈："+stack.pop().toString());
           others  = stack.pop().toString()+"~"+others;
          
       }
       others = others.substring(0, others.length()-1);
         System.out.println(others);
       
         String[] statementArr2 = others.split("~");
           for(int j = 0; j<statementArr2.length;j++)
       {
//           System.out.println("解析得到的字符："+j+statementArr2[j]);
           if(statementArr2[j].equalsIgnoreCase("+"))
           {
               left = (Node) stack.pop();
               try
               {
               float val = Float.parseFloat(statementArr2[++j]);
               right = new ValueNode(val);
               }
               catch(Exception e)
               {
                    javax.swing.JOptionPane.showMessageDialog(null,"输入格式错误\n请重新输入","输入错误",JOptionPane.ERROR_MESSAGE );
      
               }
              PlusNode m =  new PlusNode(left,right);
//              System.out.println("乘法的结果为："+m.interpret());
               stack.push(m);
           }
           else if(statementArr2[j].equalsIgnoreCase("-"))
           {
               left = (Node) stack.pop();
               float val = Float.parseFloat(statementArr2[++j]);
               
               right = new ValueNode(val);
               stack.push(new MinusNode(left,right));
           }
      
           else//遇到数字
           {
//               System.out.println("解析得到数字："+statementArr2[j]);
               stack.push(new ValueNode(Float.parseFloat(statementArr2[j])));
           }
       }
              root = (Node) stack.pop();
       System.out.println("根节点"+root.interpret());
       return root.interpret();
       
       
       
       }
    }

