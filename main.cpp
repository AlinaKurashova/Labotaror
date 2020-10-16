#include <iostream>
#include <time.h>
#include <stdio.h>
#include <math.h>

using namespace std;

struct Data {
    int i, j;
};

// Создание массива
void CreateMas(Data ***Array, int n, int m) {
    *Array = new Data *[n];
    for (int i = 0; i < n; i++) {
        (*Array)[i] = new Data[m];
    }
    
}

// Формируем покрытие для шахматной доски
Data **InizArray(Data **Array, int n, int m) {
    // Простейшее покрытие в виде кластеров 4x4
/*
   Array[0][0].i = 0; Array[0][0].j = 0; Array[0][1].i = 0; Array[0][1].j = 1;
   Array[0][2].i = 1; Array[0][2].j = 0; Array[0][3].i = 1; Array[0][3].j = 1;
   
   Array[1][0].i = 0; Array[1][0].j = 2; Array[1][1].i = 0; Array[1][1].j = 3;
   Array[1][2].i = 1; Array[1][2].j = 2; Array[1][3].i = 1; Array[1][3].j = 3;
   
   Array[2][0].i = 0; Array[2][0].j = 4; Array[2][1].i = 0; Array[2][1].j = 5;
   Array[2][2].i = 1; Array[2][2].j = 4; Array[2][3].i = 1; Array[2][3].j = 5;
   
   Array[3][0].i = 0; Array[3][0].j = 6; Array[3][1].i = 0; Array[3][1].j = 7;
   Array[3][2].i = 1; Array[3][2].j = 6; Array[3][3].i = 1; Array[3][3].j = 7;
   
   Array[4][0].i = 2; Array[4][0].j = 0; Array[4][1].i = 2; Array[4][1].j = 1;
   Array[4][2].i = 3; Array[4][2].j = 0; Array[4][3].i = 3; Array[4][3].j = 1;
   
   Array[5][0].i = 2; Array[5][0].j = 2; Array[5][1].i = 2; Array[5][1].j = 3;
   Array[5][2].i = 3; Array[5][2].j = 2; Array[5][3].i = 3; Array[5][3].j = 3;
   
   Array[6][0].i = 2; Array[6][0].j = 4; Array[6][1].i = 2; Array[6][1].j = 5;
   Array[6][2].i = 3; Array[6][2].j = 4; Array[6][3].i = 3; Array[6][3].j = 5;
   
   Array[7][0].i = 2; Array[7][0].j = 6; Array[7][1].i = 2; Array[7][1].j = 7;
   Array[7][2].i = 3; Array[7][2].j = 6; Array[7][3].i = 3; Array[7][3].j = 7;
   
   Array[8][0].i = 4; Array[8][0].j = 0; Array[8][1].i = 4; Array[8][1].j = 1;
   Array[8][2].i = 5; Array[8][2].j = 0; Array[8][3].i = 5; Array[8][3].j = 1;
   
   Array[9][0].i = 4; Array[9][0].j = 2; Array[9][1].i = 4; Array[9][1].j = 3;
   Array[9][2].i = 5; Array[9][2].j = 2; Array[9][3].i = 5; Array[9][3].j = 3;
   
   Array[10][0].i = 4; Array[10][0].j = 4; Array[10][1].i = 4; Array[10][1].j = 5;
   Array[10][2].i = 5; Array[10][2].j = 4; Array[10][3].i = 5; Array[10][3].j = 5;
   
   Array[11][0].i = 4; Array[11][0].j = 6; Array[11][1].i = 4; Array[11][1].j = 7;
   Array[11][2].i = 5; Array[11][2].j = 6; Array[11][3].i = 5; Array[11][3].j = 7;
   
   Array[12][0].i = 6; Array[12][0].j = 0; Array[12][1].i = 6; Array[12][1].j = 1;
   Array[12][2].i = 7; Array[12][2].j = 0; Array[12][3].i = 7; Array[12][3].j = 1;
   
   Array[13][0].i = 6; Array[13][0].j = 2; Array[13][1].i = 6; Array[13][1].j = 3;
   Array[13][2].i = 7; Array[13][2].j = 2; Array[13][3].i = 7; Array[13][3].j = 3;
   
   Array[14][0].i = 6; Array[14][0].j = 4; Array[14][1].i = 6; Array[14][1].j = 5;
   Array[14][2].i = 7; Array[14][2].j = 4; Array[14][3].i = 7; Array[14][3].j = 5;
   
   Array[15][0].i = 6; Array[15][0].j = 6; Array[15][1].i = 6; Array[15][1].j = 7;
   Array[15][2].i = 7; Array[15][2].j = 6; Array[15][3].i = 7; Array[15][3].j = 7;
*/    

    // Более сложное покрытие 
   Array[0][0].i = 0; Array[0][0].j = 0; Array[0][1].i = 1; Array[0][1].j = 0;
   Array[0][2].i = 1; Array[0][2].j = 1; Array[0][3].i = 2; Array[0][3].j = 2;
   
   Array[1][0].i = 0; Array[1][0].j = 1; Array[1][1].i = 0; Array[1][1].j = 2;
   Array[1][2].i = 1; Array[1][2].j = 2; Array[1][3].i = 2; Array[1][3].j = 3;
   
   Array[2][0].i = 0; Array[2][0].j = 3; Array[2][1].i = 0; Array[2][1].j = 4;
   Array[2][2].i = 1; Array[2][2].j = 5; Array[2][3].i = 2; Array[2][3].j = 5;
   
   Array[3][0].i = 1; Array[3][0].j = 3; Array[3][1].i = 1; Array[3][1].j = 4;
   Array[3][2].i = 2; Array[3][2].j = 4; Array[3][3].i = 3; Array[3][3].j = 4;
   
   Array[4][0].i = 0; Array[4][0].j = 5; Array[4][1].i = 0; Array[4][1].j = 6;
   Array[4][2].i = 1; Array[4][2].j = 6; Array[4][3].i = 2; Array[4][3].j = 6;
   
   Array[5][0].i = 0; Array[5][0].j = 7; Array[5][1].i = 1; Array[5][1].j = 7;
   Array[5][2].i = 3; Array[5][2].j = 5; Array[5][3].i = 3; Array[5][3].j = 6;
   
   Array[6][0].i = 2; Array[6][0].j = 7; Array[6][1].i = 3; Array[6][1].j = 7;
   Array[6][2].i = 4; Array[6][2].j = 5; Array[6][3].i = 4; Array[6][3].j = 6;
   
   Array[7][0].i = 2; Array[7][0].j = 0; Array[7][1].i = 3; Array[7][1].j = 0;
   Array[7][2].i = 3; Array[7][2].j = 1; Array[7][3].i = 3; Array[7][3].j = 2;
   
   Array[8][0].i = 2; Array[8][0].j = 1; Array[8][1].i = 4; Array[8][1].j = 0;
   Array[8][2].i = 5; Array[8][2].j = 1; Array[8][3].i = 5; Array[8][3].j = 2;
   
   Array[9][0].i = 3; Array[9][0].j = 3; Array[9][1].i = 4; Array[9][1].j = 4;
   Array[9][2].i = 4; Array[9][2].j = 3; Array[9][3].i = 4; Array[9][3].j = 7;
   
   Array[10][0].i = 5; Array[10][0].j = 0; Array[10][1].i = 4; Array[10][1].j = 1;
   Array[10][2].i = 5; Array[10][2].j = 3; Array[10][3].i = 6; Array[10][3].j = 2;
   
   Array[11][0].i = 4; Array[11][0].j = 2; Array[11][1].i = 6; Array[11][1].j = 0;
   Array[11][2].i = 7; Array[11][2].j = 0; Array[11][3].i = 6; Array[11][3].j = 3;
   
   Array[12][0].i = 5; Array[12][0].j = 4; Array[12][1].i = 5; Array[12][1].j = 5;
   Array[12][2].i = 5; Array[12][2].j = 6; Array[12][3].i = 5; Array[12][3].j = 7;
   
   Array[13][0].i = 6; Array[13][0].j = 1; Array[13][1].i = 7; Array[13][1].j = 2;
   Array[13][2].i = 6; Array[13][2].j = 4; Array[13][3].i = 6; Array[13][3].j = 5;
   
   Array[14][0].i = 7; Array[14][0].j = 1; Array[14][1].i = 7; Array[14][1].j = 3;
   Array[14][2].i = 6; Array[14][2].j = 6; Array[14][3].i = 7; Array[14][3].j = 7;
   
   Array[15][0].i = 6; Array[15][0].j = 7; Array[15][1].i = 7; Array[15][1].j = 4;
   Array[15][2].i = 7; Array[15][2].j = 5; Array[15][3].i = 7; Array[15][3].j = 6;
    return Array;
}

char PrintSymbol(int i) {
    switch (i) {
        case 0: return 'a';
        case 1: return 'b';
        case 2: return 'c';
        case 3: return 'd';
        case 4: return 'e';
        case 5: return 'f';
        case 6: return 'g';
        case 7: return 'h';
        case 8: return 'i';
        case 9: return 'j';
        case 10: return 'k';
        case 11: return 'l';
        case 12: return 'm';
        case 13: return 'n';
        case 14: return 'o';
        case 15: return 'p';
    }
}

// Печать покрытия
void PrintArray(Data **mas, int n, int m) {
    const int q = 64;
    char matr[q][q] = {};
    int i, j;
    
    for (i = 0; i < n; i++) 
        for (j = 0; j < m; j++) 
            matr[mas[i][j].i][mas[i][j].j] = PrintSymbol(i);
   
    cout << "Our segments on the chessboard: " << endl;
    for (i = 0; i < q; i++) {
        for (j = 0; j < q; j++)
            cout << matr[i][j];
        cout << "\n";
    }
}

void DelMas(Data **Array, int n) {
    for (int i = 0; i < n; i++) 
        delete Array[i];
        
    delete [] Array;
}

void InitStructures(Data ***population, Data ***population1, int **rezult,
        int **Index, const int n, const int m, const int col_gen, const int size_of_population) {
    *population = new Data *[size_of_population];
    *population1 = new Data *[size_of_population];
    *rezult = new int [size_of_population];
    *Index = new int [size_of_population];
    
    for (int i = 0; i < size_of_population; i++) {
        (*population)[i] = new Data[n];
        (*population1)[i] = new Data[n];        
    }
    
}

void InizFirstGeneration(Data **population, Data **Array, const int size_of_population, const int n) {
    for (int i = 0; i < size_of_population; i++)
        for (int j = 0; j < n; j++) {
            int coin = rand() % 4;
            population[i][j].i = Array[j][coin].i;
            population[i][j].j = Array[j][coin].j;
            
        }
}

void InizVector(int *vec, const int size_of_population) {
    for (int i = 0; i < size_of_population; i++)
        vec[i] = 0;
}


void InizMatr(Data **matr, const int size_of_population, const int col_gen) {
    for (int i = 0; i < size_of_population; i++)
        for (int j = 0; j < col_gen; j++) {
            matr[i][j].i = 0;
            matr[i][j].j = 0;
        }
}

void InizCharMatr(char chess[][8], int q) {
    for (int i = 0; i < q; i++)
        for (int j = 0; j < q; j++)
            chess[i][j] = 'x';
    
}

void InizBoolMatr(bool Matr[][8], int q) {
    for (int i = 0; i < q; i++)
        for (int j = 0; j < q; j++)
            Matr[i][j] = false;
}

// Вычисление фенотипа
int func_fen(Data *population, const int col_gen) {
    int fenotip = 0;
    const int q = 8;
    bool Flags[q][q];
    InizBoolMatr(Flags, q);
    Data shifts[8];
    shifts[0].i = -2;
    shifts[0].j = +1;
    shifts[1].i = -1;
    shifts[1].j = +2;
    shifts[2].i = +1;
    shifts[2].j = +2;
    shifts[3].i = +2;
    shifts[3].j = +1;
    shifts[4].i = +2;
    shifts[4].j = -1;
    shifts[5].i = +1;
    shifts[5].j = -2;
    shifts[6].i = -1;
    shifts[6].j = -2;
    shifts[7].i = -2;
    shifts[7].j = -1;
    
    for (int i = 0; i < col_gen; i++) {
        Flags[population[i].i][population[i].j] = true;
        fenotip++;
    }
    for (int i = 0; i < col_gen; i++) {
        //Flags[population[i].i][population[i].j] = true;
        //fenotip++;
        for (int j = 0; j < 8; j++) {
            int c1 = population[i].i + shifts[j].i;
            int c2 = population[i].j + shifts[j].j;
            if ((c1 >= 0) && (c1 <= 7) && (c2 >= 0) && (c2 <= 7))
                if (Flags[c1][c2] == false) {
                    fenotip++;
                    Flags[c1][c2] = true;
                }
        }
        /*
        for (int i1 = 0; i1 < 8; i1++) {
            for (int j1 = 0; j1 < 8; j1++)
                cout << Flags[i1][j1] << " ";
            cout << endl;
            
        }
        cout << endl;
        char ch = getchar();
        */
    }
    
    return fenotip;
}

void PrintAnswer(Data *population, const int col_gen, int current_iter) {
    cout << "We found the solution in " << current_iter << " iteration.\n";
    int i, j;
    const int q = 8;
    char chessboard[q][q] = {};
    InizCharMatr(chessboard, q);
    
    for (i = 0; i < col_gen; i++) {
        cout << "(" << population[i].i << ", " << population[i].j << ") ";
        chessboard[population[i].i][population[i].j] = '#';
    }
        
    cout << endl;
    
   for (i = 0; i < q; i++) {
       for (j = 0; j < q; j++)
            cout << chessboard[i][j];
        cout << endl;
   }
    
}

void InizIndex(int *mas, const int size) {
    for (int i = 0; i < size; i++)
        mas[i] = i;
}

void SortOfIndex(int *Index, int *rezult, const int size_of_population) {
    for (int i = 0; i < size_of_population - 1; i++)
        for (int j = i + 1; j < size_of_population; j++)
            if (rezult[Index[i]] < rezult[Index[j]]) {
                int pr = Index[i];
                Index[i] = Index[j];
                Index[j] = pr;
            }
}

void Mutation(Data Child[], Data **Array, const int col_gen) {
    int zn = (rand() % 10) + 1; // 1..10;
    if ((zn == 5) || (zn == 6)) {
            int i1 = rand() % col_gen;
            int i2 = rand() % 4;
            Child[i1].i = Array[i1][i2].i;
            Child[i1].j = Array[i1][i2].j;
        }
    
}

void NewGeneration(Data **Array, int *Index, int *rezult, Data **population, 
                    Data **population1, const int size_of_population, 
                    const int col_gen) {
    int col_iter = size_of_population / 2;
    int first_ind = 0;
    int second_ind = 1;
    Data FirstChild[col_gen];
    Data SecondChild[col_gen];
    int i, j;
    int new_ind = 0;
    
    for (i = 0; i < col_iter; i++) {
        int point_crossingover = (rand() % (col_gen-2)) + 1;
        for (j = 0; j < point_crossingover; j++) {
            FirstChild[j].i = population[Index[first_ind]][j].i;
            FirstChild[j].j = population[Index[first_ind]][j].j;
            SecondChild[j].i = population[Index[second_ind]][j].i;
            SecondChild[j].j = population[Index[second_ind]][j].j;
        }
        for (j = point_crossingover; j < col_gen; j++) {
            FirstChild[j].i = population[Index[second_ind]][j].i;
            FirstChild[j].j = population[Index[second_ind]][j].j;
            SecondChild[j].i = population[Index[first_ind]][j].i;
            SecondChild[j].j = population[Index[first_ind]][j].j;
        }
        
        Mutation(FirstChild, Array, col_gen);
        Mutation(SecondChild, Array, col_gen);
        
        for (j = 0; j < col_gen; j++) {
            population1[new_ind][j] = FirstChild[j];
            population1[new_ind+1][j] = SecondChild[j];
        }
        new_ind += 2;
        
        first_ind++;
        second_ind++;
    }
    
    //population = population1;
    
    for (i = 0; i < size_of_population; i++)
        for (j = 0; j < col_gen; j++)
            population[i][j] = population1[i][j];
    
}

int main()
{
    // n - количество кластеров, m - количество ячеек в каждои из них
    const int n = 16, m = 4;
    // массив для кластеров
    Data **Array = NULL;
    // Создание массива кластеров
    CreateMas(&Array, n, m);
    // Инициализация его значений
    Array = InizArray(Array, n, m);
    // Печать кластеров
    PrintArray(Array, n, m);
    
    srand(time(NULL));
    // кол-во генов
    const int col_gen = 16;
    // максимальное количество итераций для ГА
    const int max_iter = 1000;
    // количество особей в каждой популяции
    const int size_of_population = 50;
    // Текущая популяция
    Data **population = NULL;
    // Их дети
    Data **population1 = NULL;
    // фенотип текущей популяции
    int *rezult = NULL;
    // Индекс для сортировки массива с фенотипом
    int *Index = NULL;
    // Создание этих структур
    InitStructures(&population, &population1, &rezult, &Index, n, m, col_gen, size_of_population);
    // Создание начальной популяции
    InizFirstGeneration(population, Array,  size_of_population, n);
    
    // текущая итерация-поколение
    int current_iter = 0, i;
    
    while (current_iter < max_iter) {
        // Инициализируем фенотип и детей в начале каждой итерации
        InizVector(rezult, size_of_population);
        InizMatr(population1, size_of_population, col_gen);
        
        // среднее-арифметическое фенотипа для каждого поколения
        int sr = 0;
        
        // оценка фенотипа 
        // цикл по всем особям
        for (i = 0; i < size_of_population; i++) {
            // вычисление фенотипа
            rezult[i] = func_fen(population[i], col_gen);
            if (rezult[i] == 64) { // если нашли решение, то печать ответа
                PrintAnswer(population[i], col_gen, current_iter);
                // выход из цикла
                goto label1;
            }
            sr += rezult[i]; // вычисление суммы фенотипа
        }
        
        sr /= size_of_population; // вычисление среднего арифметического
        cout << "\n\nSr = " << sr << endl;
        
        InizIndex(Index, size_of_population); // Вычисляем индекс
        SortOfIndex(Index, rezult, size_of_population); // Сортируем индекс
        // Формируем новое поколение
        NewGeneration(Array, Index, rezult, population, population1, size_of_population, col_gen);
        

        current_iter++;
    }
    
    // Высвобождаем ОП
    label1:
    DelMas(Array, n);
    DelMas(population, size_of_population);
    DelMas(population1, size_of_population);
    delete [] rezult;
    delete [] Index;
    
    
    return 0;
}
