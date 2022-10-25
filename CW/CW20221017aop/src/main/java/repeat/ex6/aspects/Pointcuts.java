package repeat.ex6.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* get*(..))")
    public void allGetMethods(){}
}
