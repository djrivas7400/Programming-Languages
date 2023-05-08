#Write a recursive function that inserts an element into a sorted list

let rec insert n l = if l=[] then [n] else if n<= List.hd l then n::l else List.hd l::(insert (n) (List.tl l));;

#Example Input:
  insert 3 [1;2;4;56];;
