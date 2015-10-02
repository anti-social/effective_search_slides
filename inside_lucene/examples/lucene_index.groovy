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
import org.apache.lucene.search.SearcherFactory
import org.apache.lucene.search.SearcherManager
import org.apache.lucene.store.FSDirectory

import java.nio.file.Paths


def dataPath = Paths.get('data')
dataPath.deleteDir()

def dir = FSDirectory.open(dataPath)

def writerConfig = new IndexWriterConfig(new StandardAnalyzer())
def writer = new IndexWriter(dir, writerConfig)
def manager = new SearcherManager(writer, true, new SearcherFactory())

def doc
doc = new Document()
doc.add(new StringField('id', '1', Field.Store.YES))
doc.add(new IntField('status', 1, Field.Store.NO))
doc.add(new NumericDocValuesField('status', 1))
doc.add(new TextField('name', 'the brown fox', Field.Store.NO))
writer.addDocument(doc)
doc = new Document()
doc.add(new StringField('id', '2', Field.Store.YES))
doc.add(new IntField('status', 1, Field.Store.NO))
doc.add(new NumericDocValuesField('status', 1))
doc.add(new TextField('name', 'the brown dog', Field.Store.NO))
writer.addDocument(doc)
doc = new Document()
doc.add(new StringField('id', '2', Field.Store.YES))
doc.add(new IntField('status', 2, Field.Store.NO))
doc.add(new NumericDocValuesField('status', 2))
doc.add(new TextField('name', 'the crown of king', Field.Store.NO))
writer.addDocument(doc)

manager.maybeRefresh()

manager.close()
writer.close()
