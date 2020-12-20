program laba4;
 
type
  TStat = record
    nick: string;
    wins, battles: integer;
    proc: real;
  end;
 
var
  N, i, num: integer;
  str: string;
  stat: array of TStat;
  nick: string;
 
function found(ni_ck: string): integer;
begin
  found := -1;
  for var e := 0 to Length(stat) - 1 do
  begin
    if stat[e].nick = ni_ck then 
    begin
      found := e;
      break;
    end;
  end;
end;
 
var
  v_pts, e_pts, l_e: integer; 
  F: textfile;
  k: real;
  s: string;
 
begin
  Assign(F, 'input.txt');
  Reset(F);
  readln(F, n);
  SetLength(stat, 1);
  for i := 0 to n - 1 do
  begin
    readln(F, str);
      //get enemy_nick
    nick := Copy(str, 1, Pos(' ', str) - 1);    
    Delete(str, 1, Pos(' ', str));
    
    if (stat[0].nick <> '') then
    begin
      num := found(nick);
      if (num = -1) then //not found
      begin
        l_e := Length(stat);
        SetLength(stat, l_e + 1);
        num := l_e;
        stat[num].nick := nick;
      end;
    end
      else
    begin
      stat[0].nick := nick;
    end;
    
    inc(stat[num].battles);
    
      //get Vania_points
    v_pts := StrToInt(Copy(str, 1, Pos(' ', str)));   
    Delete(str, 1, Pos(' ', str));
    
      //get enemy_points
    e_pts := StrToInt(str);
    
    if v_pts > e_pts Then
      inc(stat[num].wins);        
  end;
  
  Close(F);
  
  //вычисляю процент побед
  for i := 0 to Length(stat) - 1 do
  begin
    stat[i].proc := stat[i].wins / stat[i].battles;  
  end;
  
  //сортировка по процентам
  for i := 0 to Length(stat) - 2 do 
  begin
    for var j := 0 to Length(stat) - i - 2 do 
    begin
      if (stat[j].proc > stat[j + 1].proc) then //(stat[j].proc = stat[j + 1].proc) and (stat[j].nick > stat[j + 1].nick)
      begin
        k := stat[j].proc;
        stat[j].proc := stat[j + 1].proc;
        stat[j + 1].proc := k;
        
        s := stat[j].nick;
        stat[j].nick := stat[j + 1].nick;
        stat[j + 1].nick := s;
      end
      else
      begin
        if stat[j].proc = stat[j + 1].proc Then
          if (stat[j].proc = stat[j + 1].proc) and (stat[j].nick > stat[j + 1].nick) Then
          begin
            k := stat[j].proc;
            stat[j].proc := stat[j + 1].proc;
            stat[j + 1].proc := k;
            
            s := stat[j].nick;
            stat[j].nick := stat[j + 1].nick;
            stat[j + 1].nick := s;
          end;
      end;
    end;
  end;
  
  writeln(Length(stat));
  for i := 0 to Length(stat) - 1 do
  begin
    write(stat[i].nick, ' ');
    writeln(stat[i].proc * 100:0:6);
  end;
end.
