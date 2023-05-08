#Write a recursivce fucntion that returns true if all elements of a int list are greater than 0, return false otherwise

#function that returns if an int is positive
let pos n = n>0;;
#the greater than 0 function
let rec allpos l = if l=[] then true else (if pos(List.hd l) then allpos(List.tl) else false);;

#Example input:
  allpos [5;2;9;8];;
  allpos [3;0];;
