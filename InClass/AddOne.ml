#Write a recursive function that adds 1 to every element in a list

let rec add l = if l=[] then [] else ((List.hd l)+1)::add(List.tl l);;

#Example Input:
  add [1;2;3;23];;
