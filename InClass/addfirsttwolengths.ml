#Write a recursive function that returns the sum of the first two lengths of a list of lists
let rec length l = if l=[] then 0 else length(List.tl l)+1;;

let addfirsttwolengths l = length(List.hd l) + length(List.hd(List.tl l));;

#Example Input:
  addfirsttwolengths [[1;2];[2];[2;3;4]];;
