(*
 * RING: circular queue structure.
 *
 * This is a bounded queue, but when elements added
 * when the queue is full, it overwrites the oldest element.
 *
 *
 * new:   int -> RING
 * empty: RING -> bool
 * max:   RING -> bool
 * size:  RING -> int
 * full:  RING -> bool
 * rem:   RING -> RING
 * front: RING -> int

*)




datatype RING =
  New of int
  | add of RING * int
  ;

fun empty(New(n)) = true
  | empty(add(R,i)) = false
  ;

fun max(New(n)) = n
  | max(add(R,i)) = max(R)
  ;

fun size(New(n)) = 0
  | size(add(R,i)) = if size(R) = max(R) then max(R) else size(R) + 1
  ;

fun full(New(m)) = m=0
  | full(add(R,i)) = if size(R) >= max(R) - 1
                        then true else false
  ;

exception emptyRing;

fun rem(New(m)) = New(m)
  | rem(add(R,i)) = if empty(R) then R else add(rem(R),i)
  ;

fun front(New(m)) = raise emptyRing
  | front(add(New(m),i)) = i
  | front(add(R,i)) = if full(R) then front(add(rem(R),i)) else front(R)
  ;

val R = New(3);
val R1 = add(R,0);
val R2 = add(R1,1);
val R3 = add(R2,2); (*  [0,1,2] *)
front(R3); (* should be 0 *)
full(R3);  (* should be true *)
val rem1 = rem(R3); (* [1,2, ]  *)
front(rem1); (* should be 1 *)
full(rem1); (* should be false *)
val R4 = add(R3,3); (* [1,2,3] *)
front(R4); (* should be 1 *)
full(R4); (* should be true *)
val R5 = add(R4,4); (* [2,3,4] *)
front(R5); (*should be 2 *)

