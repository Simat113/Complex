package com.company;

public class Main {

    public static void main(String[] args) {

        Complex a = new Complex(5, -10); //Создание
        Complex a1 = new Complex(-100, 43);
        Complex a2 = new Complex(a); //Копирование

        System.out.println(a.add(a2)); //Сложение
        System.out.println(a.subtract(a1)); //Вычитание
        System.out.println(a1.multiply(a)); //Умножение
        System.out.println(a1.divide(a)); //Деление

        System.out.println(a.abs()); //Модуль
        System.out.println(a.conjugate()); //Сопряженное число
        System.out.println(a.equals(a, a2)); //Сравнение одинаковых чисел
        System.out.println(a.equals(a, a1)); //Разных
        System.out.println(a.getReal()); //Геттер вещественного
        System.out.println(a1.getImag()); //Мнимого
        System.out.println(a.neg()); //Противоположное
        String test = a.toString(); //Превращение в строку
        System.out.println(test);
        Complex b = new Complex(123, 0);
        System.out.println(b.checkReal()); //Является ли число вещественным
        System.out.println(b.checkImaginary()); //Является ли число мнимым

        Complex[] c = new Complex[3]; //Создание и вывод массива
        c[0] = new Complex(0, 19);
        c[1] = new Complex(12, 19);
        c[2] = c[1].neg();
        System.out.println(c[0] + " | " + c[1] + " | " + c[2]);

    }
}

class Complex {
    double real, imag;

    Complex()
    {

    }

    Complex(double real, double imag)
    {
        this.real = real;
        this.imag = imag;
    }

    Complex(Complex c)
    {
        this.real = c.real;
        this.imag = c.imag;
    }

    public Complex add(Complex c)
    {
        return new Complex(this.real + c.real, this.imag + c.imag);
    }
    public Complex subtract(Complex c)
    {
        return new Complex(this.real - c.real, this.imag - c.imag);
    }
    public Complex multiply(Complex c)
    {
        return new Complex((this.real * c.real) - (this.imag * c.imag), (this.real * this.imag) + (c.real * c.imag));
    }
    public Complex divide(Complex c)
    {
        return new Complex(( this.real *  c.real +  this.imag *  c.imag) / ( c.real *  c.real +  c.imag *  c.imag), ( this.imag *  c.real -  this.real *  c.imag) / ( c.real *  c.real +  c.imag *  c.imag));
    }

    public double abs()
    {
        return Math.sqrt(this.real * this.real + this.imag * this.imag);
    }

    public Complex conjugate(){
        return new Complex(this.real, -this.imag);
    }

    public boolean equals(Complex z1, Complex z2)
    {
        if (z1.real == z2.real && z1.imag == z2.imag)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public Complex neg()
    {
        return new Complex(-this.real, -this.imag);
    }

    public String toString()
    {
        if (this.imag < 0)
        {
            return this.real + " - " + -this.imag;
        }
        else
        {
            return this.real + " + " + this.imag;
        }
    }

    public boolean checkReal()
    {
        if (this.imag == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkImaginary()
    {
        if (this.real == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
