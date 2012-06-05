package atul.lucene.search;

import java.io.File;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * @class SearchEngine
 * 
 * @brief This class searches the indexes based on the query
 * 		  
 * @note  The IndexSearcher searches indexes build by Indexer.java
 * 
 * 
 * @author atul
 *
 */
public class SearchEngine 
{
	public SearchEngine()
	{
		init();
	}
	
	/*
	 * Perform the search based on the query provided
	 */
	public TopScoreDocCollector performSearch(String queryString)
	{
		System.out.println("Searching...");
		
		TopScoreDocCollector collector = null;
		
		try 
		{
			Query query = mParser.parse(queryString);
			
			collector = TopScoreDocCollector.create(10, true);
			mIndexSearcher.search(query, collector);
			
		} catch (Exception e) 
		{
			return null;
		}
		
		return collector;
		
	}
	
	/*
	 * Retrieves document from a document id
	 */
	public Document getDocumentFromId(int id)
	{
		try 
		{
			Document doc =  mIndexSearcher.doc(id);	
			return doc;
		} 
		catch (Exception e) 
		{
			return null;
		}
		
	}
	
	/*
	 * Initializes the search engine
	 */
	private void init()
	{
		System.out.println("Initializing SearchEngine");
		
		FSDirectory dir = null;
		IndexReader reader = null;		
		
		try 
		{
			dir = FSDirectory.open(new File("indexes"));
			reader = IndexReader.open(dir);	
			mIndexSearcher = new IndexSearcher(reader);
		}
		catch (Exception e) 
		{
			System.out.println("ERROR in SearchEngine");
		}
		
		StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);
		
		/*
		 * Create the parser object. Note that "content" is the default
		 * field to used in the search if no other field is specified
		 */
		mParser = new QueryParser(Version.LUCENE_36, "content", analyzer);
			
	}
	
	private IndexSearcher mIndexSearcher;
	private QueryParser mParser;
	

}
