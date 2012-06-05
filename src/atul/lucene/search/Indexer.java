package atul.lucene.search;

import java.io.File;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * @class Indexer
 * 
 * @brief This class created the indexes in the directory "indexes"
 * 
 * @note If the directory does not exists it will be created
 * 
 * @author atul
 *
 */
public class Indexer 
{
	public Indexer()
	{
		
	}
	
	public void buildIndexes()
	{
		getIndexWriter(true);
		
		Blog[] blogs = BlogFactory.getBlogs();
		
		for(Blog blog : blogs)
			indexBlog(blog);
		
		closeIndexWriter();
	}
	
	/*
	 * This is the main part where indexes are built. It shows how the blog object is used
	 * to create a document
	 */
	private void indexBlog(Blog blog)
	{
		System.out.println("Indexing Blog");
		IndexWriter writer = getIndexWriter(true);
		
		try
		{
			Document doc = new Document();
			
			doc.add(new Field("id", blog.Id(), Field.Store.YES, Field.Index.NO));
			doc.add(new Field("owner", blog.Owner(), Field.Store.YES, Field.Index.NOT_ANALYZED));
			doc.add(new Field("title", blog.Title(), Field.Store.YES, Field.Index.ANALYZED));
			doc.add(new Field("description", blog.Description(), Field.Store.YES, Field.Index.ANALYZED));
			doc.add(new Field("content", blog.toString(), Field.Store.NO, Field.Index.ANALYZED));			
			
			writer.addDocument(doc);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	/*
	 * Creates IndexWriter object if its not already created. THe "dir" param in the 
	 * IndexWriter constructor specifies the directory where indexes are created
	 * 
	 */
	private IndexWriter getIndexWriter(boolean create)
	{
		if(mIndexWriter == null)
		{
			try 
			{
				FSDirectory dir = FSDirectory.open(new File("indexes"));
				StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_36);
				IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_36, analyzer); 
				mIndexWriter = new IndexWriter(dir, config);
			}
			catch(Exception e)
			{
				System.out.println("Error while creating IndexWeiter");
				return null;
			}
		}
		
		return mIndexWriter;
	}
	
	/*
	 * Closes the Index Writer
	 */
	private void closeIndexWriter()
	{
		try
		{
			System.out.println("Closing IndexWeiter");
			if(mIndexWriter != null)
				mIndexWriter.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private IndexWriter mIndexWriter = null;

}
