
package pkg1programacao;


public class Revisao {

    public static void main(String[] args) {
       //laço de repetição FOR -> Tabuada
        int tabuada = 6;
        for(int i = 0; i <= 10; i++){
            System.out.println(tabuada + "x" + i + " = " + (tabuada * i) );
        }
        
        //WHILE = Enquanto
        int contador = 0;
        while(contador < 100){
            System.out.println("WHILE Contador é menor que 100 (" + contador + ")");
            contador+=3; //contador = contador + 1;
        }
        System.out.println("TERMINOU O WHILE");
        
        //DO WHILE -> Verificar um contador
        do{
            System.out.println("DO Contador é menor que 100 (" + contador + ")");
            contador+=3;
        }while(contador < 100);
        System.out.println("TERMINOU O DO WHILE");
        
        //Criar uma função de soma
        double a = 5.4;
        double b = 6;
        soma(a, b);
        
    }
    
    private static void soma(double num1, double num2){
        System.out.println("SOMA = " + (num1 + num2));
    }
    
}