import java.util.Scanner;

  

public class Main
{
	
	 public static boolean comparacion(String op) {

        char sp[] = op.toCharArray();
        boolean full = true;
        int x = sp.length / 2;
        double y = sp.length / 2;

        if ((double) x == y && (sp[0] != ')' && sp[sp.length - 1] != '(')) {
            for (int i = 0; i < sp.length - 1; i++) {
                if (sp[i] == '(') {
                    int h = i + 1;
                    while (sp[i] != 't' && h < sp.length) {
                        if (sp[h] == ')') {
                            sp[h] = 't';
                            sp[i] = 't';
                        }
                        h++;

                    }
                }
            }
        }
        for (int j = 0; j < sp.length; j++) {
            if (sp[j] != 't') {
                return false;
            }
        }

        return full;
    }
	
	public static void main (String[] args) throws java.lang.Exception
	{
	
	
        try {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ps = new String[n];
        for (int i = 0; i < n; i++) {
            ps[i] = sc.next();
        }
        for (int k = 0; k < ps.length; k++) {
            if (comparacion(ps[k]) != true) {
                System.out.println("INCORRECTO");
            } else {
                System.out.println("CORRECTO");
            }
        }
        }catch (Exception e) {
            System.out.println("Error");
        }
    
	
		
	}
}