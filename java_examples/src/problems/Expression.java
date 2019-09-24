package problems;

import java.io.*;
import java.util.*;

// Java Project Overview, Compilation and Execution
// http://tutorials.jenkov.com/java/java-project-overview-compilation-and-execution.html
// Project structure:
//   1) mkdir src            // create source directory with packages and *.java files
//   2) mkdir classes        // create directory of compiled objects - *.class
//   3) mkdir src/problems   // create package directory 'problems'
// Compilation:
//   4) javac src/problems/*.java -d classes
//   5) If many packages run this command for each package or use tools like Ant, Maven or Gradle.
// Execution:
//   5) java -cp classes problems.Expression "(2+3)*5"
//      where: -cp is a "Class Path" flag
//             "(2+3)*5" is an argument which is passed to main(args) as args[0] parameter

public class Expression {
	public static boolean DEBUG = true;

	public static void main(String[] args){
		String expr = args[0];

		List<String> elems = parseExpr(expr);
		Double res = evaluate(elems);

		System.out.println(expr + " = " + res);
	}

	public static ArrayList<String> parseExpr(String expr){
		String[] sbls = expr.split("");
		ArrayList<String> elems = new ArrayList<>();
		String num = "";
		for(int i=0; i<sbls.length; i++){
    		switch(sbls[i]){
    			case "0":
    			case "1":
    			case "2":
    			case "3":
    			case "4":
    			case "5":
    			case "6":
    			case "7":
    			case "8":
    			case "9":
    			case ".":
    				num += sbls[i];
    			break;
				case "(":
				case ")":
				case "+":
				case "*":
				case "/":
					if(!num.isEmpty()){
						elems.add(num);
						num = "";
					}
					elems.add(sbls[i]);
				break;
				case "-":
					if(num.isEmpty()){
						num += sbls[i];
					} else {
						elems.add(num);
						num = "";
						elems.add(sbls[i]);
					}
				break;
				default:
			}
		}
		if(!num.isEmpty()){
			elems.add(num);
		}
		if(DEBUG){
			System.out.println(elems);
		}
		return elems;
	}

	public static Double evaluate(List<String> elems){
		Stack<Double> nums = new Stack<>();
		Stack<String> ops = new Stack<>();
		for(String val : elems){
			// "(1.3+5.02)*7.23"
    		switch(val){
				case "(":
				break;
				case ")":
					evaluate(nums, ops);
				break;
				case "+":
				case "-":
				case "*":
				case "/":
					evaluate(nums, ops);
					ops.push(val);
				break;
				default:
					nums.push(Double.parseDouble(val));
			}
		}
		evaluate(nums, ops);
		return nums.pop();
	}

	public static void evaluate(Stack<Double> nums, Stack<String> ops){
		while(ops.size()>0 && nums.size()>1){
			Double b = nums.pop();
			Double a = nums.pop();
			nums.push(evaluate(a, b, ops.pop()));
		}
	}

	public static Double evaluate(Double a, Double b, String op){
		Double res = null;
		switch(op){
			case "+":
				res = a + b;
			break;
			case "-":
				res = a - b;
			break;
			case "*":
				res = a * b;
			break;
			case "/":
				res = a / b;
			break;
		}
		if(DEBUG){
			System.out.println(String.format("%f %s %f = %f", a, op, b, res));
		}
		return res;
	}
}
