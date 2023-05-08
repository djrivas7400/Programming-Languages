#Write a recursive function that returns the sum of all of the elements in a list

let rec sum l = if l=[] then 0 else sum(List.tl l)+List.hd l;;

#Example Input:
  sum [4;1;3];;
