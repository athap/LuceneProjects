package atul.lucene.search;

/**
 * @class Blog
 * 
 * @brief POJO describing a blog
 * 
 * @author atul
 *
 */
public class Blog 
{
	/*
	 * 
	 */
	public Blog(String id, String title, String desc, String owner)
	{
		this.mId = id;
		this.mDescription = desc;
		this.mOwner = owner;
		this.mTitle = title;
	}
	
	public String Id() 
	{
		return mId;
	}
	
	public void Id(String id) 
	{
		this.mId = id;
	}
	
	public String Description() 
	{
		return mDescription;
	}
	
	public void Description(String description) 
	{
		this.mDescription = description;
	}
	
	public String Owner() 
	{
		return mOwner;
	}
	
	public void Owner(String owner) 
	{
		this.mOwner = owner;
	}
	
	public String Title() 
	{
		return mTitle;
	}
	
	public void Title(String title) 
	{
		this.mTitle = title;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		StringBuilder blog = new StringBuilder();
		blog.append("Blog ");
		blog.append(this.mId);
		blog.append(": ");
		blog.append(this.mOwner);
		blog.append(": ");
		blog.append(this.mTitle);
		blog.append(": ");
		blog.append(this.mDescription);
		return blog.toString();
	}
	
	private String mId;
	private String mDescription;
	private String mOwner;
	private String mTitle;

}
