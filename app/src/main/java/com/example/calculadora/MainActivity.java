package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.TypedArrayUtils;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import org.apache.commons.lang3.ArrayUtils;


public class MainActivity extends AppCompatActivity {

    Stack<String> pila = new Stack<>();
    String resultado = "";
    String resultado2 = "";

    Button buttonSuma;
    Button buttonMultiplicacion;
    Button buttonIgual;
    Button buttonResta;
    Button buttonDivision;
    Button buttonBorrarTodo;
    Button buttonBorrarUltimo;
    Button buttonPunto;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    TextView textViewResultado;
//bool para agregar numeros decimales

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonSuma = (Button)findViewById(R.id.buttonSuma);
        buttonMultiplicacion = (Button) findViewById(R.id.buttonMultiplicacion);
        buttonIgual = (Button) findViewById(R.id.buttonIgual);
        buttonResta = (Button) findViewById(R.id.buttonResta);
        buttonDivision = (Button) findViewById(R.id.buttonDivision);
        buttonBorrarTodo = (Button) findViewById(R.id.buttonBorrarTodo);
        buttonBorrarUltimo = (Button) findViewById(R.id.buttonBorrarUltimo);
        buttonPunto = (Button) findViewById(R.id.buttonPunto);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);
        textViewResultado = (TextView) findViewById(R.id.textViewResultado);
        textViewResultado.setText("");



        buttonSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(resultado.equals("")){
                    resultado = resultado + '+';
                    textViewResultado.setText(resultado);
                }
                else{
                    StringBuffer sb = new StringBuffer(resultado);
                    if(sb.charAt(sb.length()-1) == '/' ||sb.charAt(sb.length()-1) == '*'
                            ||sb.charAt(sb.length()-1) == '.'){
                        //No hacer nada
                    }
                    else{
                        resultado = resultado + '+';
                        textViewResultado.setText(resultado);

                    }
                }


            }
        });
        buttonResta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resultado.equals("")){
                    resultado = resultado + '-';
                    textViewResultado.setText(resultado);
                }
                else{
                    StringBuffer sb = new StringBuffer(resultado);
                    if(sb.charAt(sb.length()-1) == '.'){
                        //No hacer nada
                    }
                    else{
                        resultado = resultado + '-';
                        textViewResultado.setText(resultado);

                    }
                }

            }
        });
        buttonMultiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resultado.equals("")){

                }
                else{
                    StringBuffer sb = new StringBuffer(resultado);
                    if(sb.charAt(sb.length()-1) == '+' ||sb.charAt(sb.length()-1) == '-'
                            ||sb.charAt(sb.length()-1) == '/' ||sb.charAt(sb.length()-1) == '*'
                            ||sb.charAt(sb.length()-1) == '.'){
                        //No hacer nada
                    }
                    else{
                        resultado = resultado + '*';
                        textViewResultado.setText(resultado);

                    }
                }
            }
        });
        buttonIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resultado.equals("")){

                }
                else{
                    int tam = 0;
                    int i3 = 0;
                    String[] arr = resultado.split("\\+|-|\\*|/",1000);
                    for(int i = 0; i < resultado.length(); i++){
                        if(resultado.charAt(i) == '+'||resultado.charAt(i) == '-'||
                                resultado.charAt(i) == '/'||resultado.charAt(i) == '*'){
                            tam = tam + 1;
                        }
                    }
                    String[] arr2 = new String[tam];
                    for(int i = 0; i < resultado.length(); i++){
                        if(resultado.charAt(i) == '+'||resultado.charAt(i) == '-'||
                                resultado.charAt(i) == '/'||resultado.charAt(i) == '*'){
                            arr2[i3] = String.valueOf(resultado.charAt(i));
                            i3 =i3+1;
                        }
                    }
                    int i1 = 0;
                    int i2 = 0;
                    String[] Arr = new String[arr.length -1];
                    if(resultado.charAt(0) == '+' || resultado.charAt(0) == '-'){
                        for(int i = 0; i < Arr.length; i++){
                            Arr[i] = arr[i+1];
                        }
                        int size = Arr.length + arr2.length;
                        String[] arr3 = new String[size];

                        for(int i = 0; i < arr3.length; i++){
                            if(i == 0) {
                                arr3[i] = arr2[i1];
                                i1 = i1 + 1;
                            }
                            else if(i % 2 == 0){
                                arr3[i] = arr2[i1];
                                i1 = i1 + 1;
                            }
                            else{
                                arr3[i] = Arr[i2];
                                i2 = i2 + 1;
                            }
                        }
                    }
                    else{
                        int size = arr.length + arr2.length;
                        String[] arr3 = new String[size];
                        for(int i = 0; i < arr3.length; i++){
                            if(i % 2 == 0) {
                                arr3[i] = arr[i1];
                                i1 = i1 + 1;
                            }
                            else{
                                arr3[i] = arr2[i2];
                                i2 = i2 + 1;
                            }
                        }
                        calcula(arr3);
                    }

                }









            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resultado.equals("")){

                }
                else{
                    StringBuffer sb = new StringBuffer(resultado);
                    if(sb.charAt(sb.length()-1) == '+'||
                            sb.charAt(sb.length()-1) == '+' ||sb.charAt(sb.length()-1) == '/'
                            ||sb.charAt(sb.length()-1) == '*'
                            ||sb.charAt(sb.length()-1) == '.'){
                        //No hacer nada
                    }
                    else {
                        resultado = resultado + '/';
                        textViewResultado.setText(resultado);

                    }
                }
            }
        });
        buttonBorrarTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado = "";
                textViewResultado.setText("");

            }
        });
        buttonBorrarUltimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textViewResultado.getText().equals(""))
                {

                }
                else{
                    StringBuffer sb = new StringBuffer(textViewResultado.getText());
                    sb.deleteCharAt(sb.length()-1);
                    resultado = sb.toString();
                    textViewResultado.setText(resultado);
                }

            }
        });
        buttonPunto.setOnClickListener(new View.OnClickListener() {

            int cont1 = 0;
            int cont2 = 0;
            @Override
            public void onClick(View view) {////////
                if(resultado.contains(".")){
                    String[] arr = resultado.split("\\+|-|\\*|/",1000);//por mientras asi
                    if(arr[arr.length-1].contains(".")){

                    }
                    else{
                        resultado = resultado + '.';
                        textViewResultado.setText(resultado);
                    }
                }
                else{
                    resultado = resultado + '.';
                    textViewResultado.setText(resultado);
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado = resultado + '1';
                textViewResultado.setText(resultado);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado = resultado + '2';
                textViewResultado.setText(resultado);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado = resultado + '3';
                textViewResultado.setText(resultado);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado = resultado + '4';
                textViewResultado.setText(resultado);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado = resultado + '5';
                textViewResultado.setText(resultado);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado = resultado + '6';
                textViewResultado.setText(resultado);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado = resultado + '7';
                textViewResultado.setText(resultado);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado = resultado + '8';
                textViewResultado.setText(resultado);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado = resultado + '9';
                textViewResultado.setText(resultado);
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado = resultado + '0';
                textViewResultado.setText(resultado);
            }
        });

    }

    private void calcula(String[] arr){
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(Arrays.asList(arr));
        String s="";

        int a = list.size();



        for(int i = 0; i < a; i++){
            if(arr[i].equals("-")){
                if(arr[i+1].equals("-")) {
                    //arr[i] = "+";
                    //arr = ArrayUtils.remove(arr,i + 1);
                    //a = a - 1;
                   // i = 0;
                }
                else if(arr[i+1].matches(".*\\d.*")){
                    arr[i] = "-" + arr[i+1];
                    arr = ArrayUtils.remove(arr,i + 1);
                    a = a - 1;
                    i = 0;
                }
            }
        }
       // textViewResultado.setText(arr[1]);

        for(int i = 0; i < a; i++){
            if(arr[i].equals("*")){
                float x = Float.parseFloat(arr[i-1]);
                float y = Float.parseFloat(arr[i+1]);
                float z = x * y;
                s = Float.toString(z);
                arr[i-1] = s;
                arr = ArrayUtils.remove(arr,i);
                arr = ArrayUtils.remove(arr,i);
                a = a - 2;
                i = 0;
            }
        }
        for(int i = 0; i < a; i++){
            if(arr[i].equals("/")){
                float x = Float.parseFloat(arr[i-1]);
                float y = Float.parseFloat(arr[i+1]);
                float z = x / y;
                s = Float.toString(z);
                arr[i-1] = s;
                arr = ArrayUtils.remove(arr,i);
                arr = ArrayUtils.remove(arr,i);
                a = a - 2;
                i = 0;
            }
        }
        for(int i = 0; i < a; i++){
            if(arr[i].equals("+")){
                float x = Float.parseFloat(arr[i-1]);
                float y = Float.parseFloat(arr[i+1]);
                float z = x + y;
                s = Float.toString(z);
                arr[i-1] = s;
                arr = ArrayUtils.remove(arr,i);
                arr = ArrayUtils.remove(arr,i);
                a = a - 2;
                i = 0;
            }
        }
        for(int i = 0; i < a; i++){
            if(arr[i].contains("-")){
                float x = Float.parseFloat(arr[i]);
                float y = Float.parseFloat(arr[i-1]);
                float z = x + y;
                s = Float.toString(z);
                arr[i-1] = s;
                arr = ArrayUtils.remove(arr,i);
                a = a - 1;
                i = 0;
            }
        }



        String res = String.join("",arr);

        textViewResultado.setText(res);
        resultado = "";
    }


} 