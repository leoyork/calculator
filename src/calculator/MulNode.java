/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *  MulNode 继承自SymbolNode，表示乘号*
 * @author Leoyork
 */
public class MulNode extends  SymbolNode {
    public MulNode(Node left,Node right)
    {
        super(left,right);//调用父类的构造函数
    }
    @Override
    public float interpret()
    {
        return super.left.interpret() * super.right.interpret()  ;
                
    }
    public String toString()
    {
        return ""+ super.left.interpret() * super.right.interpret()  ;
    }
}
