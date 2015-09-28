# effective_search_slides

1. Как сделать полнотекстовый поиск
 - Hash Map, Doc Ordinals, Frequencies, Positions
 - Inverted Index
 - FST
 - Postings List (сжатие данных, Delta Codec, VInt, Frame Of Reference)
 - Skip List
 - Live Docs
 - Filter Cache (bitmap, Sorted Ints, Roaring Bitmaps)

Заметки:

Недостатки VInt - ухудшает статистику предсказателя cpu, нельзя распаковать конкретное значение по индексу

Links:

https://www.elastic.co/blog/frame-of-reference-and-roaring-bitmaps

http://blog.mikemccandless.com/2010/08/lucene-performance-with-pfordelta-codec.html

http://hackerlabs.org/blog/2011/10/01/hacking-lucene-the-index-format/

http://lemire.me/blog/archives/2012/09/12/fast-integer-compression-decoding-billions-of-integers-per-second/

http://www.slideshare.net/lucenerevolution/what-is-inaluceneagrandfinal

http://roaringbitmap.org/

https://en.wikipedia.org/wiki/Skip_list
