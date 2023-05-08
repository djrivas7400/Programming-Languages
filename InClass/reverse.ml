#Write a recursive function that reverses elements in a list

let rec reverse l = if l=[] then [] else reverse(List.tl l)@[List.hd l];;

#Example Input:
  reverse [1;2;3];;
