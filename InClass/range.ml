#Write a recursive function that returns a list of integer numbers in the range of n to m

#Option 1
let rec range n m = if n=m then [m] else [n]@(range(n+1) m);;

#Option 2
let rec range n m. = if n=m then [m] else n::(range(n+1) m);;

#Example Input:
  range 3 5;;
