let rec length l = if l=[] then 0 else length(List.tl l)+1;;

let addfirsttwolengths l = length(List.hd l) + length(List.hd(List.tl l));;
