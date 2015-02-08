(*

   SET of E
 
   New:            --> SET
   Insert: SET x E --> SET
   remove: SET x E --> SET
   member: SET x E --> boolean

*)


datatype ('E) Set = 
   New  
   | Insert of ('E) Set * 'E ;

fun member ( New, i )         = false 
  | member ( Insert(s,j), i ) = if i=j 
                                 then true 
                                 else member(s,i) ;

fun remove ( New, i )         = New
  | remove ( Insert(s,j), i ) = if i=j 
                                 then remove(s,i)
                                 else Insert( remove(s,i), j) ;
