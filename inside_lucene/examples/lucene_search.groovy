@Grab(group='org.apache.lucene', module='lucene-analyzers-common', version='5.3.1')
import org.apache.lucene.analysis.standard.StandardAnalyzer
@Grab(group='org.apache.lucene', module='lucene-core', version='5.3.1')
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.NumericDocValuesField
import org.apache.lucene.document.IntField
import org.apache.lucene.document.StringField
import org.apache.lucene.document.TextField
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.index.IndexWriterConfig
import org.apache.lucene.index.Term
import org.apache.lucene.search.BooleanClause
import org.apache.lucene.search.BooleanQuery
import org.apache.lucene.search.QueryWrapperFilter
import org.apache.lucene.search.SearcherFactory
import org.apache.lucene.search.SearcherManager
import org.apache.lucene.search.TermQuery
import org.apache.lucene.store.FSDirectory
import org.apache.lucene.util.BytesRefBuilder
import org.apache.lucene.util.NumericUtils

import java.nio.file.Paths


def dataPath = Paths.get('data')
def dir = FSDirectory.open(dataPath)

def writerConfig = new IndexWriterConfig(new StandardAnalyzer())
def writer = new IndexWriter(dir, writerConfig)
def manager = new SearcherManager(writer, true, new SearcherFactory())

def searcher = manager.acquire()
try {
    def query = new TermQuery(new Term('name', 'brown'))
    def statusBytesBuilder = new BytesRefBuilder()
    NumericUtils.intToPrefixCoded(1, 0, statusBytesBuilder)
    def filter = new QueryWrapperFilter(new TermQuery(new Term('status', statusBytesBuilder.toBytesRef())))
    def q = new BooleanQuery.Builder()
        .add(query, BooleanClause.Occur.MUST)
        .add(filter, BooleanClause.Occur.FILTER)
        .build()
    def hits = searcher.search(query, 10)
    println "Total hits: ${hits.totalHits}"
    println "Docs:"
    for (hit in hits.scoreDocs) {
        def doc = searcher.doc(hit.doc)
        println "${hit.doc}, ${hit.score}, ${doc.get('id')}"
    }
} finally {
    manager.release(searcher)
    searcher = null
}

manager.close()
writer.close()
