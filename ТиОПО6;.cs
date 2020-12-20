 class Tochka
    {
        public double a; double C,S;
        public Tochka(double a)
        {
            this.a = a;
        }
     
        public void ShowInfo()
        {
            Console.WriteLine("1 сторона {0}", a);
 
        }
        public virtual double Dlina(double a)
        {
            C = 2*Math.PI*a;
            Console.WriteLine("Длина окружности: {0}",C);
            return C;
        }
        public virtual double Sqr(double a)
        {
            double S = (a*a)*Math.PI;
            Console.WriteLine("Площадь: {0}", S);
            return S;