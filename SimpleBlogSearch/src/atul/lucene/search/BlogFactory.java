package atul.lucene.search;


/**
 * @class BlogFactory
 * 
 * @brief To create some fake data
 * 
 * @author atul
 *
 */
public class BlogFactory 
{
	public static Blog[] BLOGS = {
									new Blog("1", "blog 1", "This is blog one", "foo"),
									new Blog("2", "blog 2", "This is blog two", "foo"),
									new Blog("3", "blog 3", "This is blog three", "foo"),
									new Blog("4", "blog 4", "This is blog four", "foo"),
									new Blog("5", "blog 5", "This is blog five", "foo"),
									new Blog("6", "blog 6", "This is blog six", "foo"),
									new Blog("7", "blog 7", "This is blog seven", "foo"),
									new Blog("8", "blog 8", "This is blog eight", "foo"),
									new Blog("9", "blog 9", "This is blog nini", "foo"),
									new Blog("10", "blog 10", "This is blog ten", "foo"),
									new Blog("11", "blog 11", "This is blog eleven", "foo"),
									new Blog("12", "blog 12", "This is blog twelve", "foo"),
									new Blog("13", "blog 13", "This is blog thirteen", "foo"),
									new Blog("14", "blog 14", "This is blog fourteen", "foo"),
									new Blog("15", "blog 15", "This is blog fifteen", "foo"),
									new Blog("16", "blog 16", "This is blog sixteen", "foo"),
									new Blog("17", "blog 17", "This is blog seventeen", "foo"),
									new Blog("18", "blog 18", "This is blog eighteen", "foo"),
									new Blog("19", "blog 19", "This is blog ninteen", "foo"),
									new Blog("20", "blog 20", "Google. Software engineer lives on it", "programmer")
								 };
	public static Blog[] getBlogs()
	{
		return BLOGS;
	}
	
	public static Blog getBlog(String id)
	{
		for(Blog blog : BLOGS)
		{
			if(id.equals(blog.Id()))
				return blog;
		}
		
		return null;
	}

}
