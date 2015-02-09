(*
   LIB  (library)

   new:                       -> LIB
   add:   LIB x BOOK          -> LIB
   rem:   LIB x BOOK          -> LIB
   cko:   LIB x BOOK x PERSON -> LIB
   cki:   LIB x BOOK x PERSON -> LIB
   wait:  LIB x BOOK x PERSON -> LIB
   off:   LIB x BOOK x PERSON -> LIB
   has:   LIB x BOOK          -> boolean
   here:  LIB x BOOK          -> int
   num:   LIB x BOOK          -> int

   new  makes a LIB with no books, no wait lists, etc.
   add  puts another copy of a book in the library
   rem  takes a copy out of the library
   cko  allows a person to check out the book
   cki  checks the book back in;
        if there is a person on wait list it does a cko to that person.
   wait puts person at the back of a waiting list for a book
   off  takes a person out of the waiting list for a book
   has  tells if a book exists in the Library (even if all copies are
        checked out
   here tells how many copies of a book are available for checking out
   num  tells how many copies total of a book exist in the library
*)

datatype LIB =
 New
 | add  of LIB * int
 | cko  of LIB * int * string
 | wait of LIB * int * string
 ;

fun has(New, i) = false
 | has (add(L,j), i ) = if i = j then true else has(L,i)
 | has (cko(L,j,p), i) = has(L,i)
 | has (wait(L,j,p), i) = has(L,i)
 ;

fun rem(New, i) = New
 | rem(add(L,j), i) = if i = j then L else add(rem(L,i), j)
 | rem(cko(L,j,p), i) = rem(L,i)
 | rem(wait(L,j,p), i) = rem(L,i)
 ;

fun num(New, i) = 0
 | num(add(L,j), i) = if i = j then num(L,i) + 1 else num(L,i)
 | num(cko(L,j,p),i) = num(L,i)
 | num(wait(L,j,p),i) = num(L,i)
 ;

fun here(New, i) = 0
 | here(add(L,j), i)  = if i = j then here(L,i) + 1 else here(L,i)
 | here(cko(L,j,p), i) = if i = j then
                          if here(L,i) = 0 then
                            0
                          else here(L,i) - 1
                        else here(L,i)
 | here(wait(L,j,p), i) = here(L,i)
 ;

fun off(New, i, p) = New
 | off(add(L,j),i,p) = off(L,i,p)
 | off(cko(L,j,p),i,p2) = off(L,i,p2)
 | off(wait(L,j,p),i,p2) = if p2 = p then L else wait(off(L,j,p),i,p2)
 ;

fun topw(New,i) = ""
 | topw(add(L,j),i) = topw(L,i)
 | topw(cko(L,j,p),i) = topw(L,i)
 | topw(wait(L,j,p),i) = if j = i then p else topw(L,i)
 ;

fun cki(New, i, p) = New
 | cki(add(L,j),i,p) = cki(L,i,p)
 | cki(cko(L,j,p),i,p2) = if i = j then
                             if topw(L,i) = "" then
                                L
                             else
                                cko(off(L,i,p2),i,p2)
                          else cki(L,i,p2)
 | cki(wait(L,j,p),i,p2) = if i = j then
                              if topw(L,i) = "" then
                                 cki(cko(L,i,p),i,p2)
                              else
                                  wait(cki(L,i,p2),j,p)
                           else wait(cki(L,i,p2),j,p)
 ;

val L = New;
val L = add(L,1);
val L = add(L,1);
val L = add(L,1);
here(L,1);
num(L,1);
has(L,1);
val L = cko(L,1,"Jimmy");
here(L,1);
num(L,1);
val L = cki(L,1,"Jimmy");
here(L,1);
num(L,1);
val L = cko(L,1,"Jimmy");
here(L,1);
num(L,1);
val L = wait(L,1, "Bobby");
topw(L,1);
val L = cki(L,1,"Jimmy");
here(L,1);
num(L,1);
topw(L,1);
val L = cko(L,1,"Jimmy");
val L = cko(L,1,"Billy");
here(L,1);
num(L,1);
has(L,1);
val L = cko(L,1,"Joe");
here(L,1);
num(L,1);
has(L,1);
val L = cki(L,1,"Joe");
here(L,1);
num(L,1);
has(L,1);
