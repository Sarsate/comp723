(*
 * STOMP: Stomp Stack
 *
 * A bounded stack. When the stack is full, the element at
 * the bottom of the stack is stomped out to make room for
 * the new one.
 *
 *
 *
 * new:   int -> STOMP
 * empty: STOMP -> bool
 * max:   STOMP -> int
 * size:  STOMP -> int
 * full:  STOMP -> bool
 * top:   STOMP -> int
 * pop:   STOMP -> STOMP

*)

datatype STOMP =
  New of int
  | push of STOMP * int
  ;

fun empty(New(n)) = true
  | empty(push(S,i)) = false
  ;

fun max(New(n)) = n
  | max(push(S,i)) = max(S)
  ;

fun size(New(n)) = 0
  | size(push(S,i)) = if size(S) = max(S) then max(S) else size(S) + 1
  ;

fun full(New(m)) = m=0
  | full(push(S,i)) = if size(S) >= max(S) - 1
                        then true else false
  ;

fun rem(New(m)) = New(m)
  | rem(push(S,i)) = if empty(S) then S else push(rem(S),i)
  ;

exception emptyStack;

fun top(New(m)) = raise emptyStack
  | top(push(S,i)) = i
  ;

fun pop(New(m)) = New(m)
  | pop(push(S,i)) = if full(S) then pop(push(rem(S),i)) else S
  ;


val S = New(3);
val S1 = push(S,0);
val S2 = push(S1,1);
val S3 = push(S2,2); (*  [0,1,2] *)
top(S3); (* should be 2 *)
full(S3);  (* should be true *)
val rem1 = pop(S3); (* [0,1]  *)
top(rem1); (* should be 1 *)
full(rem1); (* should be false *)
val S4 = push(rem1,3); (* [0,1,3] *)
top(S4); (* should be 3 *)
full(S4); (* should be true *)
val S5 = push(S4,4); (* [1,3,4] *)
top(S5); (*should be 4 *)
val S6 = pop(pop(S5)); (* [1] *)
top(S6); (*should be 1 *)
val S7 = pop(S6); (*[]*)
top(S7) (*blargh*)
