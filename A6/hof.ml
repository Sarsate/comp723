(* Higher Order Function:
  *
  * HOF(p(int),f(-),g(-)) -> R(int, -)
  * R behaves as follows:
  *    run P() on arg1, if abs(P()) > 1000 then execute F on arg2
  *    otherwise run G on arg2
  *
  *
  *
*)


fun p(i) = i * i;

fun f(i) = 2*i;

fun g(i) = 3*i;

fun HOF P F G = let fun R(x,y) = if abs(P(x)) > 1000 then F(y) else G(y) in R end;

val FG = HOF p f;
val R = FG g;
R(100,6); (* should be 12*)
R(5,6);   (* should be 18*)
