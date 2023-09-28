package com.example.appmetodos_04;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*Al definir variables en el inicio de una clase, hace que esta sea
      global es decir cualquier metodo las puede utilizar
    *Al definir variable dentro de un metodo, hace que estas sean locales
     es decir solo ese metodo las puede usar
    */

    EditText name,weight,height;
    Button calculateIMC;
    TextView resultIMC,classificationIMC;

    /*
    Java funciona por medio de clases, las clases son paquetes de metodos
    es decir en una clase puedo tener desde 1 hasta n metodos

    * OnCreate es el metodo principal de cualquier Activity y es donde
    * se contruye o crea la integración entre el componente de presentación
    * y el componente lógico
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.etName);
        weight= findViewById(R.id.etWeight);
        height=findViewById(R.id.etHeight);
        calculateIMC= findViewById(R.id.btnCalculateIMC);
        resultIMC=findViewById(R.id.tvResult);
        classificationIMC=findViewById(R.id.tvClassificationIMC);

        calculateIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText= name.getText().toString();
                String weightText= weight.getText().toString();
                String heightText= height.getText().toString();
                //String tiene una operación para saber si un texto es vacio
                if(nameText.isEmpty() || weightText.isEmpty() || heightText.isEmpty()){
                    Toast.makeText(getBaseContext(),"Todos los campos deben estar diligenciados",
                            Toast.LENGTH_LONG).show();
                }else{
                    double weightData= Double.parseDouble(weightText);
                    double heightData= (Double.parseDouble(heightText));
                    double imc=calcularIMC(weightData,heightData);
                    message(imc,nameText);
                    classification_IMC(imc);
                }

            }
        });

        /*Variables y constantes
        -Variables nos permiten almacenar un valor de un tipo de dato,
        y en el tiempo podemos modificar el valor o el tipo de dato de la variable
        -Constante es un elemento que nos permite almacenar un dato que no puede ser modificado;
        -Definir variable java:
        1.Tipo de dato -> Nativos: String,char,boolean,byte,short,int,long,float,double
                       -> Otros tipos: Button, EditText, TextView, Intent,ImageView,etc
        2.Nombre ->  Solo caracteres alfanumericos
                 ->  Se permite el uso del _
                 ->  Un nombre no puede inicia con números
                 ->  No se pueden definir nombres de variables que sean iguales
                     a las palabras reservada de java ejemplo: for,if,else,public,private,end,...
                 ->  Los nombres de variables inician en minuscula
        3.Asignar un valor ->  el valor debe ser del mismo tipo de dato de la variable

        Ejemplos: String nombre="Luis";
                  int edad= 30;
                  double estatura= 170;
                  boolean esMayorEdad= true;

        -Definir constante java:
         1.Se coloca la palabra final
         1.Tipo de dato -> Nativos: String,char,boolean,byte,short,int,long,float,double
                       -> Otros tipos: Button, EditText, TextView, Intent,ImageView,etc
        2.Nombre ->  Solo caracteres alfanumericos
                 ->  Se permite el uso del _
                 ->  Un nombre no puede inicia con números
                 ->  No se pueden definir nombres de constantes que sean iguales
                     a las palabras reservada de java ejemplo: for,if,else,public,private,end,...
                 ->  Los nombres de constantes va por completo en mayuscula
        3.Asignar un valor ->  el valor debe ser del mismo tipo de dato de la constante

        ejemplos: final String UNIVERSIDAD="Universidad Nacional de Colombia";
                  final int NIT= 80123464;
        */

      /*Declaración de metodos java:
      * 1. Nivel acceso-> public,protected,private,por defecto que es vacio (no se recomienda usar el por defecto)
      * 2. Tipo de dato-> Nativos: String,char,boolean,byte,short,int,long,float,double
                       -> Otros tipos: Button, EditText, TextView, Intent,ImageView,etc
      * 3. Nombre->  Solo caracteres alfanumericos
                 ->  Se permite el uso del _
                 ->  Un nombre no puede iniciar con números
                 ->  No se pueden definir nombres de metodos que sean iguales
                     a las palabras reservada de java ejemplo: for,if,else,public,private,end,...
                 ->  Los nombres de los metodos se recomienda que inicien en minuscula
      * 4. Parametros-> Son los datos que se requieren para que se solucione el problema en cuestion
      *                 es decir se realice la funcionalid del metodo.
      *              -> Se agregar () y dentro van los parametros
      *              -> Pueden llegar 0 o n parametros, si son varios se separan por ,
      *              -> Cada parametro debe tener su tipo de dato
      * 5. Lógica del metodo-> se agrega {} y lo que se defina dentro es la lógica
      *                        o secuencia de pasos para hallar una solución
      *
      * Tipos de metodos: -> Realiza su lógica y devuelve un resultado del mismo tipo de dato de la función -> return variable del mismo tió de dato del metodo
      *                   -> Realiza su lógica (void)
      *
      * */

    }

    /*Usted debe crear una APP para definir dietas alimencias, se necesita
     que en la app calcule el indice de masa corporal IMC del usuario.
    * */

    //imc= peso/altura^2

   public double calcularIMC(double peso,double estatura){
        double imc= peso/((estatura/100)*(estatura/100));
        return imc;
   }

   // Un metodo que devuelva un saludo
   protected String saludar(){
       return "Bienvenido";
   }

   // Un metodo que dado el IMC y el nombre del usuario genere un mensaje

   private void message(double imc,String nombre){
       //concatenar texto
      // System.out.println("El usuario "+nombre+" tiene un imc de "+imc);
       //Limitar a 2 decimales
       double imcRound= Math.round(imc*100d)/100d;

       resultIMC.setText("El usuario "+nombre+" tiene un imc de "+imcRound);
   }

   protected void classification_IMC(double imc){
       classificationIMC.setGravity(Gravity.CENTER);
       if(imc<18.5){
           classificationIMC.setText("Bajo de peso");
           classificationIMC.setTextColor(Color.YELLOW);
       }else if(imc>=18.5 && imc<25){
           classificationIMC.setText("Peso Normal");
           classificationIMC.setTextColor(Color.GREEN);
       } else if (imc>=25 && imc<30){
           classificationIMC.setText("Sobrepeso");
           classificationIMC.setTextColor(Color.MAGENTA);
       } else if (imc>=30) {
           classificationIMC.setText("Obesidad");
           classificationIMC.setTextColor(Color.RED);
       }else{
           classificationIMC.setText("IMC Incorrecto");
       }
   }








}