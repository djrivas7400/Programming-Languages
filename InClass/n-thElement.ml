#Write a recursive function that finds the n-th element from a list

let rec nth l n = if n=0 then (List.hd l) else nth(List.tl l) (n-1);;

#Example Input:
  nth [1;2;3] 0;;
