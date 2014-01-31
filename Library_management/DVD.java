package bibliothek210;

public class DVD extends LibraryHolding{
	
	private String title;
	private String director;
	private static final int checkoutDuration = 14;
	
	/**
	 * Constructor for the DVD class
	 * Sets the title and director
	 * 
	 * @param title: the DVD's title
	 * @param director: the DVD's director
	 */
	public DVD( String title, String director ) {
		super( );
		this.title = title;
		this.director = director;
	}
	
	/**
	 * @return the checkout duration in number of days
	 */
	@Override
	public int getCheckoutDuration( ) {
		return checkoutDuration;
	}
	
	@Override
	public String getStringRepresentation( ) {
		return "<DVD>\n<title>"+title+"</title>\n<director>"+director+"</director>\n</DVD>";
	}
	
	@Override
	public String holdingType( ) {
		return "DVD";
	}
	
}

