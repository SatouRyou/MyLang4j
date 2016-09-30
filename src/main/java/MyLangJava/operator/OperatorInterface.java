package MyLangJava.operator;

import MyLangJava.Engine;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/09/29.
 */
public interface OperatorInterface {
    public Object call(Engine engine, List<?> args);
}
