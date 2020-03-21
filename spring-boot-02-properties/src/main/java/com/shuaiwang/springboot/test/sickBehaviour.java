package com.shuaiwang.springboot.test;

/**最终目的
 * ********************
 * 为什么要面向接口编程
 * *********************
 */

public interface sickBehaviour {
    /**问题 1
     * 测试不同函数接口怎么写（重载）
     * 重载：方法重载就是方法名称重复，加载参数不同。
     * 注意：返回值不同不算重载
     * @return
     */
    String eat();

    String eat(int p1);

    boolean eat(int p1, boolean p2);
    /**发现
     * 接口可以设置默认值
     *     default String eat() {
     *         return null;
     *     }
     *
     *     default int eat(int p1) {
     *         return 0;
     *     }
     */
    int sleep();
    void play();
    /**问题2
     * 测试同一个包下不同的实现，在客户端的调用
     * 猜想：面向接口编程的话，少不了多态；应该是根据创建哪个对象就用哪个方法
     * 验证方式：写三个实现类，在客户端分别调用其中一个方法即可
     */
    /**发现
     * 除非接口返回值是void，否则自动实现接口后，实现类的方法默认会按照接口方法的返回值类型去写return
     */
}
