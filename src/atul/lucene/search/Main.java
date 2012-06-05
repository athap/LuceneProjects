package atul.lucene.search;

import org.apache.lucene.document.Document;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;

public class Main 
{
	public static void main(String[] args) 
	{
		Indexer indexer = new Indexer();
		indexer.buildIndexes();
		
		SearchEngine google = new SearchEngine();
		
		TopScoreDocCollector results = google.performSearch("programmer");
		
		if(results == null)
			return;
		
		ScoreDoc[] hits =  results.topDocs().scoreDocs;
		
		System.out.println("Total hits " + hits.length);
		
		for(ScoreDoc hit : hits)
		{
			Document document = google.getDocumentFromId(hit.doc);
			System.out.println("Result " + document.get("description"));
		}
	}

}
