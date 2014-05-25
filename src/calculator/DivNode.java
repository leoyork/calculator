/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *  DivNode 继承自SymbolNode，表示除号÷
 * @author Leoyork
 */
public class DivNode extends  SymbolNode {
    public DivNode(Node left,Node right)
    {
        super(left,right);//调用父类的构造函数
    }
    @Override
    public float interpret()
    {
        return super.left.interpret() / super.right.interpret()  ;
                
    }
     @Override
    public String toString()
    {
        return ""+ super.left.interpret() / super.right.interpret()  ;
    }
}
