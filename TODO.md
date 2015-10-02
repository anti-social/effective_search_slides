# effective_search_slides

1. Как сделать полнотекстовый поиск
 - Hash Map, Doc Ordinals, Frequencies, Positions
 - Inverted Index
 - FST
 - Postings List (сжатие данных, Delta Codec, VInt, Frame Of Reference, Bit Packing)
 - Skip List
 - Live Docs
 - Numeric Range (Trie)
 - Sorting, Aggregations, Scripts and Uninverted Index (Fielddata, Doc Values)
 - Stored fields
 - Filter Cache (bitmap, Sorted Ints, Roaring Bitmaps)

Заметки:

Недостатки VInt - ухудшает статистику предсказателя cpu, нельзя распаковать конкретное значение по индексу

Links:

https://www.elastic.co/blog/frame-of-reference-and-roaring-bitmaps

http://blog.mikemccandless.com/2010/08/lucene-performance-with-pfordelta-codec.html

http://hackerlabs.org/blog/2011/10/01/hacking-lucene-the-index-format/

http://lemire.me/blog/archives/2012/09/12/fast-integer-compression-decoding-billions-of-integers-per-second/

http://www.slideshare.net/lucenerevolution/what-is-inaluceneagrandfinal

http://blog.parsely.com/post/1691/lucene/

http://blog.jpountz.net/post/33247161884/efficient-compressed-stored-fields-with-lucene

http://blog.jpountz.net/post/35667727458/stored-fields-compression-in-lucene-41

http://blog.jpountz.net/post/41301889664/putting-term-vectors-on-a-diet

http://roaringbitmap.org/

https://en.wikipedia.org/wiki/Skip_list
