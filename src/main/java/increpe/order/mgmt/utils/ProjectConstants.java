package increpe.order.mgmt.utils;

import java.util.Locale;

/**
 * 
 *
 * 
 */
public final class ProjectConstants {

	// FIXME : Customize project constants for your application.

	public static final String DEFAULT_ENCODING = "UTF-8";
	
	public static final Long[] USER_ROLE_TYPE_ID_ARRAY = {1L, 2L, 3L};
	
	public static final Long[] COMPANY_TYPE_ID_ARRAY = {1L, 2L, 3L}; 

	public static final String PROJECT_BASE_PACKAGE = "increpe.order.mgmt";

	public static final Locale LOCALE_INDIA = new Locale.Builder().setLanguage("en").setRegion("IN").build();
	
	public static final String ACTIVE_STATUS = "ACTIVE";
	
	public static final String INACTIVE_STATUS = "INACTIVE";

	private ProjectConstants() {

		throw new UnsupportedOperationException();
	}

}
