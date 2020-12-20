using System;
using System.Globalization;
using System.IO;
using System.Runtime.Serialization.Formatters;
using System.Threading;

namespace LR_Five
{
    class Program
    {
        static void Main(string[] args)
        {
            // Вариант 4

            int N, M;
            string FileName;

            Console.Write("Введите целое число N: ");
            N = Convert.ToInt32(Console.ReadLine());
            Console.Write("Введите целое число M: ");
            M = Convert.ToInt32(Console.ReadLine());
            Console.Write("Введите имя текстового файла (без расширения .txt): ");
            FileName = Console.ReadLine();
            FileName += ".txt";

            TextWriter save_out = Console.Out;
            var new_out = new StreamWriter(FileName);
            Console.SetOut(new_out);

            Console.WriteLine(N);
            Console.WriteLine(M);

            Random r = new Random(DateTime.Now.Millisecond);
            int x = 0;
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    x = r.Next(-1000, 1001);
                    Console.Write(x + " ");
                }
                Console.WriteLine();
            }

            Console.SetOut(save_out); new_out.Close();

            TextWriter save_out1 = Console.Out;
            TextReader save_in = Console.In;
            var new_out1 = new StreamWriter(@"output.txt");
            var new_in = new StreamReader(FileName);
            Console.SetOut(new_out1);
            Console.SetIn(new_in);

            int N1 = Convert.ToInt32(Console.ReadLine());
            int M1 = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("*** Ввод матрицы ***");

            // Ввод данных из исходной матрицы
            int[,] mas = new int[N1, M1];
            for (int i = 0; i < N1; i++)
            {
                String str_all = Console.ReadLine();
                string[] str_elem = str_all.Split(' ');
                for (int j = 0; j < M1; j++)
                {
                    mas[i, j] = Convert.ToInt32(str_elem[j]);
                    Console.Write(mas[i, j] + " ");
                }
                Console.WriteLine();
            }
            Console.WriteLine();


            Console.WriteLine("***Отрицательный максимум для каждого столбца***");
            int max = 0;
            float sa = 0;
            for (int i = 0; i < N1; i++)
            {
                max = 0;
                for (int j = 0; j < M1; j++)
                {
                    if (mas[i, j] < max)
                    {
                        max = mas[i, j];
                    }
                }
                Console.WriteLine(max);
            }
            Console.WriteLine();


            Console.WriteLine("***Модифицированная матрица***");
            for (int i = 0; i < N1; i++)
            {
                for (int j = 0; j < M1; j++)
                {
                    if (mas[i, j] % x == 0)
                        Console.Write("x ");
                    else if (mas[i, j] % y == 0)
                        Console.Write("y ");
                    else
                        Console.Write("0 ");
                }
                Console.WriteLine();
            }

            Console.SetOut(save_out1); new_out1.Close();
            Console.SetIn(save_in); new_in.Close();
        }
    }
}