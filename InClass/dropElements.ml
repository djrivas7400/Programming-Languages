#Write a recursive function that drops the first n elements from a list

let rec drop n l = if n=0 then l else drop (n-1) (List.tl l);;

#Example Input:
  drop 2 [1;2;3;4];;
