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
import MyLangJava.operator.ProcOperator;
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
