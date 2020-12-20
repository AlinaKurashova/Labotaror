using System;
using System.Linq;
using System.IO;
 
namespace laba10
{
    class Program
    {
        //Считывает размер матрицы из файла
        public static int GetMatrixSize(string fileWithMatrix)
        {
            string[] arr = File.ReadAllLines(fileWithMatrix);
 
            return Convert.ToInt32(arr[0]);
        }
 
        //Считивает матрицу из файла
        public static int[,] MyMatrix(string fileWithMatrix, int size)
        {
            string[] arr = File.ReadAllLines(fileWithMatrix);
            
            int[,] matrix = new int[size, size];
 
            for (int i = 0; i < size; i++)
            {
                var tmp = arr[i + 1].Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToArray();
 
                for (int j = 0; j < tmp.Length; j++)
                    matrix[i, j] = tmp[j];
            }
 
            return matrix;
        }
 
        //Выводит матрицу на экран
        public static void DisplayMatrix(int[,] matrix, int size, string fileWithMatrix)
        {
            Console.WriteLine("Матрица из файла {0}: ", fileWithMatrix);
            for (int i = 0; i < size; i++)
            {
                for (int j = 0; j < size; j++)
                {
                    Console.Write(matrix[i, j] + " ");
                }
                Console.WriteLine();
            }
        }
 
        //Считает сумму элементов, где сумма индексов четная
        public static int CalculateSum(int[,] matrix, int size)
        {
            int sum = 0;
            for(int i=0; i<size; i++)
                for (int j = 0; j < size; j++)
                    sum += (i + j)%2 == 0 ? matrix[i, j] : 0;
            return sum;
        }
        static void Main(string[] args)
        {
            int n=GetMatrixSize("D:/MatrixA.txt");
            int[,] matrixA=new int[n,n];
            Array.Copy(MyMatrix("D:/MatrixA.txt", n), matrixA, n*n);
            DisplayMatrix(matrixA, n, "D:/MatrixA.txt");
            Console.WriteLine("Сумма элементов, где есть четная сумма индексов, равна: " + CalculateSum(matrixA, n));
            Console.WriteLine();
            
 
            int m = GetMatrixSize("D:/MatrixB.txt");
            int[,] matrixB = new int[m, m];
            Array.Copy(MyMatrix("D:/MatrixB.txt", m), matrixB, m*m);
            DisplayMatrix(matrixB, m, "D:/MatrixB.txt");
            Console.WriteLine("Сумма элементов, где четная сумма индексов, равна: " + CalculateSum(matrixB, m));
 
            Console.ReadKey();
        }
 
    }
}