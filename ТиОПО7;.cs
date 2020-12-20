using System;
 
namespace laba7
{
    class Cylinder 
    {
        private double h;
        private double v;
        private double r;
        private double s;      
        public Cylinder(double H, double R)
        {
            h = H;
            r = R;
        }
        public Cylinder(double V)
        {
            v = V;
        }
        public double V()
        {
            v = Math.PI * r * r * h;                  
            return v;
        }
        public void S()
        {
            s = 2 * Math.PI * r * h;
            Console.WriteLine("Площадь поверхности цилиндра: {0}",s);
        }
        public static bool operator ==(Cylinder obj1, Cylinder obj2)
        {
            if (obj1.v == obj2.v)
            return true;
            return false;
        }
 
        public static bool operator !=(Cylinder obj1, Cylinder obj2)
        {
            if (obj1.v != obj2.v )
                return true;
            return false;
        }
 
        public static bool operator >(Cylinder obj1, Cylinder obj2)
        {
            if (obj1.v > obj2.v)
                return true;
            return false;
        }
        public static bool operator <(Cylinder obj1, Cylinder obj2)
        {
            if (obj1.v < obj2.v)
                return true;
            return false;
        }
 
        public override int GetHashCode()
        {  
            return 0;  
        }
        public override bool Equals(object o)
        {
            return true;
        }
 
    }
    class Program
    {
        static void Main()
        {
            Console.WriteLine("Введите высоту первого цилиндра");
            double H = double.Parse(Console.ReadLine());
            Console.WriteLine("Введите радиус первого цилиндра");
            double R = double.Parse(Console.ReadLine());
            Cylinder a = new Cylinder(H,R);
            Console.WriteLine("Введите высоту второго цилиндра");
            double h = double.Parse(Console.ReadLine());
            Console.WriteLine("Введите радиус второго цилиндра");
            double r = double.Parse(Console.ReadLine());
            Cylinder b = new Cylinder(h,r);
            double v = a.V();
            double v1 = b.V();
            Console.WriteLine("Объем первого цилиндра равен: {0}",v);
            a.S();
            Console.WriteLine("Объем второго цилиндра равен: {0}", v1);
            b.S();
            Cylinder z = new Cylinder(v);
            Cylinder z1 = new Cylinder(v1);
            if (z == z1)
            {
                Console.WriteLine("Равны");
            }
            if (z != z1)
            {
                Console.WriteLine("Не равны");
            }
            if (z > z1)
            {
                Console.WriteLine("Объем первого цилиндра больше второго");
            }
            if (z < z1)
            {
                Console.WriteLine("Объем второго цилиндра больше первого");
            }
                    Console.ReadKey();
        }
    } 
}