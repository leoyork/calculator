/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *Node是抽象表达式类，声明了抽象解释方法interpret（）,在其子类中将提供该方法的实现
 * @author Leoyork
 */
public interface Node {
    public float interpret();//抽象解释方法interpret（）,在其子类中将提供该方法的实现
}
