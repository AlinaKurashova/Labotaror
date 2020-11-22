unit kompl;
interface
type complex=record
             r,m:real;
             end;
procedure Summa(f,g:complex;var z:complex);
procedure Razn(f,g:complex;var z:complex);
procedure Proizvedenie(f,g:complex;var z:complex);
procedure Chastnoe(f,g:complex;var z:complex);
function Modul(f:complex):real;
implementation
procedure Summa(f,g:complex;var z:complex);
begin
z.r:=f.r+g.r;
z.m:=f.m+g.m;
end;
procedure Razn(f,g:complex;var z:complex);
begin
z.r:=f.r-g.r;
z.m:=f.m-g.m;
end;
procedure Proizvedenie(f,g:complex;var z:complex);
begin
z.r:=f.r*g.r-f.m*g.m;
z.m:=g.r*f.m+f.r*g.m;
end;
procedure Chastnoe(f,g:complex;var z:complex);
begin
z.r:=(f.r*g.r+f.m*g.m)/(sqr(g.r)+sqr(g.m));
z.m:=(f.m*g.r-f.r*g.m)/(sqr(g.r)+sqr(g.m));
end;
function Modul(f:complex):real;
begin
Modul:=sqrt(sqr(f.r)+sqr(f.m));
end;
end