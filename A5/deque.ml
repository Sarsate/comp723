(*

  DEQ: double ended queue of int
       (unbounded)

  new:           --> DEQ
  addR:  DEQ x E --> DEQ
  remR:  DEQ     --> DEQ
  addL:  DEQ x E --> DEQ
  remL:  DEQ     --> DEQ
  size:  DEQ     --> int
  empty: DEQ     --> boolean
  atR:   DEQ     --> E
  atL:   DEQ     --> E


*)

datatype DEQ = 
   New 
   | addR of DEQ * int 
   ;

fun empty (New) = true 
  | empty (addR(D,i)) = false 
  ;

fun size (New) = 0
  | size (addR(D,i)) = size(D)+1 ;
  ;

exception atREmptyDeq ;

fun atR (New) = raise atREmptyDeq
  | atR (addR(D,i)) = i
  ;

exception atLEmptyDeq ;

fun atL (New) = raise atLEmptyDeq
  | atL (addR(D,i)) = if empty(D)
                       then i
                       else atL(D)
  ;

fun remL (New) = New
  | remL (addR(D,i)) = if empty(D)
                        then D
                        else addR(remL(D),i) 
  ;

fun addL (New,i) = addR(New,i)
  | addL (addR(D,i),j) = addR(addL(D,j),i)
  ;

fun remR (New) = New
  | remR (addR(D,i)) = D
  ;
