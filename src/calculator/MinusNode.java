/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *  MinusNode 继承自SymbolNode，表示加号
 * @author Leoyork
 */
public class MinusNode extends  SymbolNode {
    public MinusNode(Node left,Node right)
    {
        super(left,right);//调用父类的构造函数
    }
    public MinusNode()
    {
        
    }
    
    @Override
    public float interpret()
    {
        return super.left.interpret() - super.right.interpret()  ;
                
    }  
    @Override
public String toString()
{
 return "-";
}
}
