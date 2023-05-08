#Write a recursive function that concatenates lists in a list

let rec concat l = if l=[] then [] else (List.hd l)@(concat(List.tl l));;

#Example Input:
  concat [[1;2];[3;4;5];[6]];;
