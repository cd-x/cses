# cses
CSES problemset solutions

## Problems that stood out
---
### Sorting & Searching

* Missing coin sum
---yes i got O(n) soln but isme 2 case hai 
---case-1: lets say sum[1--9] = 70 and a[10] = 40
---matlab sum[9]+1 >= a[10] to iska mtlb sum[1--10]
---tk me pure 1 se 110 tk ka sum bn skta hai kaise ?
---because 109 = 69 + a[10], 108 = 68+a[10], 107 = 67+a[10],.... 71 = 31 + a[10] aur baki to hmare pas 1 se 70 tk bnane ka upay hai hi.

---case-2: sum[1--9]+1 < a[10], isme to directly answer aa gya kyuki hm 1 se sum[1--9] tk bna skte hai lekin uske +1 krne pe nhi bnane ka upay hai. SUM aur a[10] k beech me more than 1 ka gap hai.