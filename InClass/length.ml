#Write a recursive function that returns the length of list

#Option 1
let rec length l = if l=[] then 0 else length(List.tl l)+1;;

#Option 2
let rec length l = if l=[] then 0 else length(let h::t in t)+1;;

#Example Input:
#length[5;4;3;2];;
