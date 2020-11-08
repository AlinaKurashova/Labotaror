импортируйте java.утиль.Сканер;
импортируйте java.утиль.течение.Интстрим;

программа публичных занятий {

 public static void main (String[] args)
	{
 Scanner in = новый сканер(System.in);
 Система.из.печать ("Enter N: ");
 int N=in.nextInt();
 двойная сумма=0;
 int[] arrayA = new int[N];
 int[] arrayB = новый int[N];

 for (int i =0; i)
		{
 Система.из.printf ("введите число %s:", i);
 arrayA[i]=in.nextInt();
		}

 for (int i =0; i)
		{
 сумма+=arrayA[i];
		}
 сумма/=N;

 for (int i =0; i)
		{
 если (сумма]) 
				{
 arrayB[i]=1;
 Система.из.печать(1);
				}
 иначе если (сумма>arrayA[i])
				{
 arrayB[i]=0;
 Система.из.печать(0);
				}
 еще {
 arrayB[i]=-1;
 Система.из.печать(-1);
			}

		}

	}


}
