/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_l2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author UCA
 */
public class Ejercicio_L2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner key = new Scanner(System.in);
        Cliente c = new Cliente();
        ArrayList<Producto> prodList = new ArrayList<>();
        System.out.println("******DATOS DEL CLIENTE******");
        ingresoClientes(c, key);
        System.out.println("******DATOS DEL CLIENTE******");
        boolean flag = true;
        do{
            menu();
            int op;
            op = key.nextInt();
            switch(op){
                case 1:
                    key.nextLine();
                    ingresoProductos(key, prodList);
                    break;
                case 2:
                    listarProductos(prodList);
                    break;
                case 3:
                    System.out.println("TOTAL A PAGAR: ");
                    System.out.println(calculoPago(prodList));
                    break;
                case 4:
                    showFactura(prodList, c);
                    break;
                case 5:
                    System.out.println("SALIENDO...");
                    flag = !flag;
                    break;
                default:
                    System.out.println("INGRESE OPCION VALIDA\n");
                    break;
            }
        }while(flag);
    }
    
    public static void ingresoClientes(Cliente c, Scanner x){
        System.out.print("INGRESE NOMBRE DEL CLIENTE: ");
        c.setNombre(x.nextLine());
        System.out.print("INGRESE APELLIDO DEL CLIENTE: ");
        c.setApellido(x.nextLine());
        System.out.print("INGRESE NUMERO DE TELEFONO DEL CLIENTE: ");
        c.setNumeroTelefonico(x.nextLine());
    }
    
    public static void menu(){
        System.out.println("\n---------MENU---------");
        System.out.println("1. INGRESO DE PRODUCTOS.");
        System.out.println("2. LISTAR PRODUCTOS INGRESADOS EN LA COMPRA.");
        System.out.println("3. CALCULAR TOTAL A PAGAR.");
        System.out.println("4. GENERAR FACTURA. ");
        System.out.println("5. SALIR.");
        System.out.println("---------MENU---------");
        System.out.println("INGRESE OPCION: ");
    }
    public static ArrayList<Producto> ingresoProductos(Scanner x, ArrayList prodList){
        Producto prod = new Producto();
        System.out.print("\nINGRESE NOMBRE DEL PRODUCTO: ");
        prod.setNombreProd(x.nextLine());
        System.out.print("INGRESE PRECIO DEL PRODUCTO: ");
        prod.setPrecioProd(x.nextDouble());
        System.out.print("INGRESE CANTIDAD A LLEVAR DEL PRODUCTO: ");
        prod.setCantProd(x.nextInt());
        prodList.add(prod);
        return prodList;
    }
    
    public static void listarProductos(ArrayList<Producto> prodList){
        System.out.println("************* PRODUCTOS ************");
        for (int i = 0; i < prodList.size(); i++) {
            System.out.println("Nombre: " + prodList.get(i).getNombreProd() + " \t Cantidad: " + 
                    prodList.get(i).getCantProd() + " \t Precio: " + prodList.get(i).getPrecioProd());
        }
        System.out.println("************* PRODUCTOS *************\n");
    }
    
    public static double calculoPago(ArrayList<Producto> prodList){
        double total = 0.0;
        for (int i = 0; i < prodList.size(); i++) {
            total = total + (prodList.get(i).getCantProd()*prodList.get(i).getPrecioProd());
        }
        return total;
    }
    
    public static void showFactura(ArrayList<Producto> prodList, Cliente c){
        System.out.println("\n--------------- Factura ----------------");
        System.out.println("|\t\t" + c.getNombre() + " " + c.getApellido() + " \t\t|");
        Date date = new Date();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.print("|\t" + formato.format(date) + "\t\t|\n");    
        for (int i = 0; i < prodList.size(); i++) {
            System.out.println("| " + prodList.get(i).getNombreProd() + " \t" + prodList.get(i).getPrecioProd() + "\t" +prodList.get(i).getCantProd() + "\t" +
                    (prodList.get(i).getPrecioProd()*prodList.get(i).getCantProd()) +"\t|");
        }
        System.out.println("|\t\t\t TOTAL: " + calculoPago(prodList) + "\t|");
        System.out.println("|\t\t" + c.getNumeroTelefonico() + "\t\t|");
        System.out.println("--------------- Factura ----------------");
    }
}
