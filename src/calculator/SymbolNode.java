/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *SymbolNode为抽象非终结符的表达式类，包含了所有操作符的共有的数据和行为
 * @author Leoyork
 */
public abstract class SymbolNode implements Node{
    protected Node left;
    protected Node right;
    public SymbolNode(Node left,Node right)//因为该计算器的操作符都为二元操作符,所以定义了两个Node对象，分别表示操作符的左边的部分和右边的部分
    {
        this.left = left;
        this.right = right;
    }
    public SymbolNode()
    {
        
    }
}
