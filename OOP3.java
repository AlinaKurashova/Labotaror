uses crt,kompl;
procedure Vyvod(var f:complex);
begin
if f.m<0 then writeln(f.r:6:2,' -',-f.m:0:2,'i')
else writeln(f.r:6:2,' +',f.m:0:2,'i');
end;
const nmax=15;
var a:array[1..nmax] of complex;
    c:array[1..nmax] of real;
    z:complex;
    n,m,i:byte;
begin
clrscr;
randomize;
repeat
write('Размер массива от 2 до ',nmax,' n=');
readln(n);
until n in [2..nmax];
writeln('Исходный массив комплексных чисел:');
for i:=1 to n do
 begin
  a[i].r:=-5+10*random;
  a[i].m:=-5+10*random;
  Vyvod(a[i]);
 end;
writeln('Полученный массив модулей сумм рядом стоящих элементов:');
m:=0;
for i:=2 to n do
 begin
  Summa(a[i-1],a[i],z);
  m:=m+1;
  c[m]:=Modul(z);
  write(c[m]:8:2);
 end;
readln
end.