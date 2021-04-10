package com.example.demo.DesignPattern.proxy.staticproxy;

/**
 * 代理对象，静态代理
 */
public class TeacherDaoproxy implements ITeacherDao {
    private ITeacherDao target;//目标对象，通过接口聚合

    public TeacherDaoproxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("开始代理，完成某些操作，比如校验等。。。");
        target.teach();
        System.out.println("提交。。。");

    }
}
