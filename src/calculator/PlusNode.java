/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *  PlusNode 继承自SymbolNode，表示加号
 * @author Leoyork
 */
public class PlusNode extends  SymbolNode {
    public PlusNode(Node left,Node right)
    {
        super(left,right);//调用父类的构造函数
    }
    public PlusNode()
    {
        
    }
    @Override
    public float interpret()
    {
        return super.left.interpret() + super.right.interpret()  ;
                
    }
   
    @Override
    public String toString()
    {
        return "+";
    }
}
