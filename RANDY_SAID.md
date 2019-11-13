### Yay! One Test :-) 
Everyone on the team writing to exactly the same standard?

I might have to send SOMEONE out for coffee **all morning**!

Anyway, the endpoint files are troublesome. This is due
using a generic ResponseEntity where <T> may be one of two types.
This is never a good idea. You'll eventually figure out that you
must return one type here (<StockQuote>) and `throw` when errors
are encountered.