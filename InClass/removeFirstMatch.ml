#Write a recursive function that removes the first matching element from a list

let rec remove_first a l = if l=[] then [] else if a=(List.hd l) then (List.tl l) else (List.hd l)::(remove_first a (List.tl l));;

#Example Input:
  remove_first 2 [1;1;3;1];;
