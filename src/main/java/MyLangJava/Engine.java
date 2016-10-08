package MyLangJava;

import MyLangJava.Expression.CallOperator;
import MyLangJava.Expression.ExpressionInterface;
import MyLangJava.Expression.ImmediateValue;
import MyLangJava.Expression.SymbolValue;
import MyLangJava.operator.AddOperator;
import MyLangJava.operator.EqualOperator;
import MyLangJava.operator.GetOperator;
import MyLangJava.operator.LambdaOperator;
import MyLangJava.operator.MultiplyOperator;
import MyLangJava.operator.PrintOperator;
import MyLangJava.operator.SetOperator;
import MyLangJava.operator.StepOperator;
import MyLangJava.operator.UntilOperator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by teradashoutarou on 2016/09/29.
 */
public class Engine {

    public Map<String, Object> variables = new HashMap<String, Object>();

    private Engine _super = null;

    public Engine(Engine _super){
        this._super = _super;
    }

    public Engine(){
        variables.put("+", new AddOperator());
        variables.put("*", new MultiplyOperator());
        variables.put("=", new EqualOperator());
        variables.put("set", new SetOperator());
        variables.put("get", new GetOperator());
        variables.put("until", new UntilOperator());
        variables.put("step", new StepOperator());
        variables.put("print", new PrintOperator());
        variables.put("lambda", new LambdaOperator());
    }

    public Object eval(Object script){

        return getExpression(script).eval( this );
    }

    public Object defineVariable(String name, Object value){
        variables.put(name, value);
        return value;
    }

    public Object setVariable(String name, Object value){
        Engine engine = this;
        while(true){
            if (engine.variables.containsKey(name)){
                engine.variables.put(name, value);
                return value;
            }else if (engine._super != null){
                engine = engine._super;
            }else{
                // 変数が見つからなければ、最も外側のスコープに
                // （グローバル変数として）変数を定義する
                return engine.defineVariable(name, value);
            }
        }
    }

    public Object getVariable(String name){
        Engine engine = this;
        while(true){
            if (engine.variables.containsKey(name)){
                return engine.variables.get(name);
            }else if (engine._super != null){
                engine = engine._super;
            }else{
                throw new RuntimeException("Unknown variable:" + name);
            }
        }
    }

    private ExpressionInterface getExpression(Object script){
        if (script instanceof List){
            List<?> scriptList = (List<?>)script;
            return new CallOperator(
                    scriptList.get(0),
                    scriptList.subList(1, scriptList.size()));
        }else if (script instanceof String){
            return new SymbolValue((String)script);
        }else{
            return new ImmediateValue(script);
        }
    }
}
