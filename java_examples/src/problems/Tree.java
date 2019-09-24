package problems;

import java.io.*;
import java.util.*;

public class Tree {
	public static void main(String[] args) {
		// Tree t = new Tree("+", null);
		// t.left = new Tree(null, 12.);
		// t.right = new Tree(null, 33.);

		System.out.println("Tree");
		//t.print();
		System.out.println();
	}

	public enum Operation {
		ADD,
		SUB,
		MUL,
		DIV
	}

	public Operation op = null;
	public Double val = null;
	public Tree left = null;
	public Tree right = null;

	// Constructor
	public Tree(String op, Double val) {
		if(op != null){
			this.op = strToOp(op);
		}
		this.val = val;
	}

	public static Operation strToOp(String opStr) {
		Operation op = null;
		switch(opStr) {
			case "+":
				op = Operation.ADD;
			break;
			case "-":
				op = Operation.SUB;
			break;
			case "*":
				op = Operation.MUL;
			break;
			case "/":
				op = Operation.DIV;
			break;
		}
		return op;		
	}

	public static String opToStr(Operation op) {
		String opStr = "";
		switch(op) {
			case ADD:
				opStr = "+";
			break;
			case SUB:
				opStr = "-";
			break;
			case MUL:
				opStr = "*";
			break;
			case DIV:
				opStr = "/";
			break;
			default:
				opStr = "";
		}
		return opStr;
	}

	public void build(List<String> elems) {
		for(String e : elems){
			
		}
	}

	public void print(){
		if(this.val != null){
			System.out.print(String.format("%f", this.val));
		} else {
			System.out.print("(");
			if(this.left != null){
				this.left.print();
			}
			System.out.print(String.format(" %s ", opToStr(this.op)));
			if(this.right != null){
				this.right.print();
			}
			System.out.print(")");
		}
	}
}