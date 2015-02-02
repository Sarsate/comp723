(*
 * PSTACK: Priority Stack
 *
 * A stack where elements have an associate priority.
 * Elements are ordered such that the highest priority
 * element is at the top of the stack
 *
 *
 *
 * new:   int -> PSTACK
 * empty: PSTACK -> bool
 * size:  PSTACK -> int
 * topp:  PSTACK -> int
 * topv:  PSTACK -> int
 * pop:   PSTACK -> PSTACK

*)

datatype PSTACK=
  New of int
  | push of PSTACK * int * int
  ;

fun empty(New(n)) = true
  | empty(push(S,i,j)) = false
  ;

fun size(New(n)) = 0
  | size(push(S,i,j)) = size(S) + 1
  ;


exception emptyStack;

fun topp(New(m)) = raise emptyStack
  | topp(push(New(m),i,j)) = j
  | topp(push(S,i,j)) = if j >= topp(S) then j else topp(S)
  ;

fun topv(New(m)) = raise emptyStack
  | topv(push(New(m),i,j)) = i
  | topv(push(S,i,j)) = if j >= topp(S) then i else topv(S)
  ;


fun pop(New(m)) = New(m)
  | pop(push(New(m), i,j)) = New(m)
  | pop(push(S,i,j)) = if j >= topp(S) then S else push(pop(S), i,j)
  ;


val S = New(3);
val S1 = push(S,1,1);
val S2 = push(S1,2,1);
val S3 = push(S2,3,0); (*  [(3,0),(1,1),(2,1)] *)
topp(S3); (* should be 1 *)
topv(S3);  (* should be 2 *)
val S4 = pop(S3); (*  [(3,0),(1,1)] *)
topp(S4);(* should be 1 *)
topv(S4);(* should be 1 *)
val S5 = push(S4,5,0);(*  [(3,0) (5,0),(1,1)] *)
topp(S5);(* should be 1 *)
topv(S5);(* should be 1 *)
val S6 = pop(S5);(*  [(3,0) (5,0)] *)
topp(S6);(* should be 0 *)
topv(S6);(* should be 5 *)
val S7 = pop(S6);(*  [(3,0)] *)
topp(S7);(* should be 0 *)
topv(S7);(* should be 3 *)
