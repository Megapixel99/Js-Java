package calljs;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.Invocable;

/**
 *
 * @author Seth Wheeler
 */

public class CallJS {

    static Files Files;
    static Paths Paths;
    static StandardCharsets StandardCharsets;

    public static void main(String[] args) {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        // read script file
        try {
            engine.eval(Files.newBufferedReader(Paths.get("C: your file path, Example: C:/Users/Kushan/eclipse-workspace/sureson.lk/src/main/webapp/js/back_end_response.js"), StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Object calculator = engine.get("calculator");
        Invocable inv = (Invocable) engine;
        // call function from script file
        try {
            System.out.println(inv.invokeMethod(calculator, "add", 9, 9).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
