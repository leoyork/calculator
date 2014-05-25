/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *ValueNode是终结符表达式类，即操作数类
 * @author Leoyork
 */
public class ValueNode implements Node{
    private float value;
    
    public ValueNode(float value)//构造函数
    {
        this.value = value;
    }
    @Override
    public float interpret()//实现了Node接口中声明的方法
    {
        return this.value;
    }
    @Override
    public String toString()
    {
        return ""+this.value;
    }
}
