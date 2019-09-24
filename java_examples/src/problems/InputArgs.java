package problems;

public class InputArgs {
	public static void main(String[] args){
		if(args.length>0){
			System.out.println("Input agrs:");
		}
		for(int i=0; i<args.length; i++){
			System.out.println(String.format("\t%s", args[i]));
		}
	}
}
