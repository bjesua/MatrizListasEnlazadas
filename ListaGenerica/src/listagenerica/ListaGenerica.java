
package listagenerica;




import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
/**
 *
 * @author bjesua
 */
public class ListaGenerica {
    
    class Nodo {
        int info;        
        Nodo ant, sig, abajo;
    }
    
    private Nodo raiz;
    
    public ListaGenerica () {
        raiz=null;
    }
      
    void insertar (int pos, int x)
    {
        if (pos <= cantidad () + 1)    {
            Nodo nuevo = new Nodo ();
            nuevo.info = x;
            if (pos == 1){
                nuevo.sig = raiz;
                if (raiz!=null)
                    raiz.ant=nuevo;
                raiz = nuevo;
            } else
                if (pos == cantidad () + 1)    {
                    Nodo reco = raiz;
                    while (reco.sig != null) {
                        reco = reco.sig;
                    }
                    reco.sig = nuevo;
                    nuevo.ant=reco;
                    nuevo.sig = null;
                } else {
                    Nodo reco = raiz;
                    for (int f = 1 ; f <= pos - 2 ; f++)
                        reco = reco.sig;
                    Nodo siguiente = reco.sig;
                    reco.sig = nuevo;
                    nuevo.ant=reco;
                    nuevo.sig = siguiente;
                    siguiente.ant=nuevo;
                }
        }
    }

    public int extraer (int pos) {
        if (pos <= cantidad ())    {
            int informacion;
            if (pos == 1) {
                informacion = raiz.info;
                raiz = raiz.sig;
                if (raiz!=null)
                    raiz.ant=null;
            } else {
                Nodo reco;
                reco = raiz;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    reco = reco.sig;
                Nodo prox = reco.sig;
                reco.sig = prox.sig;
                Nodo siguiente=prox.sig;
                if (siguiente!=null)
                    siguiente.ant=reco;
                informacion = prox.info;
            }
            return informacion;
        }
        else
            return Integer.MAX_VALUE;
    }

    public void borrar (int pos)
    {
        if (pos <= cantidad ())    {
            if (pos == 1) {
                raiz = raiz.sig;
                if (raiz!=null)
                    raiz.ant=null;
            } else {
                Nodo reco;
                reco = raiz;
                for (int f = 1 ; f <= pos - 2 ; f++)
                    reco = reco.sig;
                Nodo prox = reco.sig;
                prox=prox.sig;
                reco.sig = prox;
                if (prox!=null)
                    prox.ant=reco;
            }
        }
    }
    
    public void intercambiar (int pos1, int pos2) {
        if (pos1 <= cantidad () && pos2 <= cantidad ())    {
            Nodo reco1 = raiz;
            for (int f = 1 ; f < pos1 ; f++)
                reco1 = reco1.sig;
            Nodo reco2 = raiz;
            for (int f = 1 ; f < pos2 ; f++)
                reco2 = reco2.sig;
            int aux = reco1.info;
            reco1.info = reco2.info;
            reco2.info = aux;
        }
    }
    
    public int mayor () {
        if (!vacia ()) {
            int may = raiz.info;
            Nodo reco = raiz.sig;
            while (reco != null) {
                if (reco.info > may)
                    may = reco.info;
                reco = reco.sig;
            }
            return may;
        }
        else
            return Integer.MAX_VALUE;
    }
    
    public int posMayor() {
        if (!vacia ())    {
            int may = raiz.info;
            int x=1;
            int pos=x;
            Nodo reco = raiz.sig;
            while (reco != null){
                if (reco.info > may) {
                    may = reco.info;
                    pos=x;
                }
                reco = reco.sig;
                x++;
            }
            return pos;
        }
        else
            return Integer.MAX_VALUE;
    }

    public int cantidad ()
    {
        int cant = 0;
        Nodo reco = raiz;
        while (reco != null) {
            reco = reco.sig;
            cant++;
        }
        return cant;
    }
    
    public boolean ordenada() {
        if (cantidad()>1) {
            Nodo reco1=raiz;
            Nodo reco2=raiz.sig;
            while (reco2!=null) {
                if (reco2.info<reco1.info) {
                    return false;
                }
                reco2=reco2.sig;
                reco1=reco1.sig;
            }
        }
        return true;
    }
    
    public boolean existe(int x) {
        Nodo reco=raiz;
        while (reco!=null) {
            if (reco.info==x)
                return true;
            reco=reco.sig;
        }
        return false;
    }
    
    public boolean vacia ()
    {
        if (raiz == null)
            return true;
        else
            return false;
    }
    
    public void imprimir (int x,int y)
    {      
        Nodo reco = raiz;     
        int a=1;
        while (reco != null) {           
            if(a>=1 && a<= x){
                System.out.print (reco.info + "->");
            }else{ 
                System.out.print ("\n|\n");
                System.out.print (reco.info + "->");
                a = 1;
                for(int i = 1; i<=x-1;i++){//                                     
                    System.out.print("");
                }
                a = 1;                
            }            
            reco = reco.sig;            
            a++;
        }
            

        System.out.println();
    }
        
    public static void main(String[] ar) {
        ListaGenerica lg=new ListaGenerica();
//        lg.insertar (1, 10);
//        lg.insertar (2, 20);
//        lg.insertar (3, 30);
//        lg.insertar (2, 15);
//        lg.insertar (1, 115);
//        lg.imprimir ();
//        System.out.println ("Luego de Borrar el primero");
//        lg.borrar (1);
//        lg.imprimir ();
//        System.out.println ("Luego de Extraer el segundo");
//        lg.extraer (2);
//        lg.imprimir ();
//        System.out.println ("Luego de Intercambiar el primero con el tercero");
//        lg.intercambiar (1, 3);
//        lg.imprimir ();
//        if (lg.existe(10)) 
//            System.out.println("Se encuentra el 20 en la lista");
//        else
//            System.out.println("No se encuentra el 20 en la lista");
//        System.out.println("La posición del mayor es:"+lg.posMayor());
//        if (lg.ordenada())
//            System.out.println("La lista está ordenada de menor a mayor");
//        else
//            System.out.println("La lista no está ordenada de menor a mayor");            
//    
                       
        Scanner entrda1 = new Scanner(System.in);
        System.out.println("\nNombre Archivo 1\n");
         String archivo1 = entrda1.nextLine(); 
         System.out.println("\nNombre Archivo 1\n");
         String archivo2 = entrda1.nextLine(); 
        
            File file = new File("/Users/bjesua/Desktop/archivos-Progra2/"+archivo1+".txt");
            File file2 = new File("/Users/bjesua/Desktop/archivos-Progra2/"+archivo2+".txt");
        
            System.out.println("\n");
//        File file = new File("/Users/bjesua/Desktop/archivos-Progra2/progra2ArchivoEntrada.txt");
//        File file2 = new File("/Users/bjesua/Desktop/archivos-Progra2/progra2ArchivoEntrada2.txt");

        Scanner sc = null;
        Scanner sc2 = null;
        try {
            sc = new Scanner(file);
            sc2 = new Scanner(file2);
        } catch (FileNotFoundException ex) {
//            Logger.getLogger(AppMatrizDipsersaLLF1.class.getName()).log(Level.SEVERE, null, ex);
        }
        String caracter = sc.nextLine();      
        String caracter2 = sc2.nextLine();      
        String[] parts = caracter.split(" ");
        String[] parts2 = caracter2.split(" ");
        int valx = Integer.parseInt(parts[0]);			
        int valy = Integer.parseInt(parts[1]);
        String m1 = valx + " x " + valy;
        System.out.println(m1);
        int val2x = Integer.parseInt(parts2[0]);			
        int val2y = Integer.parseInt(parts2[1]);
        String m2 = val2x + " x " + val2y;
        System.out.println(m2);
        
        if(!m1.equals(m2)){
            System.out.println("No son matrices iguales.");
            return ;
        }
//        System.out.println(sc.nextLine());
        
//        while(sc.hasNextLine()){
//            System.out.println(sc.nextLine());
//        }
        
        
//        Random r = new Random();
        int matriz[][] = new int[valx][valy];
        int matriz2[][] = new int[val2x][val2y];
        
        System.out.println("\n\nMatriz 1");
        int a=1;
        for (int i = 0; i < valx; i++) {
//            System.out.println("");
            if(i>0){
//                System.out.println("|");
            }           
            for (int j = 0; j < valy; j++) {
                matriz[i][j] = Integer.parseInt(sc.nextLine());              
//                System.out.print(matriz[i][j] + "->");
                lg.insertar(a, matriz[i][j]);
                a=a+1;
            }
        }
                       
        System.out.println("\n");
        lg.imprimir (valx,valy);
               
        ListaGenerica lg2 =new ListaGenerica();
        
        int b=1;
        for (int i = 0; i < val2x; i++) {
//            System.out.println("");
            if(i>0){
//                System.out.println("|");
            }           
            for (int j = 0; j < val2y; j++) {
                matriz2[i][j] = Integer.parseInt(sc2.nextLine());              
//                System.out.print(matriz[i][j] + "->");
                lg2.insertar(b, matriz2[i][j]);
                b=b+1;
            }
        }
        
        System.out.println("\n\nMatriz 2\n\n");
        lg2.imprimir (valx,valy);
        
        
        Operaciones op = new Operaciones();
        
        //operaciones sumar       
        System.out.println("\n\n Sumar \n\n");                
        ListaGenerica lg3 =new ListaGenerica();
        int matriz3[][] = new int[val2x][val2y];
        int c=1;
        for (int i = 0; i < val2x; i++) {
//            System.out.println("");
            if(i>0){
//                System.out.println("|");
            }           
            for (int j = 0; j < val2y; j++) {
                matriz3[i][j] = op.suma(matriz[i][j],matriz2[i][j]);              
//                System.out.println(matriz[i][j]+" + "+matriz2[i][j]);
                lg3.insertar(c, matriz3[i][j]);
                c=c+1;
            }
        }               
        lg3.imprimir (valx,valy);
        
        //operaciones restar       
        System.out.println("\n\n Restar \n\n");                
        ListaGenerica lg4 =new ListaGenerica();
        int matriz4[][] = new int[val2x][val2y];
        int d=1;
        for (int i = 0; i < val2x; i++) {
//            System.out.println("");
            if(i>0){
//                System.out.println("|");
            }           
            for (int j = 0; j < val2y; j++) {
                matriz4[i][j] = op.resta(matriz[i][j],matriz2[i][j]);              
//                System.out.println(matriz[i][j]+" + "+matriz2[i][j]);
                lg4.insertar(d, matriz4[i][j]);
                d=d+1;
            }
        }              
        lg4.imprimir (valx,valy);
        
        
        //operaciones Multiplicacion       
        System.out.println("\n\n Multiplicacion \n\n");                
        ListaGenerica lg5 =new ListaGenerica();
        int matriz5[][] = new int[val2x][val2y];
        int e=1;
        for (int i = 0; i < val2x; i++) {
//            System.out.println("");
            if(i>0){
//                System.out.println("|");
            }           
            for (int j = 0; j < val2y; j++) {
                matriz5[i][j] = op.multiplicacion(matriz[i][j],matriz2[i][j]);              
//                System.out.println(matriz[i][j]+" + "+matriz2[i][j]);
                lg5.insertar(e, matriz5[i][j]);
                e=e+1;
            }
        }       
        
        lg5.imprimir (valx,valy);
        
        
        
        System.out.print("Introduzca un número entero: ");
        Scanner sca = new Scanner(System.in);
        int n = sca.nextInt();

        //operaciones Escalar matriz 1       
        System.out.println("\n\n Escalar Matriz 1 \n\n");                
        ListaGenerica lg6 =new ListaGenerica();
        int matriz6[][] = new int[valx][valy];
        int f=1;
        for (int i = 0; i < valx; i++) {
//            System.out.println("");
            if(i>0){
//                System.out.println("|");
            }           
            for (int j = 0; j < valy; j++) {
                matriz6[i][j] = op.escalar(matriz[i][j],n);              
//                System.out.println(matriz[i][j]+" + "+matriz2[i][j]);
                lg6.insertar(f, matriz6[i][j]);
                f=f+1;
            }
        }               
        lg6.imprimir (valx,valy);
        
        System.out.print("Introduzca un número entero: ");
        Scanner sca2 = new Scanner(System.in);
        int n2 = sca2.nextInt();

        //operaciones Escalar matriz 1       
        System.out.println("\n\n Escalar Matriz 2 \n\n");                
        ListaGenerica lg7 =new ListaGenerica();
        int matriz7[][] = new int[val2x][val2y];
        int g=1;
        for (int i = 0; i < val2x; i++) {
//            System.out.println("");
            if(i>0){
//                System.out.println("|");
            }           
            for (int j = 0; j < val2y; j++) {
                matriz7[i][j] = op.escalar(matriz2[i][j],n);              
//                System.out.println(matriz[i][j]+" + "+matriz2[i][j]);
                lg7.insertar(g, matriz6[i][j]);
               g =g+1;
            }
        }               
        lg7.imprimir (val2x,val2y);
                       
    }
}