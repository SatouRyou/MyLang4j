package MyLangJava;

import MyLangJava.Expression.CallOperator;
import MyLangJava.Expression.ExpressionInterface;
import MyLangJava.Expression.ImmediateValue;
import MyLangJava.Expression.SymbolValue;
import MyLangJava.operator.AddOperator;
import MyLangJava.operator.EqualOperator;
import MyLangJava.operator.GetOperator;
import MyLangJava.operator.MultiplyOperator;
import MyLangJava.operator.OperatorInterface;
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

    public Map<String, OperatorInterface> operators = new HashMap<String, OperatorInterface>();
    public Map<String, Object> variables = new HashMap<String, Object>();

    public Engine(){
        operators.put("+", new AddOperator());
        operators.put("*", new MultiplyOperator());
        operators.put("=", new EqualOperator());
        operators.put("set", new SetOperator());
        operators.put("get", new GetOperator());
        operators.put("until", new UntilOperator());
        operators.put("step", new StepOperator());
    }

    public Object eval(Object script){

        return getExpression(script).eval( this );
    }

    private ExpressionInterface getExpression(Object script){
        if (script instanceof List){
            List<?> scriptList = (List<?>)script;
            return new CallOperator(
                    operators.get(scriptList.get(0)),
                    scriptList.subList(1, scriptList.size()));
        }else if (script instanceof String){
            return new SymbolValue((String)script);
        }else{
            return new ImmediateValue(script);
        }
    }
}
