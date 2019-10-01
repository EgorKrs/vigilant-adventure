package com.loneless.homevork.task02.logic_and_impl;

public class GeneratorMagic
{
   private int[][] magicSquare;
    public void generateOddMagicSquare(int n) // для не четного квадрата
    {
         magicSquare = new int[n][n];

        //  Находим позицию 1 исходя из размера
        int i = n/2;
        int j = n-1;

        //  заносим допустимые значения в квадрат
        for (int num=1; num <= n*n; )
        {
            if (i==-1 && j==n) //третие условие
            {
                j = n-2;
                i = 0;
            }
            else
            {
                //  первое условие кв. при выходе с за пределы справа

                if (j == n)
                    j = 0;

                // первое условие кв. при выходе с за пределы сверху
                if (i < 0)
                    i=n-1;
            }

            // 2 условие
            if (magicSquare[i][j] != 0)
            {
                j -= 2;
                i++;
                continue;
            }
            else
                magicSquare[i][j] = num++;

            //первое условие
            j++;  i--;
        }
    }
    public void generateEvenMagicSquare(int n) // для чйтного квадрата
    {
        int i, j;
        magicSquare = new int[n][n];
        // заполнение значениями с 1
        for ( i = 0; i < n; i++)
            for ( j = 0; j < n; j++)
                magicSquare[i][j] = (n*i) + j + 1;

        // изменения значений для локализации правила (n*n+1)-magicSquare[i][j]
        // слевого угла матрицы

        for ( i = 0; i < n/4; i++)
            for ( j = 0; j < n/4; j++)
                magicSquare[i][j] = (n*n + 1) - magicSquare[i][j];

        // Правый верхний угол с правилом (n/4)*(n/4)
        for ( i = 0; i < n/4; i++)
            for ( j = 3 * (n/4); j < n; j++)
                magicSquare[i][j] = (n*n + 1) - magicSquare[i][j];

        // левый нижний угол с правилом (n/4)*(n/4)
        for ( i = 3 * n/4; i < n; i++)
            for ( j = 0; j < n/4; j++)
                magicSquare[i][j] = (n*n+1) - magicSquare[i][j];

        // правый верхний угол с правилом (n/4)*(n/4)
        for ( i = 3 * n/4; i < n; i++)
            for ( j = 3 * n/4; j < n; j++)
                magicSquare[i][j] = (n*n + 1) - magicSquare[i][j];

        // центр с правилом (n/2)*(n/2)
        for ( i = n/4; i < 3 * n/4; i++)
            for ( j = n/4; j < 3 * n/4; j++)
                magicSquare[i][j] = (n*n + 1) - magicSquare[i][j];

    }
    public int[][] getMatrix(){
        return magicSquare;
    }
} 